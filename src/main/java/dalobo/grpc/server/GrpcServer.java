package dalobo.grpc.server;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import dalobo.grpc.hibernate.util.HibernateUtil;
import dalobo.grpc.service.BalanceService;
import dalobo.grpc.service.DepositService;
import dalobo.grpc.service.WithdrawService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

/**
 * Server that manages startup/shutdown of the Grpc server.
 */
public class GrpcServer {
	private static final Logger LOGGER = LoggerFactory.getLogger(GrpcServer.class);
	private Server server;

	public void start() throws IOException {
		/*
		 ** The port on which the server should run
		 */
		int port = 50051;
		LOGGER.info("Starting server in port: " + port);
		server = ServerBuilder.forPort(port).addService(new DepositService()).addService(new BalanceService())
				.addService(new WithdrawService()).build().start();

		LOGGER.info("Server started with services: " + server.getServices());

		Runtime.getRuntime().addShutdownHook(new Thread() {
			@Override
			public void run() {
				// Use stderr here since the logger may have been reset by its JVM shutdown
				// hook.
				GrpcServer.this.stop();
			}
		});
	}

	public void stop() {
		if (server != null) {
			LOGGER.info("Shutting down server");
			server.shutdown();
		}
		LOGGER.info("Server shut down");
		LOGGER.info("Shutting down Hibernate");
		HibernateUtil.shutdown();
		LOGGER.info("Hibernate shut down");
	}

	/**
	 * Await termination on the main thread since the grpc library uses daemon
	 * threads.
	 */
	public void blockUntilShutdown() throws InterruptedException {
		if (server != null) {
			server.awaitTermination();
		}
	}

	/**
	 * Main launches the server from the command line.
	 */

	public static void main(String[] args) throws IOException, InterruptedException {
		final GrpcServer server = new GrpcServer();
		server.start();
		server.blockUntilShutdown();
	}
}