package com.renta.peliculas;

import java.util.ArrayList;
import java.util.Iterator;

import com.renta.peliculas.Registrar.Registrable;

public class Cliente {
	
	private String nombre;
	private ArrayList<Alquiler> alquileres= new ArrayList<>();
	
	public Cliente(String pNombre) {
        nombre = pNombre;
    }
	
    public String statement() {
        String result = "Alquileres de " + nombre + ":\n";
        for(Alquiler alquiler: alquileres) {
        		result += "\t" + alquiler.getDisco().getPelicula().getNombre()+ "\t" + String.valueOf(FactoryCalculadorMontoAlquiler.getCalculadorMontoAlquiler(alquiler).calcularMontoAlquiler(alquiler)) + "\n";
        }
        result +=  "Monto total:  " + String.valueOf(computeMontoTotalAlquileres()) + "\n";
        result += "Gano " + String.valueOf(computePuntosAlquilerFrecuente()) + " puntos por alquiler frecuente";
        return result;

    }
    
    public int computePuntosAlquilerFrecuente() {
    		int puntosAlquilerFrecuente = 0;
	    	for(Alquiler alquiler: alquileres) {
	    		puntosAlquilerFrecuente ++;
	    		if ((alquiler.getDisco().getPelicula().getCodigoPrecio() == Pelicula.ESTRENO) && 
						alquiler.getDiasAlquilado() > 1) puntosAlquilerFrecuente ++;
	    	}
		return puntosAlquilerFrecuente;
			
    }
    
    public double computeMontoTotalAlquileres() {
    		double montoTotal = 0;
        for(Alquiler alquiler: alquileres) {
        		montoTotal += FactoryCalculadorMontoAlquiler.getCalculadorMontoAlquiler(alquiler).calcularMontoAlquiler(alquiler);	
        }
    		return montoTotal;
    }
    
	public String getNombre() {
		return nombre;
	}
    
    public void addRental(Alquiler arg) {
    		alquileres.add(arg);
    }
    
    public static Cliente get(String name) {
    		return (Cliente) Registrar.get(Registrable.CLIENTES, name);
    }
    
    public void persist() {
    		Registrar.add(Registrable.CLIENTES, this);
    }
    
}
