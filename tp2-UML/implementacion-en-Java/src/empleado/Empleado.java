package empleado;

import java.util.Date;
import empresa.ReciboDeHaberes;

abstract public class Empleado {
	private String nombre;
	private String direccion;
	private String estadoCivil;
	private Date fechaNacimiento;
	private float sueldoBasico;
	
	public Empleado(String nombre, String direccion, String estadoCivil, Date fechaNacimiento, float sueldoBasico) {
		this.nombre = nombre;
		this.direccion = direccion;
		this.estadoCivil = estadoCivil;
		this.fechaNacimiento = fechaNacimiento;
		this.sueldoBasico = sueldoBasico;
	}
	
	abstract public float sueldoBruto();
	abstract public float retenciones();
	
	public float sueldoNeto() { //template method
		return this.sueldoBruto() - this.retenciones();
	}
	
	public ReciboDeHaberes reciboDeHaberes() {
		return new ReciboDeHaberes(direccion, new Date(), this.sueldoBruto(), this.sueldoNeto(), "a");
	}
	//TODO: Pasarle el verdadero desgloce de conceptos en vez de un string random
}
