package Modelo;

public class Cliente {
	
	private String nombre;

	private String id;
	private String direccion, telefono;
	
	public Cliente(String nombre, String id, String dir, String tel){
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
}