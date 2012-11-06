package desafio.src;

import java.util.Calendar;

public class IngressoEstudante extends Ingresso {

	public IngressoEstudante(Calendar dataCompra, double valorIngresso) {
		super(dataCompra, valorIngresso);
	}

	@Override
	public double getValorComDesconto() {
		
		double percentualDesconto = 0.35;
		int diaSemana = super.dataCompra.get(Calendar.DAY_OF_WEEK);
		
		switch (diaSemana) {
		case Calendar.WEDNESDAY:
			percentualDesconto = 0.50;
			break;			
		case Calendar.SATURDAY:
		case Calendar.SUNDAY:
			percentualDesconto = 0;
			break;
		}
		
		if (Feriado.isFeriadoNacional(super.dataCompra)) {
			percentualDesconto = 0;
		}		
		
		return (super.valorIngresso - (super.valorIngresso * percentualDesconto));
	}
}
