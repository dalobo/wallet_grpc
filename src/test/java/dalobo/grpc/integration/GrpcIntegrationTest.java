package dalobo.grpc.integration;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dalobo.grpc.balance.BalanceForCurrency;
import dalobo.grpc.balance.BalanceRequest;
import dalobo.grpc.balance.BalanceResponse;
import dalobo.grpc.client.GrpcClient;
import dalobo.grpc.currency.Currency;
import dalobo.grpc.deposit.DepositRequest;
import dalobo.grpc.server.GrpcServer;
import dalobo.grpc.withdraw.WithdrawRequest;
import dalobo.grpc.withdraw.WithdrawResponse;

public class GrpcIntegrationTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(GrpcIntegrationTest.class);
	private static final String INSUFFFICIENT_FUNDS_MESSAGE = "insufficient_funds";
	private static final String OK_MESSAGE = "ok";
	private final GrpcServer server = new GrpcServer();
	private GrpcClient client;

	@Before
	public void setup() {
		Thread serverThread = new Thread() {
			public void run() {
				try {
					server.start();
					server.blockUntilShutdown();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		};
		serverThread.start();
	}

	@Test
	public void testGrpc() {
		client = new GrpcClient("localhost", 50051);

		// 1 Make a withdrawal of USD 200 for user with id 1. Must return
		// "insufficient_funds".
		WithdrawResponse withdrawResponse = client.getWithdrawBlockingStub()
				.withdraw(WithdrawRequest.newBuilder().setUserId(1).setAmount(200).setCurrency(Currency.USD).build());
		assertEquals(INSUFFFICIENT_FUNDS_MESSAGE, withdrawResponse.getErrorMessage());

		// 2 Make a deposit of USD 100 to user with id 1.
		client.getDepoistBlockingStub()
				.doDeposit(DepositRequest.newBuilder().setUserId(1).setAmount(100).setCurrency(Currency.USD).build());

		// 3 Check that all balances are correct
		BalanceResponse balanceResponse = client.getBalanceBlockingStub()
				.getBalance(BalanceRequest.newBuilder().setUserId(1).build());
		List<BalanceForCurrency> balances = balanceResponse.getBalanceForCurrencyList();
		assertNotNull(balances);
		assertEquals(1, balances.size());

		BalanceForCurrency balanceForCurrency = balances.get(0);
		assertEquals(100, balanceForCurrency.getAmount(), 0);
		assertEquals(Currency.USD, balanceForCurrency.getCurrency());

		// 4 Make a withdrawal of USD 200 for user with id 1. Must return
		// "insufficient_funds".
		withdrawResponse = client.getWithdrawBlockingStub()
				.withdraw(WithdrawRequest.newBuilder().setUserId(1).setAmount(200).setCurrency(Currency.USD).build());
		assertEquals(INSUFFFICIENT_FUNDS_MESSAGE, withdrawResponse.getErrorMessage());

		// 5 Make a deposit of EUR 100 to user with id 1.
		client.getDepoistBlockingStub()
				.doDeposit(DepositRequest.newBuilder().setUserId(1).setAmount(100).setCurrency(Currency.EUR).build());

		// 6 Check that all balances are correct
		balanceResponse = client.getBalanceBlockingStub().getBalance(BalanceRequest.newBuilder().setUserId(1).build());
		balances = balanceResponse.getBalanceForCurrencyList();
		assertNotNull(balances);
		assertEquals(2, balances.size());

		for (BalanceForCurrency balance : balances) {
			if (balance.getCurrency().equals(Currency.USD)) {
				assertEquals(100, balance.getAmount(), 0);
			} else if (balance.getCurrency().equals(Currency.EUR)) {
				assertEquals(100, balance.getAmount(), 0);
			} else {
				fail();
			}
		}

		// 7 Make a withdrawal of USD 200 for user with id 1. Must return
		// "insufficient_funds".
		withdrawResponse = client.getWithdrawBlockingStub()
				.withdraw(WithdrawRequest.newBuilder().setUserId(1).setAmount(200).setCurrency(Currency.USD).build());
		assertEquals(INSUFFFICIENT_FUNDS_MESSAGE, withdrawResponse.getErrorMessage());

		// 8 Make a deposit of USD 100 to user with id 1.
		client.getDepoistBlockingStub()
				.doDeposit(DepositRequest.newBuilder().setUserId(1).setAmount(100).setCurrency(Currency.USD).build());

		// 9 Check that all balances are correct
		balanceResponse = client.getBalanceBlockingStub().getBalance(BalanceRequest.newBuilder().setUserId(1).build());
		balances = balanceResponse.getBalanceForCurrencyList();
		assertNotNull(balances);
		assertEquals(2, balances.size());

		for (BalanceForCurrency balance : balances) {
			if (balance.getCurrency().equals(Currency.USD)) {
				assertEquals(200, balance.getAmount(), 0);
			} else if (balance.getCurrency().equals(Currency.EUR)) {
				assertEquals(100, balance.getAmount(), 0);
			} else {
				fail();
			}
		}

		// 10 Make a withdrawal of USD 200 for user with id 1.
		withdrawResponse = client.getWithdrawBlockingStub()
				.withdraw(WithdrawRequest.newBuilder().setUserId(1).setAmount(200).setCurrency(Currency.USD).build());
		assertEquals(OK_MESSAGE, withdrawResponse.getErrorMessage());

		// 11 Check that all balances are correct
		balanceResponse = client.getBalanceBlockingStub().getBalance(BalanceRequest.newBuilder().setUserId(1).build());
		balances = balanceResponse.getBalanceForCurrencyList();
		assertNotNull(balances);
		assertEquals(2, balances.size());

		for (BalanceForCurrency balance : balances) {
			if (balance.getCurrency().equals(Currency.USD)) {
				assertEquals(0, balance.getAmount(), 0);
			} else if (balance.getCurrency().equals(Currency.EUR)) {
				assertEquals(100, balance.getAmount(), 0);
			} else {
				fail();
			}
		}

		// 12 Make a withdrawal of USD 200 for user with id 1. Must return
		// "insufficient_funds".
		withdrawResponse = client.getWithdrawBlockingStub()
				.withdraw(WithdrawRequest.newBuilder().setUserId(1).setAmount(200).setCurrency(Currency.USD).build());
		assertEquals(INSUFFFICIENT_FUNDS_MESSAGE, withdrawResponse.getErrorMessage());
	}

	@After
	public void shutdown() {
		if (client != null) {
			try {
				client.shutdown();
			} catch (InterruptedException clientException) {
				LOGGER.error("Error to shutdown client: ", clientException);
			}
		}
		server.stop();
	}
}
