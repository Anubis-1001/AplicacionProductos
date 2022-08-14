package Vista;

import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;



public class VentanaPerecedero extends GridPane{
	public VentanaPerecedero(){
		
		Label fechaVen = new Label("Fecha de vencimiento");
		TextField fechaVCampo= new TextField();
		fechaVCampo.setPromptText("ingrese la fecha de vencimiento");
		this.setHgap(10);
		this.setVgap(10);
		this.setConstraints(fechaVen, 0,0);
		this.setConstraints(fechaVCampo, 1,0);
		
		this.getChildren().addAll(fechaVen, fechaVCampo);
		
	}
}
