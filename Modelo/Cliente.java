package Modelo;

public class Cliente {
	
	private String nombre; 
	private int id, telefono;
	private Direccion direccion;
	
	public Cliente(String nombre, int id, Direccion dir, int tel){
		this.nombre = nombre;
		this.id = id;
		this.direccion  = dir;
		this.telefono  = tel;
	}
	
}