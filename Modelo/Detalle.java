package Modelo;

import java.util.ArrayList;

public class Detalle {
	int totalProductos;
	int subtotal;
	String nombre;
	
	public Detalle(int cantidad, int valorU, String nombre) {
		this.totalProductos = cantidad;
		this.subtotal = cantidad*valorU;
		this.nombre = nombre;
	}
}
