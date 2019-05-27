package org.projet6.model.bean;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Topo {
	
	private String nom;
	private String description;
	private List<Spot> listeSpots;
	private List<Commentaire> listeCommentaires;
	private int id;
	private Utilisateur proprietaire;
	private Utilisateur emprunteur;
	private ResaTopo resaTopo;
	
	
	
	public Topo() {
		
	}
	
	public Topo(int id) {
		this.id = id;
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
	
	public List<Spot> getListeSpots() {
		return listeSpots;
	}
	
	public void setListeSpots(List<Spot> listeSpots) {
		this.listeSpots = listeSpots;
	}
	
	public List<Commentaire> getListeCommentaires() {
		return listeCommentaires;
	}
	
	public void setListeCommentaires(List<Commentaire> listeCommentaires) {
		this.listeCommentaires = listeCommentaires;
	}
	
	
	
	public Utilisateur getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Utilisateur proprietaire) {
		this.proprietaire = proprietaire;
	}

	public Utilisateur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}

	public ResaTopo getResaTopo() {
		return resaTopo;
	}

	public void setResaTopo(ResaTopo resaTopo) {
		this.resaTopo = resaTopo;
	}

	@Override
	public String toString() {
		return "Topo [nom=" + nom + ", description=" + description + ", listeSpots=" + listeSpots
				+ ", listeCommentaires=" + listeCommentaires + ", id=" + id + ", proprietaire=" + proprietaire
				+ ", emprunteur=" + emprunteur + ", resaTopo=" + resaTopo + "]";
	}
	
		
	
}