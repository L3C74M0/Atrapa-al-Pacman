package model;


public class PacMan {
	public final static int LEFT = 1;
	public final static int RIGHT = 2;
	public final static int UP = 3;
	public final static int DOWN = 4;
	private double radio;
	private double posX;
	private double posY;
	private int wait;
	private String direction;
	private int bounces;
	private boolean stoped;

	public PacMan(double radio, double posX,double posY,int wait,String direction,int bounces,boolean stoped) {
		this.radio=radio;
		this.posX=posX;
		this.posY=posY;
		this.wait=wait;
		this.direction=direction;
		this.bounces=bounces;
		this.stoped=stoped;
	}

	

	public double getPosX() {
		return posX;
	}

	public void setPosX(double posX) {
		this.posX = posX;
	}

	public int getWait() {
		return wait;
	}

	public void setWait(int wait) {
		this.wait = wait;
	}

	public double getRadio() {
		return radio;
	}

	public void setRadio(double radio) {
		this.radio = radio;
	}

	public int getBounces() {
		return bounces;
	}

	public void setBounces(int bounces) {
		this.bounces = bounces;
	}

	public boolean isStoped() {
		return stoped;
	}

	public void setStoped(boolean stoped) {
		this.stoped = stoped;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public double getPosY() {
		return posY;
	}

	public void setPosY(double posY) {
		this.posY = posY;
	}

}
