package dalobo.grpc.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dalobo.grpc.deposit.DepositGrpc;
import dalobo.grpc.deposit.DepositRequest;
import dalobo.grpc.deposit.DepositResponse;
import dalobo.grpc.hibernate.manager.WalletManager;
import dalobo.grpc.hibernate.model.Wallet;
import io.grpc.stub.StreamObserver;

public class DepositService extends DepositGrpc.DepositImplBase {
	private static final Logger LOGGER = LoggerFactory.getLogger(DepositService.class);

	@Override
	public void doDeposit(DepositRequest req, StreamObserver<DepositResponse> responseObserver) {
		responseObserver.onNext(doDeposit(req));
		responseObserver.onCompleted();
	}

	private DepositResponse doDeposit(DepositRequest depositRequest) {
		LOGGER.debug("Deposit Request for user id: " + depositRequest.getUserId() + ", amount: "
				+ depositRequest.getAmount() + ", currency: " + depositRequest.getCurrency());

		if (depositRequest.getCurrency() == null) {
			LOGGER.debug("Deposit for user id: " + depositRequest.getUserId() + " is missing currency");
			return DepositResponse.newBuilder().setErrorMessage("Missing Currency").build();
		}

		Wallet wallet = new Wallet(depositRequest.getUserId(), depositRequest.getCurrency(),
				depositRequest.getAmount());

		WalletManager.getInstance().deposit(wallet);

		return DepositResponse.newBuilder().build();
	}
}