package empresa;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;

import empleado.*;

public class EmpresaTest {
	Empleado johnny = new PlantaPermanente("Johnny", "Salta 123", "Casado", new Date(), 800000, 2, 10);
	Empleado laura = new PlantaTemporaria("Laura", "Mitre 4050", "Soltera", new Date(), 900000, new Date(), 6);
	Empleado fidel = new Contratado("Fidel", "Haskell 838", "Soltero", new Date(), 600000, 658234, "Cheque");
	//TODO Arreglar las dates
	List<Empleado> empleados = new ArrayList<Empleado>();
	
	Empresa herreraSA = new Empresa("Herrera S.A.", "22-14983827-7", empleados);
	
	@BeforeEach
	void setUp() {
		
	}
	
	
	
}
