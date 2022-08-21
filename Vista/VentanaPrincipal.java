package Vista;

import java.util.ArrayList;


import java.util.HashMap;
import Modelo.Producto;
import Modelo.Cliente;
import Modelo.Direccion;
import Controlador.Main;
import javafx.scene.layout.VBox;
import javafx.scene.control.Button;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class VentanaPrincipal extends Scene {
	
	public VentanaPrincipal(VBox panel, Stage ventana) {
		super(panel, 400, 600);
		
		
		//VBox panel = new VBox(35);
		panel.setAlignment(Pos.CENTER);
		panel.setPadding(new Insets(10));
		
		Button botonProductos = new Button("productos");
		
		botonProductos.setOnAction(e->{
			//																							se reeemplaza por un hashmap con informacion util
			VentanaLecturaProducto ventanaLecturaProd = new VentanaLecturaProducto(new VBox(10), Main.getInventario(), ventana); 
			ventana.setScene(ventanaLecturaProd);
		});
		
		Button botonClientes = new Button("clientes");
		
		botonClientes.setOnAction(e->{
			Direccion dir = new Direccion(1, 1, "Armenia", "Quindío");
			Cliente cliente = new Cliente("Juan", 123, dir, 312345);
			VentanaIngresoClientes ventanaClientes = new VentanaIngresoClientes(cliente); 
			ventanaClientes.show();
		});
		
		Button botonTransacciones = new Button("transacciones");
		
		botonTransacciones.setOnAction(e->{
			
			VentanaTransaccion ventanaTransaccion = new VentanaTransaccion(new VBox(10), ventana, new ArrayList<Producto>()); 
			ventana.setScene(ventanaTransaccion);
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
		
		//Scene escena = new Scene(panel, 400, 600); 
		ventana.setScene(this);
	}
	
	
	
}
