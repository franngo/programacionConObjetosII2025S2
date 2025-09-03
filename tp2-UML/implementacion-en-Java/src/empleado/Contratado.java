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
		// TODO Auto-generated method stub
		return 0;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////


	@Override
	public float retenciones() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	@Override
	protected String desgloceConceptos() {
		return "a";
	}
	//TODO

}
