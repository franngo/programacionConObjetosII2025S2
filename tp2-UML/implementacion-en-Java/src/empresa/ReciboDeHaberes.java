package empresa;

import java.util.Date;

import empleado.*;

public class ReciboDeHaberes {
	private String direccion;
	private Date fechaEmision;
	private float sueldoBruto;
	private float sueldoNeto;
	private String desgloceConceptos;
	
	public ReciboDeHaberes(String direccion, Date fechaEmision, float sueldoBruto, float sueldoNeto, 
			String desgloceConceptos) {
		this.direccion = direccion;
		this.fechaEmision = fechaEmision;
		this.sueldoBruto = sueldoBruto;
		this.sueldoNeto = sueldoNeto;
		this.desgloceConceptos = desgloceConceptos;
	}
}
