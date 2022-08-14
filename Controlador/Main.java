package Controlador;

import Vista.VentanaProducto;

import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class Main extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage window) {
		VentanaProducto ventana= new VentanaProducto();
		window.setScene(ventana.getScene());
		window.show();
	}
	
	
}
