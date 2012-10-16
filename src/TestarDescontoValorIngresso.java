import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import org.junit.Test;


public class TestarDescontoValorIngresso {
	
	private double valorIngressoEstudante = 8.00;
	private double valorIngressoIdoso = 6.00;
	private double valorIngressoCrianca = 5.50;
	
	@Test
	public void DescontoEstudanteEmFinaisDeSemana() throws ParseException {
		
		Date dataCompra = new SimpleDateFormat("yyyy-MM-dd").parse("2012-10-14");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataCompra);
		boolean feriado = false;
		
		IngressoCinema ingresso = new IngressoCinema(cal, TipoIngressoCinema.ESTUDANTE, valorIngressoEstudante, feriado);
		
		double valorIngresso = ingresso.aplicarDescontoNoPrecoIngresso();
		double valorEsperado = (valorIngressoEstudante - (valorIngressoEstudante * 0.35));
				
		assertTrue(valorEsperado == valorIngresso);
	}
	
	@Test
	public void DescontoEstudanteEmFeriados() throws ParseException {
		Date dataCompra = new SimpleDateFormat("yyyy-MM-dd").parse("2012-10-14");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataCompra);
		boolean feriado = true;
		
		IngressoCinema ingresso = new IngressoCinema(cal, TipoIngressoCinema.ESTUDANTE, valorIngressoEstudante, feriado);
		
		double valorIngresso = ingresso.aplicarDescontoNoPrecoIngresso();
		double valorEsperado = (valorIngressoEstudante - (valorIngressoEstudante * 0.35));
				
		assertTrue(valorEsperado == valorIngresso);
	}

	@Test
	public void DescontoEstudanteEmQuartas() throws ParseException {
		Date dataCompra = new SimpleDateFormat("yyyy-MM-dd").parse("2012-10-17");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataCompra);
		boolean feriado = false;
		
		IngressoCinema ingresso = new IngressoCinema(cal, TipoIngressoCinema.ESTUDANTE, valorIngressoEstudante, feriado);
		
		double valorIngresso = ingresso.aplicarDescontoNoPrecoIngresso();
		double valorEsperado = (valorIngressoEstudante - (valorIngressoEstudante * 0.85));
				
		assertTrue(valorEsperado == valorIngresso);
	}

	@Test
	public void DescontoIdosoEmFinaisDeSemana() throws ParseException {
		
		Date dataCompra = new SimpleDateFormat("yyyy-MM-dd").parse("2012-10-14");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataCompra);
		boolean feriado = false;
		
		IngressoCinema ingresso = new IngressoCinema(cal, TipoIngressoCinema.IDOSO, valorIngressoIdoso, feriado);
		
		double valorIngresso = ingresso.aplicarDescontoNoPrecoIngresso();
		double valorEsperado = (valorIngressoIdoso - (valorIngressoIdoso * 0.05));
				
		assertTrue(valorEsperado == valorIngresso);
	}
	
	@Test
	public void DescontoIdosoEmFeriados() throws ParseException {
		Date dataCompra = new SimpleDateFormat("yyyy-MM-dd").parse("2012-10-14");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataCompra);
		boolean feriado = true;
		
		IngressoCinema ingresso = new IngressoCinema(cal, TipoIngressoCinema.IDOSO, valorIngressoIdoso, feriado);
		
		double valorIngresso = ingresso.aplicarDescontoNoPrecoIngresso();
		double valorEsperado = (valorIngressoIdoso - (valorIngressoIdoso * 0.05));
				
		assertTrue(valorEsperado == valorIngresso);
	}
	
	@Test
	public void DescontoIdosoEmSegundas() throws ParseException {
		Date dataCompra = new SimpleDateFormat("yyyy-MM-dd").parse("2012-10-15");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataCompra);
		boolean feriado = false;
		
		IngressoCinema ingresso = new IngressoCinema(cal, TipoIngressoCinema.IDOSO, valorIngressoIdoso, feriado);
		
		double valorIngresso = ingresso.aplicarDescontoNoPrecoIngresso();
		double valorEsperado = (valorIngressoIdoso - (valorIngressoIdoso * 0.10));
				
		assertTrue(valorEsperado == valorIngresso);
	}

	@Test
	public void DescontoIdosoEmTercas() throws ParseException {
		Date dataCompra = new SimpleDateFormat("yyyy-MM-dd").parse("2012-10-16");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataCompra);
		boolean feriado = false;
		
		IngressoCinema ingresso = new IngressoCinema(cal, TipoIngressoCinema.IDOSO, valorIngressoIdoso, feriado);
		
		double valorIngresso = ingresso.aplicarDescontoNoPrecoIngresso();
		double valorEsperado = (valorIngressoIdoso - (valorIngressoIdoso * 0.15));
				
		assertTrue(valorEsperado == valorIngresso);
	}

	@Test
	public void DescontoIdosoEmQuartas() throws ParseException {
		Date dataCompra = new SimpleDateFormat("yyyy-MM-dd").parse("2012-10-17");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataCompra);
		boolean feriado = false;
		
		IngressoCinema ingresso = new IngressoCinema(cal, TipoIngressoCinema.IDOSO, valorIngressoIdoso, feriado);
		
		double valorIngresso = ingresso.aplicarDescontoNoPrecoIngresso();
		double valorEsperado = (valorIngressoIdoso - (valorIngressoIdoso * 0.40));
				
		assertTrue(valorEsperado == valorIngresso);
	}
	
	@Test
	public void DescontoIdosoEmQuintas() throws ParseException {
		Date dataCompra = new SimpleDateFormat("yyyy-MM-dd").parse("2012-10-18");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataCompra);
		boolean feriado = false;
		
		IngressoCinema ingresso = new IngressoCinema(cal, TipoIngressoCinema.IDOSO, valorIngressoIdoso, feriado);
		
		double valorIngresso = ingresso.aplicarDescontoNoPrecoIngresso();
		double valorEsperado = (valorIngressoIdoso - (valorIngressoIdoso * 0.30));
				
		assertTrue(valorEsperado == valorIngresso);
	}
	
	@Test
	public void DescontoCriancaEmSextas() throws ParseException {
		Date dataCompra = new SimpleDateFormat("yyyy-MM-dd").parse("2012-10-19");
		Calendar cal = Calendar.getInstance();
		cal.setTime(dataCompra);
		boolean feriado = false;
		
		IngressoCinema ingresso = new IngressoCinema(cal, TipoIngressoCinema.CRIANCA, valorIngressoCrianca, feriado);
		
		double valorIngresso = ingresso.aplicarDescontoNoPrecoIngresso();
		double valorEsperado = (valorIngressoCrianca - (valorIngressoCrianca * 0.11));
				
		assertTrue(valorEsperado == valorIngresso);
	}	
}
