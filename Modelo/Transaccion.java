package Modelo;

import java.util.Date;
import java.util.ArrayList;


public class Transaccion {
	
	String codigo;
	Date fecha;
	ArrayList<Detalle> detalles =new ArrayList<>();
	Cliente cliente;
	int total=0;
	double iva;
	final double IVA=0.19;
	
	public Transaccion(ArrayList<Producto> productos, Cliente cliente) {
		this.cliente = cliente;
		
		Date fecha = new Date();
		this.fecha = fecha;
		this.codigo = ""+(fecha.getYear()+1900)+fecha.getMonth()+fecha.getDay()+fecha.getHours()+fecha.getMinutes()+fecha.getSeconds();
		
		int totalSubventa = 0;
		Producto prodActual = productos.get(0);
		
		for(Producto prod: productos) {
			this.total+=prod.getValorUnitario();
			
			if(prod.getNombre() != prodActual.getNombre()) {
				this.detalles.add(new Detalle(totalSubventa, prodActual.getValorUnitario(), prodActual.getNombre()));
				prodActual = prod;
			}
		}
		this.iva = this.total*IVA;
	}
}
