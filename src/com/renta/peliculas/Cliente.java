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

	public ArrayList<Alquiler> getAlquileres() {
		return this.alquileres;
	}
    
}
