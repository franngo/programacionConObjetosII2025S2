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

	@Override
	public float sueldoBruto() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float retenciones() {
		// TODO Auto-generated method stub
		return 0;
	}

}
