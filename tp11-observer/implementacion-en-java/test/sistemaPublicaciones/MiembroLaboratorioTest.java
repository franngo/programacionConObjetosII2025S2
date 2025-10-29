package sistemaPublicaciones;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MiembroLaboratorioTest {
	Map<String, String> autoresFiliaciones = new HashMap<String, String>();
	List<String> palabrasClave = new ArrayList<String>();
	MiembroLaboratorio fidel = new MiembroLaboratorio();
	
	@Test
	public void notificar() {
		autoresFiliaciones.put("Flavia", "Universidad Nacional de Quilmes");
		autoresFiliaciones.put("Denise", "Universidad Nacional de Quilmes");
		palabrasClave.add("enseñanza");
		palabrasClave.add("universidad");
		fidel.notificar("Organización de Computadoras usando QSim", autoresFiliaciones, "de investigación", 
				"Revista Sobre Pedagogía", palabrasClave);
		//realmente no hay mucho que testear
	}

}
