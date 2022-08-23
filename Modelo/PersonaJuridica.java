package Modelo;

public class PersonaJuridica extends Cliente {
	private int nit;

	public PersonaJuridica(String nombre, String id, String dir, String tel, int nit) {
		super(nombre, id, dir, tel);
		this.nit = nit;

	}

	public int getNit() {
		return nit;
	}
}
