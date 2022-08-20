package Controlador;


import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import Vista.VentanaProducto;
import Vista.VentanaLecturaProducto;
import Modelo.*;
import javafx.scene.layout.GridPane;
import javafx.application.Application;
import java.text.DateFormat;

import java.text.SimpleDateFormat;
import javafx.stage.Stage;

public class Main extends Application{
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage window) {
		HashMap<String, Producto> inventarioProductos = new HashMap<>();
		//temporal arraylist - creo que es mejor cambiar los hashmaps
		ArrayList <Producto> prodArray = new ArrayList<Producto>();
		
		while(true){
		HashMap<String, String> attProd = new HashMap<>();
		VentanaLecturaProducto ventanaProd = new VentanaLecturaProducto(inventarioProductos);
		VentanaProducto ventana= new VentanaProducto(new Producto());
		String tipoVentana = ventanaProd.display();
		if (tipoVentana == "agregar") {
			attProd = ventana.getInfo();
			ventana.display();	
		}
		
		else {
			if (tipoVentana == "actualizar" && ventanaProd.getListaDispo().getSelectionModel().getSelectedItem() != null ) {
				attProd = ventana.getInfo();
				ventana= new VentanaProducto(prodArray.get(Integer.parseInt(ventanaProd.getListaDispo().getSelectionModel().getSelectedItem()) - 1));
				ventana.display();	
				
			}
			System.out.print("a");
		}
		
		//Crea un objeto del tipo producto con los datos enviados por la ventana
		Producto producto;
		String nombre  = attProd.get("nombre");
		String codigo = attProd.get("id");
		int valorU = Integer.parseInt(attProd.get("valorUnitario"));
		String desc = attProd.get("descripcion");
		int cantidad = Integer.parseInt(attProd.get("cantidadDisponible"));
		boolean crearObjeto=true;
		
		if(attProd.get("tipoProducto") == "Envasado") {
			producto = new Envasado(nombre, codigo, valorU, desc, cantidad, parseFecha(attProd.get("Fecha de envasado")), Double.parseDouble(attProd.get("Peso de envase")), attProd.get("Pais de origen"));
		}
		else if(attProd.get("tipoProducto") == "Refrigerado") {
			producto = new Refrigerado(nombre, codigo, valorU, desc, cantidad,  attProd.get("Codigo aprobacion"), Integer.parseInt(attProd.get("Temperatura optima")));
		}
		
		else if(attProd.get("tipoProducto") == "Perecedero") {
			producto = new Perecedero(nombre, codigo, valorU, desc, cantidad,  parseFecha(attProd.get("Fecha de vencimiento")));
		}
		else {
			crearObjeto = false;
			producto = null;
		}
		
		if(crearObjeto) {
			inventarioProductos.put(codigo, producto);
			prodArray.add(producto);
		}
		ventanaProd = new VentanaLecturaProducto(inventarioProductos);

		}
	}
	
	
	
	public Date parseFecha(String fecha) {
		
	    DateFormat DFormat = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	    	return DFormat.parse(fecha);
	    }
	    catch(Exception e) {
	    	return new Date();
	    }
	}
	
	
}
