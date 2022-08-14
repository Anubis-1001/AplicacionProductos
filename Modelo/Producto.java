package Modelo;

import java.util.ArrayList;

public class Producto {
	//Creados mediante la interfaz
	private static ArrayList<Producto> productosCreados = new ArrayList<>();
	private int codigo, valorUnitario;
	private String descripcion, nombre;
	private int cantidadExistente;
	
	public Producto(String nombre, int codigo, int valorUnitario, String desc, int cantidad) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.valorUnitario = valorUnitario;
		this.descripcion = desc; 
		this.cantidadExistente = cantidad;
	}
	
	public int getValorUnitario() {
		return this.valorUnitario;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public static ArrayList<Producto> getProductosCreados() {
		return productosCreados;
	}
}
