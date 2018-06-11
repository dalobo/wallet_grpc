FROM openjdk:8-jdk

RUN apt-get update && apt-get install -y git gradle

RUN mkdir /usr/dalobo

WORKDIR /usr/dalobo

RUN git clone https://github.com/dalobo/wallet_grpc.git

WORKDIR wallet_grpc/

RUN gradle installDist