package com.renta.peliculas;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RegistrarTest {

	@Test
	public void RegistraPeliculas() {
		Pelicula spiderman = new Pelicula("Spiderman", 1);
		Registrar.add("Peliculas", spiderman);
		assertEquals(Registrar.get("Peliculas", "Spiderman"), spiderman);
	}
	
	@Test
	public void RegistraClientes() {
		Cliente cliente = new Cliente("Luis");
		Registrar.add("Clientes", cliente);
		assertEquals(Registrar.get("Clientes", "Luis"), cliente);
	} 

}
