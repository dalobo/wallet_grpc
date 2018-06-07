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

To build the examples, run in this directory:

	./gradlew installDist

This creates the scripts grpc-server and grpc-client in the build/install/examples/bin/ directory that run the examples. Each example requires the server to be running before starting the client.

For example, to try the hello world example first run:

	./build/install/WalletServer/bin/grpc-server

And in a different terminal window run:

	./build/install/WalletServer/bin/grpc-client

To run the tests:

	./gradlew test
