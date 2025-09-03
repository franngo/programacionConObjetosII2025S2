package empleado;

import java.util.Date;

public class Contratado extends Empleado {
	
	private int numeroDeContrato;
	private String metodoDePago;
	
	public Contratado(String nombre, String direccion, String estadoCivil, Date fechaNacimiento, float sueldoBasico,
			int numeroDeContrato, String metodoDePago) {
		super(nombre, direccion, estadoCivil, fechaNacimiento, sueldoBasico);
		this.numeroDeContrato = numeroDeContrato;
		this.metodoDePago = metodoDePago;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////


	@Override
	public float sueldoBruto() {
		return this.getSueldoBasico();
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////


	@Override
	public float retenciones() {
		return gastosAdministrativosContractuales();
	}
	
	private float gastosAdministrativosContractuales() {
		return 50;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	@Override
	protected String desgloceConceptos() {
		return "Sueldo básico: " + this.getSueldoBasico() + " | " +
		"Gastos administrativos contractuales: -" + this.gastosAdministrativosContractuales();
	}

}
