package com.renta.peliculas;

import java.util.ArrayList;
import java.util.Iterator;

public class Cliente {
	
	private String nombre;
	private ArrayList<Alquiler> alquileres= new ArrayList<>();
	
	public Cliente(String pNombre) {
        nombre = pNombre;
    }
	
    public String statement() {
        Iterator<Alquiler> iterator= alquileres.iterator();
        String result = "Alquileres de " + nombre + ":\n";
        while (iterator.hasNext()) {
            Alquiler alquiler = iterator.next();
            result += "\t" + alquiler.getDisco().getPelicula().getNombre()+ "\t" + String.valueOf(FactoryCalculadorMontoAlquiler.getCalculadorMontoAlquiler(alquiler).calcularMontoAlquiler(alquiler)) + "\n";

        }
        result +=  "Monto total:  " + String.valueOf(computeMontoTotalAlquileres()) + "\n";
        result += "Gano " + String.valueOf(computePuntosAlquilerFrecuente()) + " puntos por alquiler frecuente";
        return result;

    }
    
    public int computePuntosAlquilerFrecuente() {
    		int puntosAlquilerFrecuente = 0;
	    	Iterator<Alquiler> iterator = alquileres.iterator();
		while (iterator.hasNext()) {
			Alquiler alquiler = iterator.next();
			puntosAlquilerFrecuente ++;
			if ((alquiler.getDisco().getPelicula().getCodigoPrecio() == Pelicula.ESTRENO) && 
					alquiler.getDiasAlquilado() > 1) puntosAlquilerFrecuente ++;
	        
	    }
		return puntosAlquilerFrecuente;
			
    }
    
    public double computeMontoTotalAlquileres() {
    		double montoTotal = 0;
    		Iterator<Alquiler> iterator = alquileres.iterator();
    		while (iterator.hasNext()) {
	        Alquiler alquiler = iterator.next();
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
    		return (Cliente) Registrar.get("Clientes", name);
    }
    
    public void persist() {
    		Registrar.add("Clientes", this);
    }
    
}
