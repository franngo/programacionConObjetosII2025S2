package empresa;

import empleado.*;
import java.util.List;
import java.util.ArrayList;

public class Empresa {
	private String name;
	private String cuil;
	private List<Empleado> empleados;
	private List<ReciboDeHaberes> recibosHaberes;
	
	public Empresa(String name, String cuil, List<Empleado> empleados) {
		this.name = name;
		this.cuil = cuil;
		this.empleados = empleados;
		this.recibosHaberes = new ArrayList<ReciboDeHaberes>();
	}
	
	public void realizarLiquidacionSueldos() {
		
	}
	
	public float totalSueldosNetos() {
		return 1;
	}
	
	public float totalSueldosBrutos() {
		return 1;
	}
	
	public float retenciones() {
		return 1;
	}
}
