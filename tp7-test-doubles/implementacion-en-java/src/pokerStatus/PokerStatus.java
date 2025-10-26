package pokerStatus;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class PokerStatus {
	public boolean verificar(String c1, String c2, String c3, String c4, String c5) {
		boolean b1 = es10(c1) ? hayPoquerDe10(c2, c3, c4, c5) : hayPoquer(c1.substring(0, 1), c2, c3, c4, c5);
		boolean b2 = es10(c2) ? hayPoquerDe10(c1, c3, c4, c5) : hayPoquer(c2.substring(0, 1), c1, c3, c4, c5);
		
		return b1 || b2;
	}
	
	public boolean es10(String c) {
		return c.substring(0, 2).equals("10");
	}
	
	public boolean hayPoquerDe10(String c1, String c2, String c3, String c4) {
		Stream<String> cartas = Stream.of(c1, c2, c3, c4);
		long resultado = cartas.filter( (c) -> c.substring(0, 2).equals("10") ).count();
		return resultado>=3; //3 porque necesito tres más respecto a la original para llegar a las 4 necesarias
	}
	
	public boolean hayPoquer(String val, String c1, String c2, String c3, String c4) {
		Stream<String> cartas = Stream.of(c1, c2, c3, c4);
		long resultado = cartas.filter( (c) -> c.substring(0, 1).equals(val) ).count();
		return resultado>=3; //3 porque necesito tres más respecto a la original para llegar a las 4 necesarias
	}
}
