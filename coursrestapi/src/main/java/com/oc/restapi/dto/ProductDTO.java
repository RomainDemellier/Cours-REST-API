package com.oc.restapi.dto;

import java.io.Serializable;

public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String nom;
	private int prix;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public int getPrix() {
		return prix;
	}
	public void setPrix(int prix) {
		this.prix = prix;
	}
	
	
}
