package com.renta.peliculas;

import java.util.HashMap;

public class Registrar {
	private static HashMap Peliculas = new HashMap();
	private static HashMap Clientes = new HashMap();
	
	public static Object get(Registrable registrable, String nombre) {
		switch(registrable) {
			case PELICULAS: return Peliculas.get(nombre);
			case CLIENTES: return Clientes.get(nombre);
		}
		return null;
	}
	
	public static void add(Registrable registrable, Object objeto) {
		switch(registrable) {
			case PELICULAS: Peliculas.put(((Pelicula)objeto).getNombre(), (Pelicula) objeto); break;
			case CLIENTES: Clientes.put(((Cliente)objeto).getNombre(), (Cliente) objeto); break; 
		}
	}
	
	public enum Registrable {
		PELICULAS,
		CLIENTES
	}

}
