import java.util.Calendar;

public class IngressoCinema {

	private Calendar dataCompra;
	private double precoBase;
	private TipoIngressoCinema tipo;
	private boolean feriado;

	public IngressoCinema(Calendar dataCompra, TipoIngressoCinema tipo,
			double precoBase, boolean feriado) {
		this.dataCompra = dataCompra;
		this.tipo = tipo;
		this.precoBase = precoBase;
		this.feriado = feriado;
	}

	public double aplicarDescontoNoPrecoIngresso() {
		double percentualDesconto = obterPercentualDescontoIngresso();
		return (precoBase - (precoBase * percentualDesconto));
	}

	private double obterPercentualDescontoIngresso() {

		double percentualDesconto = 0;

		if (tipo == TipoIngressoCinema.ESTUDANTE) {
			percentualDesconto = 0.35;
		}

		int diaSemana = dataCompra.get(Calendar.DAY_OF_WEEK);

		if (diaSemana == Calendar.SATURDAY || diaSemana == Calendar.SUNDAY
				|| feriado) {
			if (tipo == TipoIngressoCinema.IDOSO) {
				percentualDesconto = 0.05;
			}
		} else {
			switch (diaSemana) {
			case Calendar.MONDAY:
				percentualDesconto += 0.10;
				break;
			case Calendar.TUESDAY:
				if (tipo == TipoIngressoCinema.CRIANCA
						|| tipo == TipoIngressoCinema.IDOSO) {
					percentualDesconto += 0.15;
				} else {
					percentualDesconto += 0.05;
				}
				break;
			case Calendar.WEDNESDAY:
				if (tipo == TipoIngressoCinema.IDOSO) {
					percentualDesconto = 0.40;
				} else if (tipo == TipoIngressoCinema.ESTUDANTE) {
					percentualDesconto += 0.50;
				} else {
					percentualDesconto = 0.30;
				}
				break;
			case Calendar.THURSDAY:
				if (tipo == TipoIngressoCinema.IDOSO
						|| tipo == TipoIngressoCinema.ESTUDANTE) {
					percentualDesconto += 0.30;
				}
				break;
			case Calendar.FRIDAY:
				if (tipo == TipoIngressoCinema.CRIANCA) {
					percentualDesconto = 0.11;
				}
				break;
			}
		}
		
		return percentualDesconto;
	}
}
