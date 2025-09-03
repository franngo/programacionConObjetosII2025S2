package empresa;

import empleado.*;
import java.util.List;
import java.util.stream.Collectors;
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
		return empleados.stream().
				map((empleado) -> empleado.sueldoNeto()).
				reduce(0f, (a,b) -> Float.sum(a, b));
	}
	
	public float totalSueldosBrutos() {
		return empleados.stream().
				map((empleado) -> empleado.sueldoBruto()).
				reduce(0f, (a,b) -> Float.sum(a, b));
	}
	
	public float retenciones() {
		return empleados.stream().
				map((empleado) -> empleado.retenciones()).
				reduce(0f, (a,b) -> Float.sum(a, b));
	}
}
