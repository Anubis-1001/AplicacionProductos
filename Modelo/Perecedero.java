package Modelo;

import java.util.Date;

public class Perecedero extends Producto {
	private Date fechaVencimiento;

	public Perecedero(String nombre, String codigo, int valorU, String desc, int Udisponibles, Date fechaVencimiento) {
		super(nombre, codigo, valorU, desc, Udisponibles);
		this.fechaVencimiento = fechaVencimiento;
	}

	public Date getFechaVencimiento() {
		return fechaVencimiento;
	}
}
