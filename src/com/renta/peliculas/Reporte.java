package com.renta.peliculas;

import com.renta.peliculas.calculador.alquiler.FactoryCalculadorMontoAlquiler;

public class Reporte {
	static public String generar(Cliente cliente) {
		String result = "Alquileres de " + cliente.getNombre() + ":\n";
        for(Alquiler alquiler: cliente.getAlquileres()) {
        		result += "\t" + alquiler.getDisco().getPelicula().getNombre()+ "\t" + String.valueOf(FactoryCalculadorMontoAlquiler.getCalculadorMontoAlquiler(alquiler).calcularMontoAlquiler(alquiler)) + "\n";
        }
        result +=  "Monto total:  " + String.valueOf(computeMontoTotalAlquileres(cliente)) + "\n";
        result += "Gano " + String.valueOf(computePuntosAlquilerFrecuente(cliente)) + " puntos por alquiler frecuente";
        return result;
	}
	
    private static int computePuntosAlquilerFrecuente(Cliente cliente) {
		int puntosAlquilerFrecuente = 0;
    	for(Alquiler alquiler: cliente.getAlquileres()) {
    		puntosAlquilerFrecuente ++;
    		if ((alquiler.getDisco().getPelicula().getCodigoPrecio() == Pelicula.ESTRENO) && 
					alquiler.getDiasAlquilado() > 1) puntosAlquilerFrecuente ++;
    	}
	return puntosAlquilerFrecuente;
		
}

	private static double computeMontoTotalAlquileres(Cliente cliente) {
			double montoTotal = 0;
	    for(Alquiler alquiler: cliente.getAlquileres()) {
	    		montoTotal += FactoryCalculadorMontoAlquiler.getCalculadorMontoAlquiler(alquiler).calcularMontoAlquiler(alquiler);	
	    }
			return montoTotal;
	}
}
