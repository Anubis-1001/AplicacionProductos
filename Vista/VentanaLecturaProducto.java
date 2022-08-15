package Vista;

import java.util.ArrayList;
import java.util.HashMap;

import Modelo.Producto;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputControl;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class VentanaLecturaProducto extends Stage{
	
	public VentanaLecturaProducto(HashMap<String, Producto> listasProd) {
		ListView<String> listaDispo = new ListView<>();
		
		for(String item: listasProd.keySet()) {
			listaDispo.getItems().add(item);
		}
		
		Button botonAgregar = new Button("agregar");
		Button botonActualizar = new Button("actualizar");
		Button botonBorrar = new Button("borrar");
		
		VBox panel = new VBox(10);
		panel.setPadding(new Insets(10));
		panel.getChildren().addAll(listaDispo, botonAgregar, botonActualizar, botonBorrar);
		
		Scene scene = new Scene(panel, 400,500);
		this.setScene(scene);
	}
	
	public void display() {
		this.showAndWait();
	}
}
