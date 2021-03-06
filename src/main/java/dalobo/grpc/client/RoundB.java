package dalobo.grpc.client;

import dalobo.grpc.currency.Currency;
import dalobo.grpc.deposit.DepositRequest;
import dalobo.grpc.withdraw.WithdrawRequest;

public class RoundB extends AbstractRound {

	public RoundB(GrpcClient client) {
		super(client);
	}

	@Override
	void runRound(long userId) {
		// Withdraw 100 GBP
		client.getWithdrawBlockingStub().withdraw(
				WithdrawRequest.newBuilder().setAmount(100).setCurrency(Currency.GBP).setUserId(userId).build());
		// Deposit 300 GPB
		client.getDepoistBlockingStub().doDeposit(
				DepositRequest.newBuilder().setAmount(300).setCurrency(Currency.GBP).setUserId(userId).build());
		// Withdraw 100 GBP
		client.getWithdrawBlockingStub().withdraw(
				WithdrawRequest.newBuilder().setAmount(100).setCurrency(Currency.GBP).setUserId(userId).build());
		// Withdraw 100 GBP
		client.getWithdrawBlockingStub().withdraw(
				WithdrawRequest.newBuilder().setAmount(100).setCurrency(Currency.GBP).setUserId(userId).build());
		// Withdraw 100 GBP
		client.getWithdrawBlockingStub().withdraw(
				WithdrawRequest.newBuilder().setAmount(100).setCurrency(Currency.GBP).setUserId(userId).build());
	}
}
