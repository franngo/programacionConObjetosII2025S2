package pokerStatus;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PokerStatusTest {
	
	//ases
	String aP = "AP";
	String aD = "AD";
	String aC = "AC";
	String aT = "AT";
	
	//dos
	String dosP = "2P";
	String dosD = "2D";
	String dosC = "2C";
	String dosT = "2T";
	
	//reinas
	String qP = "QP";
	String qD = "QD";
	String qC = "QC";
	String qT = "QT";
	
	//dieces
	String diezP = "10P";
	String diezD = "10D";
	String diezC = "10C";
	String diezT = "10T";
	
	PokerStatus poqEst = new PokerStatus();
	
	@Test
	public void verificarConAsesYDoses() {
		assertFalse(poqEst.verificar(aP, aD, aC, dosP, dosT)); //no hay póquer
		assertTrue(poqEst.verificar(aP, aD, aT, aC, dosP)); //las primeras cuatro
		assertTrue(poqEst.verificar(dosP, aD, aT, aC, aP)); //las últimas cuatro
		assertTrue(poqEst.verificar(aD, dosP, aT, aC, aP)); //en medio
	}
	
	@Test
	public void verificarConReinas() {
		assertTrue(poqEst.verificar(qP, qD, aC, qT, qC));
	}
	
	@Test
	public void verificarConDieces() {
		assertFalse(poqEst.verificar(qP, diezP, dosD, diezC, aD));
		assertTrue(poqEst.verificar(diezP, qP, diezD, diezC, diezT));
		assertTrue(poqEst.verificar(qP, diezP, diezD, diezC, diezT));
	}
	
}
