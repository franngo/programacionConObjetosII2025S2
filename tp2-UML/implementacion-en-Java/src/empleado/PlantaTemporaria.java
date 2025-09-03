package empleado;

import java.util.Date;

public class PlantaTemporaria extends Empleado {
	
	private Date fechaFinDesignacion;
	private int cantHorasExtras;
	
	public PlantaTemporaria(String nombre, String direccion, String estadoCivil, Date fechaNacimiento, float sueldoBasico,
			Date fechaFinDesignacion, int cantHorasExtras) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.fechaFinDesignacion = fechaFinDesignacion;
		this.cantHorasExtras = cantHorasExtras;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public float sueldoBruto() {
		return this.getSueldoBasico() + this.bonoHorasExtra();
	}
	
	private float bonoHorasExtra() {
		return this.cantHorasExtras * 40;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////

	@Override
	public float retenciones() {
		return this.retencionesObraSocial() + this.retencionesAportes();
	}
	
	private float retencionesObraSocial() {
		return (10 * this.sueldoBruto() / 100) + this.cargoObraSocial();
	}
	
	private float cargoObraSocial() {
		return (this.edad()>50) ? 25 : 0;
	}
	
	private float retencionesAportes() {
		return (10 * this.sueldoBruto() / 100) * (this.cantHorasExtras * 5);
	}

}
