package Modelo;

import java.util.ArrayList;

public class Producto {
	//Creados mediante la interfaz
	private static ArrayList<Producto> productosCreados = new ArrayList<>();
	private int valorUnitario;
	private String descripcion, nombre, codigo;
	private int cantidadExistente;
	
	public Producto(String nombre, String codigo, int valorUnitario, String desc, int cantidad) {
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
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public static ArrayList<Producto> getProductosCreados() {
		return productosCreados;
	}
}
