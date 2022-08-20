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
	
	private Button botonAgregar;
	private Button botonActualizar;
	private Button botonBorrar;
	private Scene scene;
	private String flag;
	private ListView<String> listaDispo = new ListView<>();
	
	public VentanaLecturaProducto(HashMap<String, Producto> listasProd) {
		
		for(String item: listasProd.keySet()) {
			listaDispo.getItems().add(item);
		}
		
		botonAgregar = new Button("agregar");
		botonActualizar = new Button("actualizar");
		botonBorrar = new Button("borrar");
		
		VBox panel = new VBox(10);
		panel.setPadding(new Insets(10));
		panel.getChildren().addAll(listaDispo, botonAgregar, botonActualizar, botonBorrar);
		
		scene = new Scene(panel, 400,500);
		this.setScene(scene);
	}
	
	public String display() {
		
		
		botonAgregar.setOnAction(e->{
			try {
				flag = "agregar";
				this.close();
			} catch (Exception e2) {
			}
		});
		
		botonActualizar.setOnAction(e->{
			try {
				flag = "actualizar";
				this.close();
			} catch (Exception e2) {
			}
		});
		
		botonBorrar.setOnAction(e->{
			try {
				flag = "borrar";
				this.close();
			} catch (Exception e2) {
			}
		});
		this.showAndWait();
		return flag;
		
		
		
	}
	

	public ListView<String> getListaDispo() {
		
		
		
		return listaDispo;
	}

	public void setListaDispo(ListView<String> listaDispo) {
		this.listaDispo = listaDispo;
	}

	public void setListaDispo(HashMap<String, Producto> listasProd) {
		listaDispo= new ListView<>();
		for(String item: listasProd.keySet()) {
			listaDispo.getItems().add(item);
		}
	}
}
