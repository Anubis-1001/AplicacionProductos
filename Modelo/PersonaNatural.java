package Modelo;


import java.util.Date;
public class PersonaNatural extends Cliente{
	private String email, primerApellido, segundoApellido;
	private Date fechaNacimiento;
	
	public PersonaNatural(String nombre, String apellido1, String apellido2, int id, Direccion dir, int tel, String email, Date fecha){
		super(nombre,id, dir, tel);
		this.email = email;
		this.primerApellido = apellido1;
		this.segundoApellido = apellido2;
		this.fechaNacimiento = fecha;
	}
}
