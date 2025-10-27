package pokerStatus;

public class Carta {
	String valor;
	String palo;
	
	public Carta(String valor, String palo) {
		this.valor = valor;
		this.palo = palo;
	}
	
	public String getPalo() {
		return this.palo;
	}
	
	public String getValor() {
		return this.valor;
	}
	
	public String infoCarta() {
		return this.valor.concat(this.palo);
	}
	
	public boolean es10() {
		return this.valor.equals("10");
	}
	
	public boolean tieneMismoPaloQue(Carta c) {
		return this.palo.equals(c.getPalo());
	}
	
	//no me la piden. La defino para usarla como subtarea en método de pokerStatus.
	public boolean tieneMismoValorQue(Carta c) {
		return this.valor.equals(c.getValor());
	}
	
	public boolean tieneMayorValorQue(Carta c) {
		return this.valor.equals("K") && !(c.getValor().equals("K"))
			|| this.valor.equals("Q") && !(c.getValor().equals("K") || c.getValor().equals("Q"))
			|| this.valor.equals("J") && !(c.getValor().equals("K") || c.getValor().equals("Q") || c.getValor().equals("J")) 
			|| this.esNumMayorSiSonNums(c);//Integer.parseInt(this.valor) > Integer.parseInt(c.getValor());
	}
	
	public boolean esNumMayorSiSonNums(Carta c) {
		return this.tieneValorNumerico() && c.tieneValorNumerico()
				? Integer.parseInt(this.valor) > Integer.parseInt(c.getValor()) 
				: this.tieneValorNumerico() && c.esUnAs(); //si la carta tiene un valor del 2 al 10, ya es mayor que el as
	}
	
	private boolean tieneValorNumerico() {
		try {
			Integer.parseInt(this.valor);
			return true;
		} catch(NumberFormatException nfe) {
			return false;
		}
	}
	
	private boolean esUnAs() {
		return this.valor.equals("A");
	}
	
}
