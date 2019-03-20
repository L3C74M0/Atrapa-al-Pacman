package model;

import java.io.Serializable;

public class Score implements Serializable{
	int score;
	String nameUser;
	int level;

	public Score(int score,String nameUser,int level) {
		this.score=score;
		this.nameUser=nameUser;
		this.level=level;
	}
	
	public int getScore() {
		return score;
	}
	
	public String getName() {
		return nameUser;
	}
	
	public int getLevel() {
		return level;
	}
	
}
