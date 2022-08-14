package Modelo;

public class Producto {
	private int codigo, valorUnitario;
	private String descripcion, nombre;
	private static int cantidadExistente;
	
	public Producto(String nombre, int codigo, int valorUnitario, String desc) {
		this.nombre = nombre;
		this.codigo = codigo;
		this.valorUnitario = valorUnitario;
		this.descripcion = desc; 
	}
	
	public int getValorUnitario() {
		return this.valorUnitario;
	}
	
	public String getNombre() {
		return this.nombre;
	}
}
