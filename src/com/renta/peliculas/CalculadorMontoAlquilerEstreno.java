package com.renta.peliculas;

public class CalculadorMontoAlquilerEstreno implements CalculadorMontoAlquiler {

	@Override
	public double calcularMontoAlquiler(Alquiler alquiler) {
		return alquiler.getDiasAlquilado() * 3;
	}

}
