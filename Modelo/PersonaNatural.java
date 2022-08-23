package Modelo;

import java.util.Date;

public class PersonaNatural extends Cliente {

	private String email, primerApellido, segundoApellido;
	private Date fechaNacimiento;

	public PersonaNatural(String nombre, String apellido1, String apellido2, String id, String dir, String tel,
			String email, Date fecha) {
		super(nombre, id, dir, tel);
		this.email = email;
		this.primerApellido = apellido1;
		this.segundoApellido = apellido2;
		this.fechaNacimiento = fecha;
	}

	public String getEmail() {
		return email;
	}

	public String getPrimerApellido() {
		return primerApellido;
	}

	public String getSegundoApellido() {
		return segundoApellido;
	}

	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}

}
