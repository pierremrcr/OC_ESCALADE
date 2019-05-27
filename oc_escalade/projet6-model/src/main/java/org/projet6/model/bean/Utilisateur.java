package org.projet6.model.bean;

public class Utilisateur {
	
	private String nom;
	private String prenom;
	private String adresseMail;
	private String motDePasse;
	private int id;
	private String presentation;
	private String niveau;

	
	//Constructeur
	
	public Utilisateur() {
	
	}
	
	public Utilisateur(int id) {
		this.id = id;
	}
	
	//Getters et setters
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getAdresseMail() {
		return adresseMail;
	}
	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public String getPresentation() {
		return presentation;
	}

	public void setPresentation(String presentation) {
		this.presentation = presentation;
	}

	public String getNiveau() {
		return niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}

	@Override
	public String toString() {
		return "Utilisateur [nom=" + nom + ", prenom=" + prenom + ", adresseMail=" + adresseMail + ", motDePasse="
				+ motDePasse + ", id=" + id + ", presentation=" + presentation + ", niveau=" + niveau + "]";
	}

	


}