package empresa;

import empleado.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.*;

public class EmpresaTest {
	Empleado johnny = new PlantaPermanente("Johnny", "Salta 123", "Casado", new Date(100, 11, 22), 800000, 2, 10);
	Empleado laura = new PlantaTemporaria("Laura", "Mitre 4050", "Soltera", new Date(70, 8, 3), 900000, new Date(130, 2, 2), 6);
	Empleado fidel = new Contratado("Fidel", "Haskell 838", "Soltero", new Date(15, 4, 30), 600000, 658234, "Cheque");
	List<Empleado> empleados = new ArrayList<Empleado>();
	
	Empresa herreraSA = new Empresa("Herrera S.A.", "22-14983827-7", empleados);
	
	@Test
	public void totalSueldosNetos() {
		empleados.add(johnny);
		empleados.add(laura);
		empleados.add(fidel);
		
		//sueldo Neto de johnny: 800000 + 300 + 100 + 500 - 80130 - 120135 = 600635
		assertEquals(600635, johnny.sueldoNeto());
		//sueldo Neto de laura: 900000 + 240 - 90024 - 25 - 90024 - 30 = 720137
		assertEquals(720137, laura.sueldoNeto());
		//sueldo Neto de fidel: 600000 - 50 = 599950
		assertEquals(599950, fidel.sueldoNeto());
		
		//Total sueldos netos: 600635 + 720137 + 599950 = 1920722
		assertEquals(1920722, herreraSA.totalSueldosNetos());
	}
	
	@Test
	public void liquidacionDeSueldos() {
		empleados.add(johnny);
		empleados.add(laura);
		empleados.add(fidel);
		
		assertDoesNotThrow(() -> { herreraSA.realizarLiquidacionSueldos(); } );
		assertEquals(3, herreraSA.getRecibosHaberes().size());
	}
	
}
