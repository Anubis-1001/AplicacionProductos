package Controlador;


import java.util.Date;
import java.util.HashMap;

import Vista.VentanaProducto;
import Vista.VentanaLecturaProducto;
import Modelo.*;
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
		
		while(true){
		HashMap<String, String> attProd = new HashMap<>();
		VentanaLecturaProducto ventanaProd = new VentanaLecturaProducto(inventarioProductos);
		VentanaProducto ventana= new VentanaProducto(new Producto());
		String tipoVentana = ventanaProd.display();
		Producto producto = null;
		if (tipoVentana == "agregar") {
			attProd = ventana.getInfo();
			ventana.display();	
			producto = crearProducto(attProd);
			inventarioProductos.put(producto.getCodigo(), producto);
		} else {
			if (tipoVentana == "actualizar" && ventanaProd.getListaDispo().getSelectionModel().getSelectedItem() != null ) {
				ventana= new VentanaProducto( inventarioProductos.get(ventanaProd.getListaDispo().getSelectionModel().getSelectedItem()));
				attProd = ventana.getInfo();
				ventana.display();		
				producto = crearProducto(attProd);
				// pregunta si el codigo actualizado es el mismo de antes, si lo es, solo reemplaza el objeto
				if (producto.getCodigo() == ventanaProd.getListaDispo().getSelectionModel().getSelectedItem()) {
					inventarioProductos.put(producto.getCodigo(), producto);
				} else  {
						// en caso contrario, borra el objeto y lo crea denuevo con otro codigo.
					inventarioProductos.remove(ventanaProd.getListaDispo().getSelectionModel().getSelectedItem());	
					inventarioProductos.put(producto.getCodigo(), producto);	
										}

			}
		} if (tipoVentana == "borrar") {
			inventarioProductos.remove(ventanaProd.getListaDispo().getSelectionModel().getSelectedItem());	
		}
		
		ventanaProd = new VentanaLecturaProducto(inventarioProductos);
		
		}
	}
	
	public Producto crearProducto (HashMap<String, String> attProd) {
		Producto producto;
		String nombre  = attProd.get("nombre");
		String codigo = attProd.get("id");
		int valorU = Integer.parseInt(attProd.get("valorUnitario"));
		String desc = attProd.get("descripcion");
		int cantidad = Integer.parseInt(attProd.get("cantidadDisponible"));
		
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
			producto = null;
		}
		
		return producto;
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
