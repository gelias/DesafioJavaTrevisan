package desafio.src;

import java.util.Calendar;

public class IngressoCrianca extends Ingresso {

	public IngressoCrianca(Calendar dataCompra, double valorIngresso) {
		super(dataCompra, valorIngresso);
	}

	@Override
	public double getValorComDesconto() {
		
		double percentualDesconto = 0;
		int diaSemana = super.dataCompra.get(Calendar.DAY_OF_WEEK);
		
		switch (diaSemana) {
		case Calendar.MONDAY:
			percentualDesconto = 0.10;
			break;
		case Calendar.TUESDAY:
			percentualDesconto = 0.15;
			break;
		case Calendar.WEDNESDAY:
			percentualDesconto = 0.30;
			break;			
		case Calendar.FRIDAY:
			percentualDesconto = 0.11;
			break;
		}
		
		if (Feriado.isFeriadoNacional(super.dataCompra)) {
			percentualDesconto = 0;
		}		
		
		return (super.valorIngresso - (super.valorIngresso * percentualDesconto));
	}
}
