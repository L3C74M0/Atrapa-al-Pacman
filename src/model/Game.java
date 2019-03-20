package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

public class Game implements Serializable {
	private Score[] scores;
	public static final String SERIALIZED_FILE = "data/scores.cpk";

	public Game() throws ClassNotFoundException, IOException {
		scores = new Score[9];
		load();
	}

	public Score[] getScores() {
		return scores;
	}

	public void recordScore(int level, String name, int score) {
		Score scoreUser = new Score(score, name, level);
		scores[0] = scoreUser;
	}

	public void load() throws IOException, ClassNotFoundException {
		File file = new File(SERIALIZED_FILE);
		if (file.exists()) {
			ObjectInputStream loadedFile = new ObjectInputStream(new FileInputStream(file));
			scores = (Score[]) loadedFile.readObject();
			loadedFile.close();
		} else {
			Score scoreUser = new Score(0, "", 0);
			scores[0] = scoreUser;
			scores[1] = scoreUser;
			scores[2] = scoreUser;
			scores[3] = scoreUser;
			scores[4] = scoreUser;
			scores[5] = scoreUser;
			scores[6] = scoreUser;
			scores[7] = scoreUser;
			scores[8] = scoreUser;
			scores[9] = scoreUser;
		}
	}
}
