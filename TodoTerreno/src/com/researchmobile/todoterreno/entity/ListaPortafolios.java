package com.researchmobile.todoterreno.entity;

import java.io.Serializable;

public class ListaPortafolios implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Portafolio[] portafolios;
	public Portafolio[] getPortafolios() {
		return portafolios;
	}
	public void setPortafolios(Portafolio[] portafolios) {
		this.portafolios = portafolios;
	}
}
