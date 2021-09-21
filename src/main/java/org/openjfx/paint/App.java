package org.openjfx.paint;

import org.openjfx.paint.Controller.TestController;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

public class App extends Application {

	private static Scene scene;
	
	private static Stage pStage;
	
	 @Override
	    public void start(Stage primaryStage) throws Exception {


	        Parent root  = FXMLLoader.load(getClass().getResource("mainWindow.fxml"));
	        
	        scene = new Scene(root);
	        
	        //scene.getStylesheets().add("/org/calma/ETC/CSS/style.css");
	        
	        primaryStage.setScene(scene);

	        primaryStage.setTitle("Paint Java");

	        primaryStage.show();
	        
	        new TestController().Luncher(primaryStage);
	        pStage = primaryStage;
	    }

	    public static void main(String[] args) {
	        launch(args);
	    }
	    
	    public static Stage getScene() {
	    	return pStage;
	    }
}