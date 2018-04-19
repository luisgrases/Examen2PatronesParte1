package com.renta.peliculas;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.renta.peliculas.Registrar.Registrable;

class RegistrarTest {

	@Test
	public void RegistraPeliculas() {
		Pelicula spiderman = new Pelicula("Spiderman", 1);
		Registrar.add(Registrable.PELICULAS, spiderman);
		assertEquals(Registrar.get(Registrable.PELICULAS, "Spiderman"), spiderman);
	}
	
	@Test
	public void RegistraClientes() {
		Cliente cliente = new Cliente("Luis");
		Registrar.add(Registrable.CLIENTES, cliente);
		assertEquals(Registrar.get(Registrable.CLIENTES, "Luis"), cliente);
	} 

}
