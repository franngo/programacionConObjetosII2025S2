package empleado;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
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
	
	protected int edad() { //según vi, hacerlo con Date puede ser propenso a errores, por lo que internamente se usa LocalDate
		LocalDate localFechaActual = new Date().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
		LocalDate localFechaNacimiento = fechaNacimiento.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

		int diferenciaAnios = Period.between(localFechaNacimiento, localFechaActual).getYears();
		
		return diferenciaAnios;
	}
	
	protected String getEstadoCivil() {
		return this.estadoCivil;
	}
	
	protected float getSueldoBasico() {
		return this.sueldoBasico;
	}
	
}
