package sistemaPublicaciones;

import java.util.List;
import java.util.Map;

public class MiembroLaboratorio implements Investigador {
	@Override
	public void notificar(String titulo, Map<String, String> autoresFiliaciones, String tipoArticulo, 
			String lugarPublicacion, List<String> palabrasClave) {
		System.out.println("He recibido la notificación de la carga de un artículo acorde a mis intereses. Su nombre es "
				+ titulo);
	}
}
