package Modelo;

public class PersonaJuridica extends Cliente {
	int nit;

	public PersonaJuridica(String nombre, String id, String dir, String tel, int nit) {
		super(nombre, id, dir, tel);
		this.nit = nit;

	}
}
