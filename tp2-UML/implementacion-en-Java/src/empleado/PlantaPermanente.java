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

	@Override
	public float sueldoBruto() {
		return this.getSueldoBasico() + this.asignacionHijo() + this.asignacionConyuge() + this.asignacionAntiguedad();
	}
	
	private float asignacionHijo() {
		return cantidadHijos * 150;
	}
	
	private float asignacionConyuge() {
		return (this.getEstadoCivil().equals("Casado") || this.getEstadoCivil().equals("Casada") ||
				this.getEstadoCivil().equals("Casade") || this.getEstadoCivil().equals("Casadx")) ? 100 : 0;
	}
	
	private float asignacionAntiguedad() {
		return antiguedad * 50;
	}

	@Override
	public float retenciones() {
		float aDevolver = this.retencionesObraSocial() + retencionesAportes();
		return 0;
	}
	
	private float retencionesObraSocial() {
		return 0;
	}
	
	private float retencionesAportes() {
		return 0;
	}

}
