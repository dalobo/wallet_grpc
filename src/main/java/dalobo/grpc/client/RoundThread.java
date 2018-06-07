package dalobo.grpc.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RoundThread extends Thread {
	private Random randomGenerator;
	private List<AbstractRound> rounds;
	private long userId;
	private int roundsPerThread;

	public RoundThread(long userId, int roundsPerThread, GrpcClient client) {
		this.userId = userId;
		this.roundsPerThread = roundsPerThread;
		randomGenerator = new Random();
		rounds = new ArrayList<AbstractRound>();

		rounds.add(new RoundA(client));
		rounds.add(new RoundB(client));
		rounds.add(new RoundC(client));
	}

	public void run() {
		for (int counter = 0; counter < roundsPerThread; counter++) {
			int index = randomGenerator.nextInt(rounds.size());
			AbstractRound round = rounds.get(index);
			round.runRound(userId);
		}
	}
}
