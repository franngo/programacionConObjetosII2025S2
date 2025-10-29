package sistemaPublicaciones;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ManejadorSistPub {
	private Map<String, List<Investigador>> suscriptosTitulo = new HashMap<String, List<Investigador>>();
	private Map<String, List<Investigador>> suscriptosAutor = new HashMap<String, List<Investigador>>();
	private Map<String, List<Investigador>> suscriptosFiliacion = new HashMap<String, List<Investigador>>();
	private Map<String, List<Investigador>> suscriptosTipoArticulo = new HashMap<String, List<Investigador>>();
	private Map<String, List<Investigador>> suscriptosLugarPublicacion = new HashMap<String, List<Investigador>>();
	private Map<String, List<Investigador>> suscriptosPalabraClave = new HashMap<String, List<Investigador>>();
	
	public void notificar(String titulo, Map<String, String> autoresFiliaciones, String tipoArticulo, 
			String lugarPublicacion, List<String> palabrasClave) {
		
		if(suscriptosTitulo.containsKey(titulo)) {
			suscriptosTitulo.get(titulo).stream().forEach( (i) -> i.notificar(titulo, autoresFiliaciones, tipoArticulo, lugarPublicacion, palabrasClave) );
		}
		
		if(suscriptosTipoArticulo.containsKey(tipoArticulo)) {
			suscriptosTipoArticulo.get(tipoArticulo).stream().forEach( (i) -> i.notificar(titulo, autoresFiliaciones, tipoArticulo, lugarPublicacion, palabrasClave) );
		}
		
		if(suscriptosLugarPublicacion.containsKey(lugarPublicacion)) {
			suscriptosLugarPublicacion.get(lugarPublicacion).stream().forEach( (i) -> i.notificar(titulo, autoresFiliaciones, tipoArticulo, lugarPublicacion, palabrasClave) );
		}
		
		palabrasClave.stream().forEach( (palabra) -> { 
			if(suscriptosPalabraClave.containsKey(palabra)) {
				suscriptosPalabraClave.get(palabra).stream().forEach( (i) -> i.notificar(titulo, autoresFiliaciones, tipoArticulo, lugarPublicacion, palabrasClave) );
			} 
		} );
		
		autoresFiliaciones.keySet().stream().forEach( (autor) -> { 
			if(suscriptosAutor.containsKey(autor)) {
				suscriptosAutor.get(autor).stream().forEach( (i) -> i.notificar(titulo, autoresFiliaciones, tipoArticulo, lugarPublicacion, palabrasClave) );
			} 
		} );
		
		autoresFiliaciones.values().stream().forEach( (filiacion) -> { 
			if(suscriptosFiliacion.containsKey(filiacion)) {
				suscriptosFiliacion.get(filiacion).stream().forEach( (i) -> i.notificar(titulo, autoresFiliaciones, tipoArticulo, lugarPublicacion, palabrasClave) );
			} 
		} );
		
	}
	
	public void suscribirse(String tipoSuscripcion, String dato, Investigador investigador) {
		
		//no me queda otra que preguntar con ifs. La otra opción es tener 6 métodos de suscripción y desuscripción.
		//también podría haber sido un map de maps.
		if(tipoSuscripcion.equals("Titulo")) {
			this.opDeSuscripcion(suscriptosTitulo, dato, investigador);
		} else if(tipoSuscripcion.equals("Autor")) {
			this.opDeSuscripcion(suscriptosAutor, dato, investigador);
		} else if(tipoSuscripcion.equals("Filiacion")) {
			this.opDeSuscripcion(suscriptosFiliacion, dato, investigador);
		} else if(tipoSuscripcion.equals("Tipo de Articulo")) {
			this.opDeSuscripcion(suscriptosTipoArticulo, dato, investigador);
		} else if(tipoSuscripcion.equals("Lugar de Publicacion")) {
			this.opDeSuscripcion(suscriptosLugarPublicacion, dato, investigador);
		} else if(tipoSuscripcion.equals("Palabra Clave")) {
			this.opDeSuscripcion(suscriptosPalabraClave, dato, investigador);
		}
		
	}
	
	private void opDeSuscripcion(Map<String, List<Investigador>> suscritos, String dato, Investigador investigador) {
		
		if(suscritos.containsKey(dato)) {
			suscritos.get(dato).add(investigador);
		} else {
			List<Investigador> lista = new ArrayList<Investigador>();
			lista.add(investigador);
			suscritos.put(dato, lista);
		}
		
	}
	
	public void desuscribirse(String tipoDesuscripcion, String dato, Investigador investigador) {
		
		if(tipoDesuscripcion.equals("Titulo")) {
			this.opDeDesuscripcion(suscriptosTitulo, dato, investigador);
		} else if(tipoDesuscripcion.equals("Autor")) {
			this.opDeDesuscripcion(suscriptosAutor, dato, investigador);
		} else if(tipoDesuscripcion.equals("Filiacion")) {
			this.opDeDesuscripcion(suscriptosFiliacion, dato, investigador);
		} else if(tipoDesuscripcion.equals("Tipo de Articulo")) {
			this.opDeDesuscripcion(suscriptosTipoArticulo, dato, investigador);
		} else if(tipoDesuscripcion.equals("Lugar de Publicacion")) {
			this.opDeDesuscripcion(suscriptosLugarPublicacion, dato, investigador);
		} else if(tipoDesuscripcion.equals("Palabra Clave")) {
			this.opDeDesuscripcion(suscriptosPalabraClave, dato, investigador);
		}
		
	}
	
	private void opDeDesuscripcion(Map<String, List<Investigador>> suscritos, String dato, Investigador investigador) {
		
		if(suscritos.containsKey(dato)) {
			suscritos.get(dato).remove(investigador);
		}
		
	}
	
	//para test
	protected int cantDeSuscriptosA(String tipoDato, String dato) {
		
		if(tipoDato.equals("Titulo")) {
			return this.opDeRevision(suscriptosTitulo, dato);
		} else if(tipoDato.equals("Autor")) {
			return this.opDeRevision(suscriptosAutor, dato);
		} else if(tipoDato.equals("Filiacion")) {
			return this.opDeRevision(suscriptosFiliacion, dato);
		} else if(tipoDato.equals("Tipo de Articulo")) {
			return this.opDeRevision(suscriptosTipoArticulo, dato);
		} else if(tipoDato.equals("Lugar de Publicacion")) {
			return this.opDeRevision(suscriptosLugarPublicacion, dato);
		} else if(tipoDato.equals("Palabra Clave")) {
			return this.opDeRevision(suscriptosPalabraClave, dato);
		} else {
			return 0;
		}
		
	}
	
	//para test
	private int opDeRevision(Map<String, List<Investigador>> suscritos, String dato) {
		
		if(suscritos.containsKey(dato)) {
			return suscritos.get(dato).size();
		} else {
			return 0;
		}
		
	}
	
}
