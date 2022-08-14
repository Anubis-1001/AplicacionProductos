package Modelo;

public class PersonaJuridica extends Cliente {
	int nit;
	int idTributaria;
	
	public PersonaJuridica(String nombre, int id, Direccion dir, int tel, int nit, int idTributaria) {
		super(nombre, id, dir, tel);
		this.nit = nit;
		this.idTributaria = idTributaria;
	}
}
