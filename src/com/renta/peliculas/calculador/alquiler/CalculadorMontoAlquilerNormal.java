package com.renta.peliculas.calculador.alquiler;

import com.renta.peliculas.Alquiler;

public class CalculadorMontoAlquilerNormal implements CalculadorMontoAlquiler {

	@Override
	public double calcularMontoAlquiler(Alquiler alquiler) {
		double montoAlquiler = 2;
        if (alquiler.getDiasAlquilado() > 2)
            montoAlquiler += (alquiler.getDiasAlquilado() - 2) * 1.5;
        return montoAlquiler;
	}
	
}
