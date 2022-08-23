package Controlador;


import java.util.Date;



import java.util.HashMap;
import java.util.ArrayList;

import Vista.VentanaProducto;
import Vista.VentanaTransaccion;
import Vista.VentanaLecturaProducto;
import Vista.VentanaPrincipal;
import Modelo.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import javafx.stage.Stage;

public class Main extends Application{
	static HashMap<String, Producto> inventarioProd = new HashMap<>();
	static HashMap<String, Cliente> inventarioClientela = new HashMap<>();
	static HashMap<String, Cliente> listaClientes = new HashMap<>();
	static HashMap<String, Transaccion> registroTransacciones = new HashMap<>();

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage window) {
		Stage menu = new Stage();
		VentanaPrincipal principal = new VentanaPrincipal(new VBox(35), menu);
		menu.show();
	}
	
	public static HashMap<String, Producto> getInventario() {
		return inventarioProd;
	}

	public static HashMap<String, Cliente> getClientela() {
		return inventarioClientela;
	}
	
	public static HashMap<String, Transaccion> getTransacciones() {
		return registroTransacciones;
	}
	
}
