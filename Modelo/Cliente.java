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

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}
}