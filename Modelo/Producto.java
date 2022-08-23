package Modelo;

public class Producto {
	// Creados mediante la interfaz
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

	public Producto() {
		this.nombre = "";
		this.codigo = "";
		this.valorUnitario = 0;
		this.descripcion = "";
		this.cantidadExistente = 0;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public int getCantidadExistente() {
		return cantidadExistente;
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

	public void setCantidadExistente(int cantidadExistente) {
		this.cantidadExistente = cantidadExistente;
	}

}
