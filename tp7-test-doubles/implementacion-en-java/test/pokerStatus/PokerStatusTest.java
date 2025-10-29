package pokerStatus;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

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
	
	@Test
	public void tieneMayorValorQue() {
		assertTrue(cartaDiezT.tieneMayorValorQue(cartaTresD));
		assertFalse(cartaDiezT.tieneMayorValorQue(cartaDiezP));
		assertTrue(cartaAP.tieneMayorValorQue(cartaQP));
		assertFalse(cartaAP.tieneMayorValorQue(cartaAD));
		assertFalse(cartaQP.tieneMayorValorQue(cartaAD));
		assertTrue(cartaQP.tieneMayorValorQue(cartaTresD));
	}
	
	//////////////////////////////////////////////////////////////////////////////
	///punto 4 (testear el verificarCartas con test doubles)
	
	Carta cAP = mock(Carta.class);
	Carta cAD = mock(Carta.class);
	Carta cAC = mock(Carta.class);
	Carta cAT = mock(Carta.class);
	
	Carta cDosD = mock(Carta.class);
	
	Carta cTresD = mock(Carta.class);
	
	Carta cQD = mock(Carta.class);
	
	Carta cDiezD = mock(Carta.class);
	
	//agrego los when para tieneMismoValorQue y tieneMismoPaloQue
	//(lo metí en un setUp porque pensaba hacer el ej. siguiente de las jugadas, pero no tengo tiempo)
	@BeforeEach
	public void setUp() {
		//tieneMismoValorQue()
		when(cAP.tieneMismoValorQue(cAD)).thenReturn(true);
		when(cAP.tieneMismoValorQue(cAC)).thenReturn(true);
		when(cAP.tieneMismoValorQue(cAT)).thenReturn(true);
		when(cAP.tieneMismoValorQue(cDosD)).thenReturn(false);
		when(cAP.tieneMismoValorQue(cTresD)).thenReturn(false);
		when(cAP.tieneMismoValorQue(cQD)).thenReturn(false);
		when(cAP.tieneMismoValorQue(cDiezD)).thenReturn(false);
		
		when(cAD.tieneMismoValorQue(cAP)).thenReturn(true);
		when(cAD.tieneMismoValorQue(cAC)).thenReturn(true);
		when(cAD.tieneMismoValorQue(cAT)).thenReturn(true);
		when(cAD.tieneMismoValorQue(cDosD)).thenReturn(false);
		when(cAD.tieneMismoValorQue(cTresD)).thenReturn(false);
		when(cAD.tieneMismoValorQue(cQD)).thenReturn(false);
		when(cAD.tieneMismoValorQue(cDiezD)).thenReturn(false);
		
		when(cAC.tieneMismoValorQue(cAP)).thenReturn(true);
		when(cAC.tieneMismoValorQue(cAD)).thenReturn(true);
		when(cAC.tieneMismoValorQue(cAT)).thenReturn(true);
		when(cAC.tieneMismoValorQue(cDosD)).thenReturn(false);
		when(cAC.tieneMismoValorQue(cTresD)).thenReturn(false);
		when(cAC.tieneMismoValorQue(cQD)).thenReturn(false);
		when(cAC.tieneMismoValorQue(cDiezD)).thenReturn(false);
		
		when(cAT.tieneMismoValorQue(cAP)).thenReturn(true);
		when(cAT.tieneMismoValorQue(cAD)).thenReturn(true);
		when(cAT.tieneMismoValorQue(cAC)).thenReturn(true);
		when(cAT.tieneMismoValorQue(cDosD)).thenReturn(false);
		when(cAT.tieneMismoValorQue(cTresD)).thenReturn(false);
		when(cAT.tieneMismoValorQue(cQD)).thenReturn(false);
		when(cAT.tieneMismoValorQue(cDiezD)).thenReturn(false);
		
		when(cDosD.tieneMismoValorQue(cAP)).thenReturn(false);
		when(cDosD.tieneMismoValorQue(cAD)).thenReturn(false);
		when(cDosD.tieneMismoValorQue(cAC)).thenReturn(false);
		when(cDosD.tieneMismoValorQue(cAT)).thenReturn(false);
		when(cDosD.tieneMismoValorQue(cTresD)).thenReturn(false);
		when(cDosD.tieneMismoValorQue(cQD)).thenReturn(false);
		when(cDosD.tieneMismoValorQue(cDiezD)).thenReturn(false);
		
		when(cTresD.tieneMismoValorQue(cAP)).thenReturn(false);
		when(cTresD.tieneMismoValorQue(cAD)).thenReturn(false);
		when(cTresD.tieneMismoValorQue(cAC)).thenReturn(false);
		when(cTresD.tieneMismoValorQue(cAT)).thenReturn(false);
		when(cTresD.tieneMismoValorQue(cDosD)).thenReturn(false);
		when(cTresD.tieneMismoValorQue(cQD)).thenReturn(false);
		when(cTresD.tieneMismoValorQue(cDiezD)).thenReturn(false);
		
		when(cQD.tieneMismoValorQue(cAP)).thenReturn(false);
		when(cQD.tieneMismoValorQue(cAD)).thenReturn(false);
		when(cQD.tieneMismoValorQue(cAC)).thenReturn(false);
		when(cQD.tieneMismoValorQue(cAT)).thenReturn(false);
		when(cQD.tieneMismoValorQue(cDosD)).thenReturn(false);
		when(cQD.tieneMismoValorQue(cTresD)).thenReturn(false);
		when(cQD.tieneMismoValorQue(cDiezD)).thenReturn(false);
		
		when(cDiezD.tieneMismoValorQue(cAP)).thenReturn(false);
		when(cDiezD.tieneMismoValorQue(cAD)).thenReturn(false);
		when(cDiezD.tieneMismoValorQue(cAC)).thenReturn(false);
		when(cDiezD.tieneMismoValorQue(cAT)).thenReturn(false);
		when(cDiezD.tieneMismoValorQue(cDosD)).thenReturn(false);
		when(cDiezD.tieneMismoValorQue(cTresD)).thenReturn(false);
		when(cDiezD.tieneMismoValorQue(cQD)).thenReturn(false);
		
		//tieneMismoPaloQue()
		when(cAP.tieneMismoPaloQue(cAD)).thenReturn(false);
		when(cAP.tieneMismoPaloQue(cAC)).thenReturn(false);
		when(cAP.tieneMismoPaloQue(cAT)).thenReturn(false);
		when(cAP.tieneMismoPaloQue(cDosD)).thenReturn(false);
		when(cAP.tieneMismoPaloQue(cTresD)).thenReturn(false);
		when(cAP.tieneMismoPaloQue(cQD)).thenReturn(false);
		when(cAP.tieneMismoPaloQue(cDiezD)).thenReturn(false);
		
		when(cAD.tieneMismoPaloQue(cAP)).thenReturn(false);
		when(cAD.tieneMismoPaloQue(cAC)).thenReturn(false);
		when(cAD.tieneMismoPaloQue(cAT)).thenReturn(false);
		when(cAD.tieneMismoPaloQue(cDosD)).thenReturn(true);
		when(cAD.tieneMismoPaloQue(cTresD)).thenReturn(true);
		when(cAD.tieneMismoPaloQue(cQD)).thenReturn(true);
		when(cAD.tieneMismoPaloQue(cDiezD)).thenReturn(true);
		
		when(cAC.tieneMismoPaloQue(cAP)).thenReturn(false);
		when(cAC.tieneMismoPaloQue(cAD)).thenReturn(false);
		when(cAC.tieneMismoPaloQue(cAT)).thenReturn(false);
		when(cAC.tieneMismoPaloQue(cDosD)).thenReturn(false);
		when(cAC.tieneMismoPaloQue(cTresD)).thenReturn(false);
		when(cAC.tieneMismoPaloQue(cQD)).thenReturn(false);
		when(cAC.tieneMismoPaloQue(cDiezD)).thenReturn(false);
		
		when(cAT.tieneMismoPaloQue(cAP)).thenReturn(false);
		when(cAT.tieneMismoPaloQue(cAD)).thenReturn(false);
		when(cAT.tieneMismoPaloQue(cAC)).thenReturn(false);
		when(cAT.tieneMismoPaloQue(cDosD)).thenReturn(false);
		when(cAT.tieneMismoPaloQue(cTresD)).thenReturn(false);
		when(cAT.tieneMismoPaloQue(cQD)).thenReturn(false);
		when(cAT.tieneMismoPaloQue(cDiezD)).thenReturn(false);
		
		when(cDosD.tieneMismoPaloQue(cAP)).thenReturn(false);
		when(cDosD.tieneMismoPaloQue(cAD)).thenReturn(true);
		when(cDosD.tieneMismoPaloQue(cAC)).thenReturn(false);
		when(cDosD.tieneMismoPaloQue(cAT)).thenReturn(false);
		when(cDosD.tieneMismoPaloQue(cTresD)).thenReturn(true);
		when(cDosD.tieneMismoPaloQue(cQD)).thenReturn(true);
		when(cDosD.tieneMismoPaloQue(cDiezD)).thenReturn(true);
		
		when(cTresD.tieneMismoPaloQue(cAP)).thenReturn(false);
		when(cTresD.tieneMismoPaloQue(cAD)).thenReturn(true);
		when(cTresD.tieneMismoPaloQue(cAC)).thenReturn(false);
		when(cTresD.tieneMismoPaloQue(cAT)).thenReturn(false);
		when(cTresD.tieneMismoPaloQue(cDosD)).thenReturn(true);
		when(cTresD.tieneMismoPaloQue(cQD)).thenReturn(true);
		when(cTresD.tieneMismoPaloQue(cDiezD)).thenReturn(true);
		
		when(cQD.tieneMismoPaloQue(cAP)).thenReturn(false);
		when(cQD.tieneMismoPaloQue(cAD)).thenReturn(true);
		when(cQD.tieneMismoPaloQue(cAC)).thenReturn(false);
		when(cQD.tieneMismoPaloQue(cAT)).thenReturn(false);
		when(cQD.tieneMismoPaloQue(cDosD)).thenReturn(true);
		when(cQD.tieneMismoPaloQue(cTresD)).thenReturn(true);
		when(cQD.tieneMismoPaloQue(cDiezD)).thenReturn(true);
		
		when(cDiezD.tieneMismoPaloQue(cAP)).thenReturn(false);
		when(cDiezD.tieneMismoPaloQue(cAD)).thenReturn(true);
		when(cDiezD.tieneMismoPaloQue(cAC)).thenReturn(false);
		when(cDiezD.tieneMismoPaloQue(cAT)).thenReturn(false);
		when(cDiezD.tieneMismoPaloQue(cDosD)).thenReturn(true);
		when(cDiezD.tieneMismoPaloQue(cTresD)).thenReturn(true);
		when(cDiezD.tieneMismoPaloQue(cQD)).thenReturn(true);
	}
	
	@Test
	public void verificarCartasMockeando() {
		assertEquals("Nada", poqEst.verificarCartas(cAD, cQD, cAC, cDosD, cTresD)); //nada
		assertEquals("Poquer", poqEst.verificarCartas(cAP, cAD, cAT, cAC, cDosD)); //póquer
		assertEquals("Trio", poqEst.verificarCartas(cDosD, cAD, cTresD, cAC, cAP)); //trio
		assertEquals("Color", poqEst.verificarCartas(cAD, cDosD, cTresD, cQD, cDiezD)); //color
	}
}
