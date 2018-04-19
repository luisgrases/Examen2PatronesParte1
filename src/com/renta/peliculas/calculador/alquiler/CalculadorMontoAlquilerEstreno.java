package com.renta.peliculas.calculador.alquiler;

import com.renta.peliculas.Alquiler;

public class CalculadorMontoAlquilerEstreno implements CalculadorMontoAlquiler {

	@Override
	public double calcularMontoAlquiler(Alquiler alquiler) {
		return alquiler.getDiasAlquilado() * 3;
	}

}
