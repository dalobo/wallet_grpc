# wallet_grpc

This project consists of a wallet server and a wallet client. The wallet server will keep track of a users monetary balance in the system. The client will emulate users depositing and withdrawing funds.

Main Technologies used:
* Java
* gRPC
* Hibernate
* PostgreSQL
* Gradle
* JUnit
* SLF4J

Before installing, make sure you have a postgresql running in localhost:5432. Please, set your user/password and database in hibernate.cfg.xml.

This project is not working in Docker yet. 

To build the examples, run in this directory:

	./gradlew installDist

This creates the scripts grpc-server and grpc-client in the build/install/examples/bin/ directory that run the examples. Each example requires the server to be running before starting the client.

First run the server:

	./build/install/WalletServer/bin/grpc-server

And in a different terminal window run the client:

	./build/install/WalletServer/bin/grpc-client users=1 concurrent_threads_per_user=1 rounds_per_thread=1
	
The wallet client has the following CLI parameters:
* users (number of concurrent users emulated)
* concurrent_threads_per_user (number of concurrent requests a user will make)
* rounds_per_thread (number of rounds each thread is executing)

To run the integration test:

	./gradlew test
