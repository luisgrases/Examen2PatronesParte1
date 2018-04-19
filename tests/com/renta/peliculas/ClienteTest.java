package com.renta.peliculas;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ClienteTest {

	@Test
	public void RetornaElReporteCorrectoParaPeliculaInfantilSinRetraso() {
		Cliente cliente = new Cliente("Luis");
		Pelicula pelicula1 = new Pelicula("Spiderman", 2);
		Disco disco1 = new Disco("1", pelicula1);
		Alquiler alquiler1 = new Alquiler(disco1, 1);
		cliente.addRental(alquiler1);
		assertEquals(
			cliente.statement(), 
			"Alquileres de Luis:\n" + 
			"	Spiderman	1.5\n" + 
			"Monto total:  1.5\n" + 
			"Gano 1 puntos por alquiler frecuente"
		);
	}
	
	@Test
	public void RetornaElReporteCorrectoParaPeliculaInfantilConRetraso() {
		Cliente cliente = new Cliente("Luis");
		Pelicula pelicula1 = new Pelicula("Spiderman", 2);
		Disco disco1 = new Disco("1", pelicula1);
		Alquiler alquiler1 = new Alquiler(disco1, 5);
		cliente.addRental(alquiler1);
		assertEquals(
			cliente.statement(), 
			"Alquileres de Luis:\n" + 
			"	Spiderman	4.5\n" + 
			"Monto total:  4.5\n" + 
			"Gano 1 puntos por alquiler frecuente"
		);
	}
	
	@Test
	public void RetornaElReporteCorrectoParaPeliculaEstrenoSinRetraso() {
		Cliente cliente = new Cliente("Luis");
		Pelicula pelicula1 = new Pelicula("Spiderman", 1);
		Disco disco1 = new Disco("1", pelicula1);
		Alquiler alquiler1 = new Alquiler(disco1, 1);
		cliente.addRental(alquiler1);
		assertEquals(
			cliente.statement(), 
			"Alquileres de Luis:\n" + 
			"	Spiderman	3.0\n" + 
			"Monto total:  3.0\n" + 
			"Gano 1 puntos por alquiler frecuente"
		);
		
	}
	
	@Test
	public void RetornaElReporteCorrectoParaPeliculaEstrenoConRetraso() {
		Cliente cliente = new Cliente("Luis");
		Pelicula pelicula1 = new Pelicula("Spiderman", 1);
		Disco disco1 = new Disco("1", pelicula1);
		Alquiler alquiler1 = new Alquiler(disco1, 5);
		cliente.addRental(alquiler1);
		assertEquals(
			cliente.statement(), 
			"Alquileres de Luis:\n" + 
			"	Spiderman	15.0\n" + 
			"Monto total:  15.0\n" + 
			"Gano 2 puntos por alquiler frecuente"
		);
		
	}
	
	@Test
	public void RetornaElReporteCorrectoParaPeliculaNormalSinRetraso() {
		Cliente cliente = new Cliente("Luis");
		Pelicula pelicula1 = new Pelicula("Spiderman", 0);
		Disco disco1 = new Disco("1", pelicula1);
		Alquiler alquiler1 = new Alquiler(disco1, 1);
		cliente.addRental(alquiler1);
		assertEquals(
			cliente.statement(), 
			"Alquileres de Luis:\n" + 
			"	Spiderman	2.0\n" + 
			"Monto total:  2.0\n" + 
			"Gano 1 puntos por alquiler frecuente"
		);
		
	}
	
	@Test
	public void RetornaElReporteCorrectoParaPeliculaNormalConRetraso() {
		Cliente cliente = new Cliente("Luis");
		Pelicula pelicula1 = new Pelicula("Spiderman", 0);
		Disco disco1 = new Disco("1", pelicula1);
		Alquiler alquiler1 = new Alquiler(disco1, 5);
		cliente.addRental(alquiler1);
		assertEquals(
			cliente.statement(), 
			"Alquileres de Luis:\n" + 
			"	Spiderman	6.5\n" + 
			"Monto total:  6.5\n" + 
			"Gano 1 puntos por alquiler frecuente"
		);
		
	}
	
	@Test
	public void RetornaElReporteCorrectoParaMultiplesAlquileres() {
		Cliente cliente = new Cliente("Luis");
		
		Pelicula pelicula1 = new Pelicula("Spiderman", 0);
		Disco disco1 = new Disco("1", pelicula1);
		Alquiler alquiler1 = new Alquiler(disco1, 5);

		Pelicula pelicula2 = new Pelicula("Los Simpson", 1);
		Disco disco2 = new Disco("1", pelicula2);
		Alquiler alquiler2 = new Alquiler(disco2, 1);
		
		cliente.addRental(alquiler1);
		cliente.addRental(alquiler2);
		
		System.out.println(cliente.statement());
		assertEquals(
			cliente.statement(), 
			"Alquileres de Luis:\n" + 
			"	Spiderman	6.5\n" + 
			"	Los Simpson	3.0\n" + 
			"Monto total:  9.5\n" + 
			"Gano 2 puntos por alquiler frecuente"
		);
		
	}
	
	

}
