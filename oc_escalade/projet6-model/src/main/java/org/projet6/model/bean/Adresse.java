package org.projet6.model.bean;

public class Adresse {
	
	private String rue;
	private int numero;
	private String codePostal;
	private String ville;
	private int id;
	private String departement;
	
	
	public Adresse(int id) {
		this.id = id;
	}
	
	public Adresse() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getDepartement() {
		return departement;
	}

	public void setDepartement(String departement) {
		this.departement = departement;
	}

	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", numero=" + numero + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", id=" + id + ", departement=" + departement + "]";
	}
	
	
	

}