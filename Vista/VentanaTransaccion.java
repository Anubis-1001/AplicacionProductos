package Vista;

import java.util.HashMap;

import java.util.ArrayList;
import Modelo.Producto;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputControl;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class VentanaTransaccion extends Stage{
	
	private Stage productosDisponibles;
	
	public VentanaTransaccion(ArrayList<Producto> productos) {
		
		
		VBox panel = new VBox(10);
		
		ListView<String> listaProductos = new ListView<>();
		
		Button agregar = new Button("agregar");
		
		Button atras = new Button("atras");
		inicializarVentana(productos);
		
		agregar.setOnAction(e->{
			productosDisponibles.show();
		});
		
		atras.setOnAction(e->{
			
		});
		
		panel.getChildren().addAll(listaProductos, agregar);
		panel.setPadding(new Insets(10));
		
		Scene escena = new Scene(panel, 500, 700);
		this.setScene(escena);		
	}
	
	public void inicializarVentana(ArrayList<Producto> productos) {
		VBox panel = new VBox(10);
		ListView<String> listaDisponibles = new ListView<>();
		
		for(Producto prod: productos) {
			listaDisponibles.getItems().add(prod.getCodigo()+": "+prod.getNombre());
		}
		
		
		TextField cantidad = new TextField();
		cantidad.setPromptText("ingrese la cantidad a comprar");
		cantidad.setMaxWidth(150);
		
		
		Button agregar = new Button("aceptar"); 
		
		agregar.setOnAction(e->{
			
		});
		
		panel.getChildren().addAll(listaDisponibles, cantidad, agregar);
		
		panel.setPadding(new Insets(10));
		
		Scene escena = new Scene(panel, 500, 700);
		
		productosDisponibles = new Stage();
		
		
		productosDisponibles.setScene(escena);
		
		
		}
}
