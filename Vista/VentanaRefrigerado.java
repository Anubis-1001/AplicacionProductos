package Vista;

import java.util.ArrayList;

import Modelo.Producto;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextAlignment;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.VPos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.TextArea;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Scene;


public class VentanaRefrigerado extends GridPane{
	public VentanaRefrigerado(){
		
		agregarEntrada("codigo aprobacion", new TextField(), "ingrese el codigo de aprobacion", 0);
		agregarEntrada("temperatura optima", new TextField(), "ingrese la temperatura recomendada ", 1);
		this.setPadding(new Insets(2));
		
		this.setHgap(10);
		this.setVgap(10);
		
		
	}
	
	public void agregarEntrada(String etiqueta, TextInputControl campo, String indicacion, int fila) {
		Label subtitulo = new Label(etiqueta);
		campo.setPromptText(indicacion);
		this.setConstraints(subtitulo, 0, fila);
		this.setConstraints(campo, 1, fila);
		this.getChildren().addAll(subtitulo, campo);
	}
}
