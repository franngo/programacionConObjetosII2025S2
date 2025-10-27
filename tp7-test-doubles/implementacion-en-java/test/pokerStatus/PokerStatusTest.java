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
	
	//tres
	String tresP = "3P";
	String tresD = "3D";
	String tresC = "3C";
	String tresT = "3T";
	
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
	
	//////////////////////////////////////////////////////////////////////////////
	///punto 1
	
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
	
	//////////////////////////////////////////////////////////////////////////////
	///punto 2
	
	@Test
	public void verificarExtendidoConAsesYDoses() {
		assertEquals("Nada", poqEst.verificarExtendido(aP, qT, aC, dosP, dosT)); //nada
		assertEquals("Poquer", poqEst.verificarExtendido(aP, aD, aT, aC, dosP)); //póquer
		assertEquals("Trio", poqEst.verificarExtendido(dosP, aD, dosT, aC, aP)); //trio
		assertEquals("Color", poqEst.verificarExtendido(aD, dosD, tresD, qD, diezD)); //color
	}
	
	@Test
	public void verificarExtendidoConDieces() {
		assertEquals("Nada", poqEst.verificarExtendido(diezP, qP, dosD, diezC, aD)); //nada
		assertEquals("Poquer", poqEst.verificarExtendido(diezP, diezD, diezC, diezT, dosP)); //póquer
		assertEquals("Trio", poqEst.verificarExtendido(dosP, aD, diezD, diezC, diezT)); //trio
	}
	
	//////////////////////////////////////////////////////////////////////////////
	///punto 3
	
	//ases
	Carta cartaAP = new Carta("A", "P");
	Carta cartaAD = new Carta("A", "D");
	Carta cartaAC = new Carta("A", "C");
	Carta cartaAT = new Carta("A", "T");
	
	//dos
	Carta cartaDosP = new Carta("2", "P");
	Carta cartaDosD = new Carta("2", "D");
	Carta cartaDosC = new Carta("2", "C");
	Carta cartaDosT = new Carta("2", "T");
	
	//tres
	Carta cartaTresP = new Carta("3", "P");
	Carta cartaTresD = new Carta("3", "D");
	Carta cartaTresC = new Carta("3", "C");
	Carta cartaTresT = new Carta("3", "T");
	
	//reinas
	Carta cartaQP = new Carta("Q", "P");
	Carta cartaQD = new Carta("Q", "D");
	Carta cartaQC = new Carta("Q", "C");
	Carta cartaQT = new Carta("Q", "T");
	
	//dieces
	Carta cartaDiezP = new Carta("10", "P");
	Carta cartaDiezD = new Carta("10", "D");
	Carta cartaDiezC = new Carta("10", "C");
	Carta cartaDiezT = new Carta("10", "T");
	
	@Test
	public void verificarCartasConAsesYDoses() {
		assertEquals("Nada", poqEst.verificarCartas(cartaAP, cartaQT, cartaAC, cartaDosP, cartaDosT)); //nada
		assertEquals("Poquer", poqEst.verificarCartas(cartaAP, cartaAD, cartaAT, cartaAC, cartaDosP)); //póquer
		assertEquals("Trio", poqEst.verificarCartas(cartaDosP, cartaAD, cartaDosT, cartaAC, cartaAP)); //trio
		assertEquals("Color", poqEst.verificarCartas(cartaAD, cartaDosD, cartaTresD, cartaQD, cartaDiezD)); //color
	}
	
	@Test
	public void verificarCartasConDieces() {
		assertEquals("Nada", poqEst.verificarCartas(cartaDiezP, cartaQP, cartaDosD, cartaDiezC, cartaAD)); //nada
		assertEquals("Poquer", poqEst.verificarCartas(cartaDiezP, cartaDiezD, cartaDiezC, cartaDiezT, cartaDosP)); //póquer
		assertEquals("Trio", poqEst.verificarCartas(cartaDosP, cartaAD, cartaDiezD, cartaDiezC, cartaDiezT)); //trio
	}
	
}
