package empleado;

import java.util.Date;

public class PlantaPermanente extends Empleado {
	
	private int cantidadHijos;
	private int antiguedad;
	
	public PlantaPermanente(String nombre, String direccion, String estadoCivil, Date fechaNacimiento, float sueldoBasico,
			int cantidadHijos, int antiguedad) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.cantidadHijos = cantidadHijos;
		this.antiguedad = antiguedad;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public float sueldoBruto() {
		return this.getSueldoBasico() + this.asignacionHijo() + this.asignacionConyuge() + this.asignacionAntiguedad();
	}
	
	private float asignacionHijo() {
		return this.cantidadHijos * 150;
	}
	
	private float asignacionConyuge() {
		return (this.getEstadoCivil().equals("Casado") || this.getEstadoCivil().equals("Casada") ||
				this.getEstadoCivil().equals("Casade") || this.getEstadoCivil().equals("Casadx")) ? 100 : 0;
	}
	
	private float asignacionAntiguedad() {
		return this.antiguedad * 50;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public float retenciones() {
		return this.retencionesObraSocial() + this.retencionesAportes();
	}
	
	private float retencionesObraSocial() {
		return (10 * this.sueldoBruto() / 100) + (this.cantidadHijos * 20);
	}
	
	private float retencionesAportes() {
		return 15 * this.sueldoBruto() / 100;
	}

}
