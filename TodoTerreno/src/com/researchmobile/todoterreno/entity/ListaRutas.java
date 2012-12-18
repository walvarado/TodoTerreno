package com.researchmobile.todoterreno.entity;

import java.io.Serializable;

public class ListaRutas implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Ruta[] ruta;

	public Ruta[] getRuta() {
		return ruta;
	}

	public void setRuta(Ruta[] ruta) {
		this.ruta = ruta;
	}
}
