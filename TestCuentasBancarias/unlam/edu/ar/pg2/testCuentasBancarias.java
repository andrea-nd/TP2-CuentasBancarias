package unlam.edu.ar.pg2;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class testCuentasBancarias {

	@Test
	public void testQueNoExtraeDineroDeCuentaSueldo() {
		
		CuentaSueldo nuevaExtraccion=new CuentaSueldo(100.00);
		
		nuevaExtraccion.realizarExtraccion(200.00);
		nuevaExtraccion.realizarExtraccion(110.00);
		
		Double saldoRestante=nuevaExtraccion.getSaldo();
		
		Double saldoRestanteEsperado=100.00;
		
		assertEquals(saldoRestanteEsperado, saldoRestante);
	}

	@Test
	public void testQueExtraeDineroDeCuentaSueldo() {
		
		CuentaSueldo nuevaExtraccion=new CuentaSueldo(100.00);
		
		nuevaExtraccion.realizarExtraccion(50.00);
		
		Double saldoRestante=nuevaExtraccion.getSaldo();
		
		Double saldoRestanteEsperado=50.00;
		
		assertEquals(saldoRestanteEsperado, saldoRestante);
	}
	
	@Test
	public void testQueExtraeDineroDeCajaDeAhorroSinLlegarALaQuintaExtraccion() {
		
		CajaDeAhorro nuevaExtraccion=new CajaDeAhorro(800.00);
		
		nuevaExtraccion.realizarExtraccion(50.00);
		nuevaExtraccion.realizarExtraccion(50.00);
		nuevaExtraccion.realizarExtraccion(50.00);
		nuevaExtraccion.realizarExtraccion(50.00);
		
		Double saldoRestante=nuevaExtraccion.getSaldo();
		
		Double saldoRestanteEsperado=600.00;
		
		assertEquals(saldoRestanteEsperado, saldoRestante);
		
	}
	
	@Test
	public void testQueExtraeDineroDeCajaDeAhorroPasandoLaQuintaExtraccion() {
		
		CajaDeAhorro nuevaExtraccion=new CajaDeAhorro(500.00);
		
		nuevaExtraccion.realizarExtraccion(50.00);
		nuevaExtraccion.realizarExtraccion(50.00);
		nuevaExtraccion.realizarExtraccion(50.00);
		nuevaExtraccion.realizarExtraccion(50.00);
		nuevaExtraccion.realizarExtraccion(50.00);
		nuevaExtraccion.realizarExtraccion(50.00);
		
		Double saldoRestante=nuevaExtraccion.getSaldo();
		
		Double saldoRestanteEsperado=194.00;
		
		assertEquals(saldoRestanteEsperado, saldoRestante);
		
	}
	
	
	@Test
	public void testQueExtraeDineroDeCuentaCorrienteSinPedirPrestado() {
		
		CuentaCorriente nuevaExtraccion=new CuentaCorriente(1000.00, 300.00);
		
		nuevaExtraccion.realizarExtraccion(900.00);
		
		Double QuedaDebiendo=nuevaExtraccion.getDeudaAlBanco();
		Double saldoRestante=nuevaExtraccion.getSaldo();
		
		Double saldoRestanteEsperado=100.00;
		Double quedaDebiendoEsperado=0.00;
		
		assertEquals(saldoRestanteEsperado, saldoRestante);
		assertEquals(quedaDebiendoEsperado, QuedaDebiendo);
		
	}
	
	@Test
	public void testQueExtraeDineroDeCuentaCorrientePidiendoPrestado() {
		
		CuentaCorriente nuevaExtraccion=new CuentaCorriente(1000.00, 300.00);
		
		nuevaExtraccion.realizarExtraccion(1100.00);
		
		Double QuedaDebiendo=nuevaExtraccion.getDeudaAlBanco();
		Double saldoRestante=nuevaExtraccion.getSaldo();
		
		Double saldoRestanteEsperado=0.00;
		Double quedaDebiendoEsperado=105.00;
		
		assertEquals(saldoRestanteEsperado, saldoRestante);
		assertEquals(quedaDebiendoEsperado, QuedaDebiendo);
		
	}

	@Test
	public void testQueNoPuedeExtraerDineroPorqueEsInsuficienteElDescubierto() {
		
		CuentaCorriente nuevaExtraccion=new CuentaCorriente(1000.00, 300.00);
		
		nuevaExtraccion.realizarExtraccion(2100.00);
		
		Double QuedaDebiendo=nuevaExtraccion.getDeudaAlBanco();
		Double saldoRestante=nuevaExtraccion.getSaldo();
		
		Double saldoRestanteEsperado=1000.00;
		Double quedaDebiendoEsperado=0.00;
		
		assertEquals(saldoRestanteEsperado, saldoRestante);
		assertEquals(quedaDebiendoEsperado, QuedaDebiendo);
		
	}
	
}
