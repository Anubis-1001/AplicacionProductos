package Modelo;

public class Refrigerado extends Producto {

	private String codigoControl;
	private int temperaturaOptima;

	public Refrigerado(String nombre, String codigo, int valorU, String desc, int Udisponibles, String codigoControl,
			int temperatura) {
		super(nombre, codigo, valorU, desc, Udisponibles);
		this.codigoControl = codigoControl;
		this.temperaturaOptima = temperatura;
	}

	public String getCodigoControl() {
		return codigoControl;
	}

	public int getTemperaturaOptima() {
		return temperaturaOptima;
	}
}
