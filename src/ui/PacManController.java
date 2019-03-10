package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import model.PacMan;

public class PacManController {
	private PacMan pacMan;
	ArrayList<PacMan> pacMen = new ArrayList();
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void initialize() {

    }
    
   
    public void loadLevel(String filePath) {
		try {
			FileReader levels = new FileReader(filePath);
			BufferedReader br= new BufferedReader(levels);
			String x = br.readLine();
			String[] configuration = x.split("\t");
			while (x!=null) {
				double radio = Integer.parseInt(configuration[0]);
				double posX=  Integer.parseInt(configuration[1]);
				double posY=  Integer.parseInt(configuration[2]);
				int wait =  Integer.parseInt(configuration[3]);
				String direction = configuration[4];
				int bounces = Integer.parseInt(configuration[5]);
				boolean stoped;
				if(configuration[5].equalsIgnoreCase("false")) 
					stoped=false;
				else
					stoped = true;
				
				System.out.println("radio"+radio+"\nposX"+posX);
				pacMan = new PacMan(radio,posX,posY,wait,direction,bounces,stoped);
				pacMen.add(pacMan);
				x=br.readLine();
				
			}
		}catch (Exception e) {
			System.out.println("no");
		}
		
	}
}
