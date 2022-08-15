package Modelo;

import java.util.Date;

public class Envasado extends Producto{
	private Date fechaEnvasado;
	private double peso;
	private String pais;
	public Envasado(String nombre, String codigo, int valorU, String desc, int Udisponible, Date fecha, double peso, String pais)
	{
		super(nombre, codigo, valorU, desc, Udisponible);
		this.fechaEnvasado = fecha;
		this.peso = peso;
		this.pais = pais;
	}
}
