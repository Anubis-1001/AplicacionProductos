package Modelo;

import java.util.Date;
import java.util.ArrayList;

public class Transaccion {
	String codigo;
	Date fecha;
	ArrayList<Detalle> detalles;
	Cliente cliente;
	int total=0;
	double iva;
	final double IVA=0.19;
	
	public Transaccion(ArrayList<Detalle> detalles, Cliente cliente) {
		this.cliente = cliente;
		this.detalles = detalles;
		Date fecha = new Date();
		this.fecha = fecha;
		this.codigo = ""+(fecha.getYear()+1900)+(fecha.getMonth()+1)+fecha.getDate()+fecha.getHours()+fecha.getMinutes()+fecha.getSeconds();
		
		for(Detalle detalle: detalles) {
			this.total+=detalle.getSubtotal();
		}
		
		this.iva = this.total*IVA;
	}
	
	
	public String getCodigo() {
		return this.codigo;
	}
	
	public Date getFecha() {
		return this.fecha;
	}
	
	public Cliente getCliente() {
		return this.cliente;
	}
	
	public ArrayList<Detalle> getDetalles() {
		return this.detalles;
	}
}
