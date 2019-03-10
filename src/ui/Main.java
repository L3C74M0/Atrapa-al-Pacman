package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("window.fxml"));
		Scene scene = new Scene(root);
		stage.setTitle("Captura al Pac-man");
		stage.setScene(scene);
		stage.show();
	}
}

/**
 * private void loadDictionary(){ String filePath=""; if(topic==TOPIC_ANIMALS){
 * filePath="resourses/Animals.txt"; }else if(topic==TOPIC_BRANDS){
 * filePath="resourses/Brands.txt"; }else if(topic==TOPIC_CULTURE){
 * filePath="resourses/Culture.txt"; }else if(topic==TOPIC_PLANTS){
 * filePath="resourses/Plants.txt"; }else if(topic==TOPIC_SPORTS){
 * filePath="resourses/Sports.txt"; } try{ FileReader fr=new
 * FileReader(filePath); BufferedReader br=new BufferedReader(fr); String
 * sCurrentLine=br.readLine(); while(sCurrentLine!=null){
 * dictionary.add(sCurrentLine); sCurrentLine=br.readLine(); } }catch(Exception
 * e){ e.printStackTrace(); } }
 */