package org.openjfx.paint.Controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.event.ChangeListener;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class TestController implements Initializable {

	private Stage stage;

	@FXML private Canvas canvas;

	@FXML private Slider sliderPenSize;

	@FXML private ColorPicker colorPicker;

	@FXML private Button clearButton;

	private GraphicsContext gc;
	
	private double canvasWidth;
	
	

	public TestController() {

	}
	
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {
		this.gc = canvas.getGraphicsContext2D();

		clearCanvas(this.gc);

		canvas.addEventHandler(MouseEvent.MOUSE_DRAGGED, 
				new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent e) {
				drawLine(gc, 2, e, sliderPenSize.getValue(), sliderPenSize.getValue(), colorPicker.getValue());
			}
		});

		clearButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				clearCanvas(gc);
			}
		});
		
		System.out.println(this.stage);
		
	}
	
	public void Luncher(Stage stage) {
		this.stage = stage;
		
		this.stage.widthProperty().addListener((obs, oldVal, newVal) -> {
			System.out.println(newVal);
		});

		this.stage.heightProperty().addListener((obs, oldVal, newVal) -> {
			System.out.println(newVal);
		});
		
	}

	private void clearCanvas(GraphicsContext gc) {
		double width = gc.getCanvas().getWidth();
		double height = gc.getCanvas().getHeight();
		gc.beginPath();
		gc.setFill(Color.WHITE);
		gc.fillRect(0,  0, width, height);
		gc.fill();
	}

	private void drawLine(GraphicsContext gc, int style, MouseEvent e, double width, double height, Color color) {

		gc.beginPath();
		gc.setFill(color);
		switch (style) {
		case 1:
			gc.fillRect(e.getX() - width / 2, e.getY() - height / 2, width, height);
			break;

		case 2:
			gc.fillOval(e.getX() - width / 2, e.getY() - height / 2, width, height);
			break;

		default:
			gc.fillOval(e.getX() - 2, e.getY() - 2, width, height);
			break;
		}

		gc.fill();
	}

}
