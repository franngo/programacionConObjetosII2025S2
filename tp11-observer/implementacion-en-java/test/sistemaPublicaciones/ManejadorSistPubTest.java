package sistemaPublicaciones;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ManejadorSistPubTest {
	ManejadorSistPub manejador = new ManejadorSistPub();
	Map<String, String> autoresFiliaciones = new HashMap<String, String>();
	List<String> palabrasClave = new ArrayList<String>();
	Investigador fidel = mock(Investigador.class);
	Investigador cesar = mock(Investigador.class);
	Investigador cristian = mock(Investigador.class);
	
	@Test
	public void notificar() {
		autoresFiliaciones.put("Flavia", "Universidad Nacional de Quilmes");
		autoresFiliaciones.put("Denise", "Universidad Nacional de Quilmes");
		palabrasClave.add("enseñanza");
		palabrasClave.add("universidad");
		manejador.suscribirse("Titulo", "Packet Tracer", cesar);
		manejador.suscribirse("Palabra Clave", "Redes de Computadoras", cesar);
		manejador.suscribirse("Palabra Clave", "universidad", fidel);
		manejador.suscribirse("Tipo de Articulo", "de investigación", cristian);
		
		manejador.notificar("Organización de Computadoras usando QSim", autoresFiliaciones, "de investigación", 
				"Revista Sobre Pedagogía", palabrasClave);
		verify(fidel).notificar("Organización de Computadoras usando QSim", autoresFiliaciones, "de investigación", 
				"Revista Sobre Pedagogía", palabrasClave);
		verify(cristian).notificar("Organización de Computadoras usando QSim", autoresFiliaciones, "de investigación", 
				"Revista Sobre Pedagogía", palabrasClave);
		verify(cesar, never()).notificar("Organización de Computadoras usando QSim", autoresFiliaciones, "de investigación", 
				"Revista Sobre Pedagogía", palabrasClave);
	}

	@Test
	public void suscribirse() {
		manejador.suscribirse("Titulo", "Packet Tracer", cesar);
		manejador.suscribirse("Palabra Clave", "Redes de Computadoras", cesar);
		manejador.suscribirse("Palabra Clave", "universidad", cesar);
		manejador.suscribirse("Palabra Clave", "universidad", cristian);
		manejador.suscribirse("Palabra Clave", "universidad", fidel);
		manejador.suscribirse("Tipo de Articulo", "de investigación", cristian);
		manejador.suscribirse("Tipo de Articulo", "de investigación", fidel);
		assertEquals(1, manejador.cantDeSuscriptosA("Titulo", "Packet Tracer"));
		assertEquals(1, manejador.cantDeSuscriptosA("Palabra Clave", "Redes de Computadoras"));
		assertEquals(3, manejador.cantDeSuscriptosA("Palabra Clave", "universidad"));
		assertEquals(2, manejador.cantDeSuscriptosA("Tipo de Articulo", "de investigación"));
	}
	
	@Test
	public void desuscribirse() {
		manejador.suscribirse("Palabra Clave", "universidad", cesar);
		manejador.suscribirse("Palabra Clave", "universidad", cristian);
		manejador.suscribirse("Palabra Clave", "universidad", fidel);
		assertEquals(3, manejador.cantDeSuscriptosA("Palabra Clave", "universidad"));
		manejador.desuscribirse("Palabra Clave", "universidad", cesar);
		assertEquals(2, manejador.cantDeSuscriptosA("Palabra Clave", "universidad"));
		manejador.desuscribirse("Palabra Clave", "universidad", cristian);
		assertEquals(1, manejador.cantDeSuscriptosA("Palabra Clave", "universidad"));
		manejador.desuscribirse("Palabra Clave", "universidad", fidel);
		assertEquals(0, manejador.cantDeSuscriptosA("Palabra Clave", "universidad"));
	}

}
