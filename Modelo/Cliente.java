package Modelo;

public class Cliente {
	
	private String nombre, primerApellido, segundoApellido; 
	private int id, telefono;
	private Direccion direccion;
	
	public Cliente(String nombre, String apellido1, String apellido2, int id, Direccion dir, int tel){
		this.nombre = nombre;
		this.primerApellido = apellido1;
		this.segundoApellido = apellido2;
		this.id = id;
		this.direccion  = dir;
		this.telefono  = tel;
	}
	
}