package Modelo;


import java.util.Date;
public class PersonaNatural extends Cliente{
	private String email;
	private Date fechaNacimiento;
	
	public PersonaNatural(String nombre, String apellido1, String apellido2, int id, Direccion dir, int tel, String email, Date fecha){
		super(nombre, apellido1, apellido2, id, dir, tel);
		this.email = email;
		this.fechaNacimiento = fecha;
	}
}
