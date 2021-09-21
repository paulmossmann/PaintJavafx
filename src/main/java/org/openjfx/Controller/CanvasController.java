package org.openjfx.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

public class CanvasController implements Initializable{

	@FXML private Canvas canvas;
	
	private GraphicsContext gc = canvas.getGraphicsContext2D();
	
	@Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
	
		 gc.setFill(Color.WHITESMOKE);
         gc.fillRect(gc.getCanvas().getLayoutX(),      
         gc.getCanvas().getLayoutY(), 
         gc.getCanvas().getWidth(), 
         gc.getCanvas().getHeight());
         gc.setFill(Color.GREEN);
         gc.setStroke(Color.BLUE);
	}
}
