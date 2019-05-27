package org.projet6.model.bean;

public class Longueur {
	
	private int id;
	private String nom;
	private int nombreDePoints;
	private String cotation;
	private String hauteur;
	private Voie voie;
	private int voieId;
	
	
	public Longueur(int id) {
		this.id = id;
	}
	
	public Longueur() {
		
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
	
	public int getNombreDePoints() {
		return nombreDePoints;
	}
	
	public void setNombreDePoints(int nombreDePoints) {
		this.nombreDePoints = nombreDePoints;
	}
	
	public String getCotation() {
		return cotation;
	}
	
	public void setCotation(String cotation) {
		this.cotation = cotation;
	}
	
	public String getHauteur() {
		return hauteur;
	}
	
	public void setHauteur(String hauteur) {
		this.hauteur = hauteur;
	}


	public Voie getVoie() {
		return voie;
	}


	public void setVoie(Voie voie) {
		this.voie = voie;
	}
	
	
	public int getVoieId() {
		return voieId;
	}

	public void setVoieId(int voieId) {
		this.voieId = voieId;
	}

	@Override
	public String toString() {
		return "Longueur [id=" + id + ", nom=" + nom + ", nombreDePoints=" + nombreDePoints + ", cotation=" + cotation
				+ ", hauteur=" + hauteur + ", voie=" + voie + "]";
	}


	
	
	
	
	
	
}
