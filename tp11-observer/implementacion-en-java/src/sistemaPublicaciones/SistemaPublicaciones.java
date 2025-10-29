package sistemaPublicaciones;

import java.util.List;
import java.util.Map;

public class SistemaPublicaciones {
	private ManejadorSistPub manejador;
	
	public SistemaPublicaciones(ManejadorSistPub manejador) {
		this.manejador = manejador;
	}
	
	public void cargar(String titulo, Map<String, String> autoresFiliaciones, String tipoArticulo, 
			String lugarPublicacion, List<String> palabrasClave) {
		manejador.notificar(titulo, autoresFiliaciones, tipoArticulo, lugarPublicacion, palabrasClave);
	}
}
