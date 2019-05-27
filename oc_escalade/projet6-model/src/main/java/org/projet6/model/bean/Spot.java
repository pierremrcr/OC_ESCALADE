package org.projet6.model.bean;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Spot {
	
	private int id;
	private String nom;
	private String description;
	private List<Secteur> listeSecteurs;
	private List<Commentaire> listeCommentaires;
	private Adresse adresse;
	private int adresseId;
	private String region;
	
	
	public Spot(int id) {
		this.id = id;
	}
	
	public Spot() {
		
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
	public List<Secteur> getListeSecteurs() {
		return listeSecteurs;
	}
	public void setListeSecteurs(List<Secteur> listeSecteurs) {
		this.listeSecteurs = listeSecteurs;
	}
	public Adresse getAdresse() {
		return adresse;
	}
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}
	
	public List<Commentaire> getListeCommentaires() {
		return listeCommentaires;
	}
	
	public void setListeCommentaires(List<Commentaire> listeCommentaires) {
		this.listeCommentaires = listeCommentaires;
	}

	
	public int getAdresseId() {
		return adresseId;
	}

	public void setAdresseId(int adresseId) {
		this.adresseId = adresseId;
	}
	
	

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Spot [id=" + id + ", nom=" + nom + ", description=" + description + ", listeSecteurs=" + listeSecteurs
				+ ", listeCommentaires=" + listeCommentaires + ", adresse=" + adresse + "]";
	}

	
	
		

}