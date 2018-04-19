package com.renta.peliculas;

public class FactoryCalculadorMontoAlquiler {
	public static CalculadorMontoAlquiler getCalculadorMontoAlquiler(Alquiler alquiler) {
		switch(alquiler.getDisco().getPelicula().getCodigoPrecio()) {
			case Pelicula.INFANTIL: return new CalculadorMontoAlquilerInfantil();
			case Pelicula.NORMAL: return new CalculadorMontoAlquilerNormal();
			case Pelicula.ESTRENO: return new CalculadorMontoAlquilerEstreno();
			default: return new CalculadorMontoAlquilerNormal();
		}
	}
}
