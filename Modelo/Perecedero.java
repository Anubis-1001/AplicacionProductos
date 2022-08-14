package Modelo;

import java.util.Date;

public class Perecedero extends Producto{
	private Date fechaVencimiento;
	
	public Perecedero(String nombre, int codigo, int valorU, String desc, Date fechaVencimiento) {
		super(nombre, codigo, valorU, desc);
		this.fechaVencimiento = fechaVencimiento;  
	}
}
