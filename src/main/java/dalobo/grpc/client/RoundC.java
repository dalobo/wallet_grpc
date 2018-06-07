package dalobo.grpc.client;

import dalobo.grpc.balance.BalanceRequest;
import dalobo.grpc.currency.Currency;
import dalobo.grpc.deposit.DepositRequest;
import dalobo.grpc.withdraw.WithdrawRequest;

public class RoundC extends AbstractRound {

	public RoundC(GrpcClient client) {
		super(client);
	}

	@Override
	void runRound(long userId) {
		// Get Balance
		client.getBalanceBlockingStub().getBalance(BalanceRequest.newBuilder().setUserId(userId).build());
		// Deposit 100 USD
		client.getDepoistBlockingStub().doDeposit(
				DepositRequest.newBuilder().setAmount(100).setCurrency(Currency.USD).setUserId(userId).build());
		// Deposit 100 USD
		client.getDepoistBlockingStub().doDeposit(
				DepositRequest.newBuilder().setAmount(100).setCurrency(Currency.USD).setUserId(userId).build());
		// Withdraw 100 USD
		client.getWithdrawBlockingStub().withdraw(
				WithdrawRequest.newBuilder().setAmount(100).setCurrency(Currency.USD).setUserId(userId).build());
		// Deposit 100 USD
		client.getDepoistBlockingStub().doDeposit(
				DepositRequest.newBuilder().setAmount(100).setCurrency(Currency.USD).setUserId(userId).build());
		// Get Balance
		client.getBalanceBlockingStub().getBalance(BalanceRequest.newBuilder().setUserId(userId).build());
		// Withdraw 100 USD
		client.getWithdrawBlockingStub().withdraw(
				WithdrawRequest.newBuilder().setAmount(200).setCurrency(Currency.USD).setUserId(userId).build());
		// Get Balance
		client.getBalanceBlockingStub().getBalance(BalanceRequest.newBuilder().setUserId(userId).build());
	}
}
