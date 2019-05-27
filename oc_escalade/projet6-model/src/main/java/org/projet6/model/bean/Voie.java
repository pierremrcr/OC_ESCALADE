package org.projet6.model.bean;
import java.util.List;

public class Voie {
	
	private int id;
	private String nom;
	private String description;
	private List<Longueur> listeLongueurs;
	private Secteur secteur;
	private int secteurId;
	
	
	public Voie(int id) {
		this.id = id;
	}
	
	public Voie() {
		
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
	
	public List<Longueur> getListeLongueurs() {
		return listeLongueurs;
	}
	
	public void setListeLongueurs(List<Longueur> listeLongueurs) {
		this.listeLongueurs = listeLongueurs;
	}

	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}
	
	

	public int getSecteurId() {
		return secteurId;
	}

	public void setSecteurId(int secteurId) {
		this.secteurId = secteurId;
	}

	@Override
	public String toString() {
		return "Voie [id=" + id + ", nom=" + nom + ", description=" + description + ", listeLongueurs=" + listeLongueurs
				+ ", secteur=" + secteur + "]";
	}
	
	

}