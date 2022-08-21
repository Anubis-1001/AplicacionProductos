package Utilidades;

import Modelo.Producto;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import Modelo.*;

//clase con funciones necesarias en varias partes del codigo
public class Utilidades {
	
public static Date parseFecha(String fecha) {
		
	    DateFormat DFormat = new SimpleDateFormat("dd/MM/yyyy");
	    try {
	    	return DFormat.parse(fecha);
	    }
	    catch(Exception e) {
	    	return new Date();
	    	}	
	    }


	
	public static Producto parseProducto(HashMap<String, String> atributosProd) {
		
		HashMap<String, Producto> inventarioProductos = new HashMap<>();
		//Crea un objeto del tipo producto con los datos enviados por la ventana
		Producto producto=null;
		String nombre  = atributosProd.get("nombre");
		String codigo = atributosProd.get("id");
		int valorU = Integer.parseInt(atributosProd.get("valorUnitario"));
		String desc = atributosProd.get("descripcion");
		int cantidad = Integer.parseInt(atributosProd.get("cantidadDisponible"));
		boolean crearObjeto=true;
		
		if(atributosProd.get("tipoProducto") == "Envasado") {
			producto = new Envasado(nombre, codigo, valorU, desc, cantidad, parseFecha(atributosProd.get("Fecha de envasado")), Double.parseDouble(atributosProd.get("Peso de envase")), atributosProd.get("Pais de origen"));
		}
		else if(atributosProd.get("tipoProducto") == "Refrigerado") {
			producto = new Refrigerado(nombre, codigo, valorU, desc, cantidad,  atributosProd.get("Codigo aprobacion"), Integer.parseInt(atributosProd.get("Temperatura optima")));
		}
		
		else if(atributosProd.get("tipoProducto") == "Perecedero") {
			producto = new Perecedero(nombre, codigo, valorU, desc, cantidad,  parseFecha(atributosProd.get("Fecha de vencimiento")));
		}
		//se puede agregar una validacion de datos mas delante
		/*else {
			crearObjeto = false;
			producto = null;
		}*/
		
		/*
		if(crearObjeto) {
			inventarioProductos.put(codigo, producto);
		}*/
		
		return producto;
	} 
}
