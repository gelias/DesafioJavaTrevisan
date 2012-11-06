package desafio.tests;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Calendar;

import org.junit.Test;

import desafio.src.CalendarHelper;
import desafio.src.Feriado;
import desafio.src.Ingresso;
import desafio.src.IngressoCrianca;
import desafio.src.IngressoEstudante;
import desafio.src.IngressoIdoso;

public class TestesDescontoCinema {
	
	private double valorIngressoIdoso = 6.00;
	private double valorIngressoCrianca = 5.00;
	private double valorIngressoEstudante = 8.00;
	
	@Test
	public void ValidarDescontoIdosoDomingosSabadosFeriados() {
		
		ArrayList<Calendar> feriadosNacionais = Feriado.getFeriadosNacionais();
		
		for (Calendar calendar : feriadosNacionais) {
			Ingresso ingresso = new IngressoIdoso(calendar, valorIngressoIdoso);
			
			double valorCalculado = ingresso.getValorComDesconto();
			double valorEsperado = valorIngressoIdoso - (valorIngressoIdoso * 0.05);
			assertEquals(valorEsperado, valorCalculado, 0);
		}
		
		ArrayList<Calendar> finalSemana = new ArrayList<Calendar>();
		finalSemana.add(CalendarHelper.criarCalendarComData("2012-11-03"));
		finalSemana.add(CalendarHelper.criarCalendarComData("2012-11-04"));
		
		for (Calendar calendar : finalSemana) {
			Ingresso ingresso = new IngressoIdoso(calendar, valorIngressoIdoso);
			
			double valorCalculado = ingresso.getValorComDesconto();
			double valorEsperado = valorIngressoIdoso - (valorIngressoIdoso * 0.05);
			assertEquals(valorEsperado, valorCalculado, 0);
		}
	}
	
	@Test
	public void ValidarDescontoIdosoSegundas() {
		
		Calendar cal = CalendarHelper.criarCalendarComData("2011-02-14");
		Ingresso ingresso = new IngressoIdoso(cal, valorIngressoIdoso);
		
		double valorCalculado = ingresso.getValorComDesconto();
		double valorEsperado = valorIngressoIdoso - (valorIngressoIdoso * 0.10);
		assertEquals(valorEsperado, valorCalculado, 0);
	}
	
	@Test
	public void ValidarDescontoEstudante() {
		
		Calendar cal = CalendarHelper.criarCalendarComData("2012-10-29");
		Ingresso ingresso = new IngressoEstudante(cal, valorIngressoEstudante);
		
		double valorCalculado = ingresso.getValorComDesconto();
		double valorEsperado = valorIngressoEstudante - (valorIngressoEstudante * 0.35);
		assertEquals(valorEsperado, valorCalculado, 0);
	}	

	@Test
	public void ValidarDescontoEstudanteQuartas() {
		
		Calendar cal = CalendarHelper.criarCalendarComData("2012-10-31");
		Ingresso ingresso = new IngressoEstudante(cal, valorIngressoEstudante);
		
		double valorCalculado = ingresso.getValorComDesconto();
		double valorEsperado = valorIngressoEstudante - (valorIngressoEstudante * 0.50);
		assertEquals(valorEsperado, valorCalculado, 0);
	}
	
	@Test
	public void ValidarDescontoEstudanteFinaisDeSemana() {
		
		ArrayList<Calendar> finalSemana = new ArrayList<Calendar>();
		finalSemana.add(CalendarHelper.criarCalendarComData("2012-11-03"));
		finalSemana.add(CalendarHelper.criarCalendarComData("2012-11-04"));
		
		for(Calendar cal : finalSemana) {
			Ingresso ingresso = new IngressoEstudante(cal, valorIngressoEstudante);
			
			double valorCalculado = ingresso.getValorComDesconto();
			double valorEsperado = valorIngressoEstudante - (valorIngressoEstudante * 0);
			assertEquals(valorEsperado, valorCalculado, 0);
		}
	}
	
	@Test
	public void ValidarDescontoCriancaSextas() {
		
		ArrayList<Calendar> sextas = new ArrayList<Calendar>();
		sextas.add(CalendarHelper.criarCalendarComData("2012-07-06"));
		sextas.add(CalendarHelper.criarCalendarComData("2011-08-26"));
		
		for(Calendar cal : sextas) {
			Ingresso ingresso = new IngressoCrianca(cal, valorIngressoCrianca);
			
			double valorCalculado = ingresso.getValorComDesconto();
			double valorEsperado = valorIngressoCrianca - (valorIngressoCrianca * 0.11);
			assertEquals(valorEsperado, valorCalculado, 0);
		}
	}		
}
