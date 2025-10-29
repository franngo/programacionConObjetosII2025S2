package sistemaPublicaciones;

import java.util.List;
import java.util.Map;

public interface Investigador {
	public void notificar(String titulo, Map<String, String> autoresFiliaciones, String tipoArticulo, 
			String lugarPublicacion, List<String> palabrasClave);
}
