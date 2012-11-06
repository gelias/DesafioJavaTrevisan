package desafio.src;

import java.util.Calendar;

public abstract class Ingresso {

	protected double valorIngresso;
	protected Calendar dataCompra;
	
	public Ingresso(Calendar dataCompra, double valorIngresso) {
		this.dataCompra = dataCompra;
		this.valorIngresso = valorIngresso;
	}
	
	public double getValorIngresso() {
		return valorIngresso;
	}
	
	public abstract double getValorComDesconto();
}
