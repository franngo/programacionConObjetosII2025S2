package empleado;

import java.util.Date;

public class PlantaPermanente extends Empleado {
	
	private int cantidadHijos;
	private int antiguedad;
	
	public PlantaPermanente(String nombre, String direccion, String estadoCivil, Date fechaNacimiento, float sueldoBasico,
			int cantidadHijos, int Antiguedad) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.cantidadHijos = cantidadHijos;
		this.antiguedad = antiguedad;
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
