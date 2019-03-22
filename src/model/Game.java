package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Game {
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
		if (!file.exists()) {
			ObjectInputStream loadedFile = new ObjectInputStream(new FileInputStream(file));
			Score[] scores = (Score[]) loadedFile.readObject();
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
		}
	}

	public String showBestScores() {
		String information = "High Scores: \n\n";
		order();
		for (int i = 0; i < scores.length && scores[i] != null; i++) {
			information += (i + 1) + ".	 " + scores[i].getScore() + "\n";
			information += "\n";
		}
		return information;
	}

	public void order() {
		Score best = null;
		for (int i = 0; i < scores.length; i++) {
			for (int j = i + 1; j < scores.length && scores[j] != null; j++) {
				if (scores[i].getScore() < scores[j].getScore()) {
					best = scores[i];
					scores[i] = scores[j];
					scores[j] = best;
				}
			}
		}
	}
	
	public void save() throws FileNotFoundException, IOException {
		ObjectOutputStream escribiendo_fichero = new ObjectOutputStream(new FileOutputStream(SERIALIZED_FILE));
		escribiendo_fichero.writeObject(scores);
		escribiendo_fichero.close();
	}
}
