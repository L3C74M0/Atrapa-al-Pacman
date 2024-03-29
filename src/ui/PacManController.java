package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.stage.StageStyle;
import model.Game;
import model.PacMan;

public class PacManController {
	private ArrayList<PacMan> pacMen;
	private final static String PATH_FILE = "data/Scores.cpk";

	@FXML
	private Pane pane;

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;

	@FXML
	private MenuItem level0;

	@FXML
	private MenuItem level1;

	@FXML
	private MenuItem level2;

	@FXML
	private MenuItem HighScores;

	@FXML
	private MenuItem AboutGame;

	@FXML
	private Arc pacMan;

	@FXML
	private Label score;

	@FXML
	void Exit(ActionEvent event) {
		System.exit(0);
	}

	@FXML
	void loadLevel0(ActionEvent event){		
		String path = "./levels/level0.txt";
		loadLevel(path);
		add();
	}

	@FXML
	void loadLevel1(ActionEvent event){
		String path = "levels/level1.txt";
		loadLevel(path);
		add();
	}

	@FXML
	void loadLevel2(ActionEvent event){
		String path = "levels/level2.txt";
		loadLevel(path);
		add();
	}

	@FXML
	void saveGame(ActionEvent event) {
		try {
			Game game = new Game();
			game.save();
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void initialize() {
		pacMen = new ArrayList<PacMan>();
	}

	@FXML
	void ShowHighScores(ActionEvent event) {
		try {
			Game score= new Game();
	    	Alert info = new Alert(AlertType.CONFIRMATION);
	    	info.setTitle("High Scores capture the Pac-Man");
	    	//info.setHeaderText(null);
	    	info.initStyle(StageStyle.UTILITY);
	    	info.setContentText(score.showBestScores());
	    	info.show();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void AboutGame(ActionEvent event){
		Alert info = new Alert(AlertType.CONFIRMATION);
    	info.setTitle("About capture the Pac-Man");
    	info.setHeaderText(null);
    	info.initStyle(StageStyle.UTILITY);
    	info.setContentText("To win you have to stop all the pacmans \n in the less time you can");
    	info.show();
	}

	public void loadLevel(String filePath) {
		try {
			FileReader levels = new FileReader(filePath);
			BufferedReader br = new BufferedReader(levels);
			String line = br.readLine();
			while (line != null) {
				String[] configuration = line.split("\t");
				double radio = Integer.parseInt(configuration[0]);
				double posX = Integer.parseInt(configuration[1]);
				double posY = Integer.parseInt(configuration[2]);
				int wait = Integer.parseInt(configuration[3]);
				String direction = configuration[4];
				int bounces = Integer.parseInt(configuration[5]);
				boolean stoped = false;
				if (configuration[6].equalsIgnoreCase("false")) {
					stoped = false;
				} else {
					stoped = true;
				}
				PacMan pacMan = new PacMan(radio, posX, posY, wait, direction, bounces, stoped);
				pacMen.add(pacMan);
				line = br.readLine();
			}
			br.close();
			levels.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

	public void add() {
		for (int i = 0; i < pacMen.size(); i++) {
			pacMan = new Arc(pacMen.get(i).getPosX(), pacMen.get(i).getPosX(), pacMen.get(i).getRadio(), pacMen.get(i).getRadio(), 32, 300);
			pacMan.setFill(Color.YELLOW);
			pacMan.setStroke(Color.BLACK);
			pacMan.setStrokeWidth(3);
			pacMan.setType(ArcType.ROUND);
			pane.getChildren().add(pacMan);
		}
	}

}
