package dalobo.grpc.client;

import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dalobo.grpc.balance.BalanceGrpc;
import dalobo.grpc.balance.BalanceGrpc.BalanceBlockingStub;
import dalobo.grpc.balance.BalanceRequest;
import dalobo.grpc.balance.BalanceResponse;
import dalobo.grpc.currency.Currency;
import dalobo.grpc.deposit.DepositGrpc;
import dalobo.grpc.deposit.DepositGrpc.DepositBlockingStub;
import dalobo.grpc.deposit.DepositRequest;
import dalobo.grpc.deposit.DepositResponse;
import dalobo.grpc.withdraw.WithdrawGrpc;
import dalobo.grpc.withdraw.WithdrawGrpc.WithdrawBlockingStub;
import dalobo.grpc.withdraw.WithdrawRequest;
import dalobo.grpc.withdraw.WithdrawResponse;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusRuntimeException;

public class GrpcClient {
	private static final Logger LOGGER = LoggerFactory.getLogger(GrpcClient.class);

	private final ManagedChannel channel;
	private final DepositBlockingStub depoistBlockingStub;
	private final BalanceBlockingStub balanceBlockingStub;
	private final WithdrawBlockingStub withdrawBlockingStub;

	/** Construct client server at {@code host:port}. */
	public GrpcClient(String host, int port) {
		this(ManagedChannelBuilder.forAddress(host, port).usePlaintext().build());
		LOGGER.info("Client started for host: " + host + ", port: " + port);
	}

	GrpcClient(ManagedChannel channel) {
		this.channel = channel;
		depoistBlockingStub = DepositGrpc.newBlockingStub(channel);
		balanceBlockingStub = BalanceGrpc.newBlockingStub(channel);
		withdrawBlockingStub = WithdrawGrpc.newBlockingStub(channel);
	}

	public void shutdown() throws InterruptedException {
		LOGGER.info("Shutting down client");
		channel.shutdown().awaitTermination(5, TimeUnit.SECONDS);
		LOGGER.info("Shut down client");
	}

	/** Send deposit to server. */
	public void deposit() {
		LOGGER.debug("Will try to deposit");
		DepositRequest request = DepositRequest.newBuilder().setUserId(1).setCurrency(Currency.EUR).setAmount(99)
				.build();
		DepositResponse response;
		try {
			response = depoistBlockingStub.doDeposit(request);
		} catch (StatusRuntimeException e) {
			LOGGER.debug("RPC failed: " + e.getStatus());
			return;
		}
		LOGGER.debug("Message: " + response.getErrorMessage());
	}

	public BalanceResponse balance() {
		LOGGER.debug("Will try to get balance");
		BalanceRequest request = BalanceRequest.newBuilder().setUserId(1).build();

		BalanceResponse response = null;

		try {
			response = balanceBlockingStub.getBalance(request);
		} catch (StatusRuntimeException e) {
			LOGGER.debug("RPC failed: " + e.getStatus());
			return null;
		}

		LOGGER.debug("Received: " + response.getBalanceForCurrencyList().get(0).getAmount() + " "
				+ response.getBalanceForCurrencyList().get(0).getCurrency());

		return response;
	}

	public void withdraw() {
		LOGGER.debug("Will try to withdraw");
		WithdrawRequest request = WithdrawRequest.newBuilder().setUserId(1).setAmount(60).setCurrency(Currency.EUR)
				.build();

		WithdrawResponse response;

		try {
			response = withdrawBlockingStub.withdraw(request);
		} catch (StatusRuntimeException e) {
			LOGGER.debug("RPC failed: " + e.getStatus());
			return;
		}

		LOGGER.debug("Widraw Received: " + response.getErrorMessage());
	}

	public DepositBlockingStub getDepoistBlockingStub() {
		return depoistBlockingStub;
	}

	public BalanceBlockingStub getBalanceBlockingStub() {
		return balanceBlockingStub;
	}

	public WithdrawBlockingStub getWithdrawBlockingStub() {
		return withdrawBlockingStub;
	}
}
