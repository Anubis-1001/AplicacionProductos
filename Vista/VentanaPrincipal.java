package Vista;

import java.util.ArrayList;
import Modelo.Producto;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputControl;
import javafx.collections.ObservableList;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class VentanaPrincipal extends Stage{
	
	public VentanaPrincipal() {
		VBox panel = new VBox(35);
		
		panel.setAlignment(Pos.CENTER);
		panel.setPadding(new Insets(10));
		Button botonProductos = new Button("productos");
		
		Button botonClientes = new Button("clientes");
		Button botonTransacciones = new Button("transacciones");
		
		botonTransacciones.setOnAction(e->{
			VentanaTransaccion ventanaTransaccion = new VentanaTransaccion(new ArrayList<Producto>()); 
			this.setScene(ventanaTransaccion.getScene());
		});
		
		
		panel.getChildren().addAll(botonClientes, botonProductos, botonTransacciones);
		
		Button boton;
		for(Node node: panel.getChildren()) {
			if(node instanceof Button) {
				boton = (Button)node;
				boton.setMinHeight(50);
				boton.setMinWidth(90);
			}
		}
		
		Scene escena = new Scene(panel, 400, 600); 
		this.setScene(escena);
	}
	
}
