package Modelo;

public class PersonaJuridica extends Cliente {
	int nit;
	int idTributaria;
	
	public PersonaJuridica(String nombre, String apellido1, String apellido2, int id, Direccion dir, int tel, int nit, int idTributaria) {
		super(nombre, apellido1, apellido2, id, dir, tel);
		this.nit = nit;
		this.idTributaria = idTributaria;
	}
	
	public String getNombreTipo() {
		return "Juridica";
	}
}
