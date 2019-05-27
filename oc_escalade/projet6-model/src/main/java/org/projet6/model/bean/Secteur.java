package org.projet6.model.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Secteur {
	
	private int id;
	private String nom;
	private String description;
	private List<Voie> listeVoies;
	private Spot spot;
	private int spotId;
	
	
	public Secteur(int id) {
		this.id = id;
	}
	
	public Secteur() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public List<Voie> getListeVoies() {
		return listeVoies;
	}
	public void setListeVoies(List<Voie> listeVoies) {
		this.listeVoies = listeVoies;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	@Override
	public String toString() {
		return "Secteur [id=" + id + ", nom=" + nom + ", description=" + description + ", listeVoies=" + listeVoies
				+ ", spot=" + spot + "]";
	}

	public int getSpotId() {
		return spotId;
	}

	public void setSpotId(int spotId) {
		this.spotId = spotId;
	}

	
	


	
	
	
}