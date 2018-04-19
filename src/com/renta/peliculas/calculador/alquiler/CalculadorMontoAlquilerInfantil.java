package com.renta.peliculas.calculador.alquiler;

import com.renta.peliculas.Alquiler;

public class CalculadorMontoAlquilerInfantil implements CalculadorMontoAlquiler{

	@Override
	public double calcularMontoAlquiler(Alquiler alquiler) {
		double montoAlquiler = 1.5;
        if (alquiler.getDiasAlquilado() > 3)
            montoAlquiler += (alquiler.getDiasAlquilado() - 3) * 1.5;
        return montoAlquiler; 
	}

}
