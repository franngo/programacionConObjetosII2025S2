package sistemaPublicaciones;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaPublicacionesTest {
	ManejadorSistPub manejador = mock(ManejadorSistPub.class);
	SistemaPublicaciones sistema = new SistemaPublicaciones(manejador);
	Map<String, String> autoresFiliaciones = new HashMap<String, String>();
	List<String> palabrasClave = new ArrayList<String>();
		
	@Test
	public void cargar() {
		autoresFiliaciones.put("Flavia", "Universidad Nacional de Quilmes");
		autoresFiliaciones.put("Denise", "Universidad Nacional de Quilmes");
		palabrasClave.add("enseñanza");
		palabrasClave.add("universidad");
		sistema.cargar("Organización de Computadoras usando QSim", autoresFiliaciones, "de investigación", 
				"Revista Sobre Pedagogía", palabrasClave);
		verify(manejador).notificar("Organización de Computadoras usando QSim", autoresFiliaciones, "de investigación", 
				"Revista Sobre Pedagogía", palabrasClave);
	}
}
