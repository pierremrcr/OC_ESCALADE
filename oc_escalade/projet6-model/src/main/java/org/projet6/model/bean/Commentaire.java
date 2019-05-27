package org.projet6.model.bean;

import java.util.Date;

public class Commentaire {
	
	private int id;
	private String contenu;
	private Date date;
	private Utilisateur utilisateur;
	private Spot spot;
	private Topo topo;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Commentaire(int id) {
		this.id = id;
	}
	
	public Commentaire() {
		
	}
	
	public String getContenu() {
		return contenu;
	}
	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}



	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}
	
	
	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}

	@Override
	public String toString() {
		return "Commentaire [contenu=" + contenu + ", date=" + date + ", utilisateur=" + utilisateur + ", id=" + id
				+ ", topo=" + ", spot=" + spot + "]";
	}
	
	
	
	

}