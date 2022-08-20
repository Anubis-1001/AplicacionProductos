package Modelo;

public class Direccion {
	int cra;
	int cll;
	String ciudad;
	String municipio;
	public Direccion(int carrera, int calle, String ciudad, String municipio){
		this.cra = carrera;
		this.cll = calle;
		this.ciudad = ciudad;
		this.municipio = municipio;
	}

	@Override
	public String toString() {

		String dir = municipio + ", " + ciudad + ", " + "Cra: " + cra + " Calle: " + cll;

		return dir;
	}
}
