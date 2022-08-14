package Modelo;

public class Refrigerado extends Producto{
	
	int codigoControl;
	int temperaturaOptima;
	
	public Refrigerado(String nombre, int codigo, int valorU, String desc, int codigoControl, int temperatura) {
		super(nombre, codigo, valorU, desc);
		this.codigoControl = codigoControl;
		this.temperaturaOptima = temperatura;
	}
}
