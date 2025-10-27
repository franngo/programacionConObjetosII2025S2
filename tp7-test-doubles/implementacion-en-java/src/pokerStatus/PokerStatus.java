package pokerStatus;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

public class PokerStatus {
	
	//hay póquer cuando 4 de las 5 cartas tienen mismo número/valor
	//para que haya póquer, o la primera va a ser igual a al menos 3 de las otras, o la segunda va a ser igual a 
	//al menos 3 de las otras.
	public boolean verificar(String c1, String c2, String c3, String c4, String c5) {
		boolean b1 = es10(c1) ? hayPoquerDe10(c2, c3, c4, c5) : hayPoquer(c1.substring(0, 1), c2, c3, c4, c5);
		boolean b2 = es10(c2) ? hayPoquerDe10(c1, c3, c4, c5) : hayPoquer(c2.substring(0, 1), c1, c3, c4, c5);
		
		return b1 || b2;
	}
	
	private boolean es10(String c) {
		return c.substring(0, 2).equals("10");
	}
	
	private boolean hayPoquerDe10(String c1, String c2, String c3, String c4) {
		Stream<String> cartas = Stream.of(c1, c2, c3, c4);
		long resultado = cartas.filter( (c) -> c.substring(0, 2).equals("10") ).count();
		return resultado>=3; //3 porque necesito tres más respecto a la original para llegar a las 4 necesarias
	}
	
	private boolean hayPoquer(String val, String c1, String c2, String c3, String c4) {
		Stream<String> cartas = Stream.of(c1, c2, c3, c4);
		long resultado = cartas.filter( (c) -> c.substring(0, 1).equals(val) ).count();
		return resultado>=3; //3 porque necesito tres más respecto a la original para llegar a las 4 necesarias
	}
	
	//Este te devuelve el String "Poquer", "Color", "Trio" o "Nada" según lo que tengas en la mano de póquer.
	//La manos solo puede ser una de estas cosas a la vez, excepto por póquer y trio. En caso de ser ambas dos, se
	//devolverá póquer, que tiene mayor valor que un trio.
	//Para esto último, primero me fijo si hay póquer, y, si no hay, después me fijo si hay trio.
	//Como al ya saber que se da una cosa, sé que no se dará ninguna otra (o quizás una peor), directamente devuelvo
	//el string que informa esto y no sigo procesando para revisar el resto de casos.
	public String verificarExtendido(String c1, String c2, String c3, String c4, String c5) {
		boolean b1 = es10(c1) ? hayPoquerDe10(c2, c3, c4, c5) : hayPoquer(c1.substring(0, 1), c2, c3, c4, c5);
		boolean b2 = es10(c2) ? hayPoquerDe10(c1, c3, c4, c5) : hayPoquer(c2.substring(0, 1), c1, c3, c4, c5);
		
		if(b1 || b2) { return "Poquer"; }
		
		b1 = es10(c1) ? hayTrioDe10(c2, c3, c4, c5) : hayTrio(c1.substring(0, 1), c2, c3, c4, c5);
		b2 = es10(c2) ? hayTrioDe10(c1, c3, c4, c5) : hayTrio(c2.substring(0, 1), c1, c3, c4, c5);
		boolean b3 = es10(c3) ? hayTrioDe10(c1, c2, c4, c5) : hayTrio(c3.substring(0, 1), c1, c2, c4, c5);
		
		if(b1 || b2 || b3) { return "Trio"; }
		
		if(hayColor(c1, c2, c3, c4, c5)) { 
			return "Color"; 
		} else {
			return "Nada";
		}
	}
	
	private boolean hayTrioDe10(String c1, String c2, String c3, String c4) {
		Stream<String> cartas = Stream.of(c1, c2, c3, c4);
		long resultado = cartas.filter( (c) -> c.substring(0, 2).equals("10") ).count();
		return resultado>=2; //2 porque necesito dos más respecto a la original para llegar a las 3 necesarias
	}
	
	private boolean hayTrio(String val, String c1, String c2, String c3, String c4) {
		Stream<String> cartas = Stream.of(c1, c2, c3, c4);
		long resultado = cartas.filter( (c) -> c.substring(0, 1).equals(val) ).count();
		return resultado>=2; //2 porque necesito dos más respecto a la original para llegar a las 3 necesarias
	}
	
	private boolean hayColor(String c1, String c2, String c3, String c4, String c5) {
		Stream<String> cartas = Stream.of(c1, c2, c3, c4, c5);
		String palo = es10(c1) ? c1.substring(2,3) : c1.substring(1,2);
		return cartas.allMatch( (c) -> c.contains(palo) ); //si hay una con un palo distinto, es porque no hay color
	}
	
}
