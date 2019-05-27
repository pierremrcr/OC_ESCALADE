package org.projet6.model.bean;

import java.sql.Date;
import java.time.LocalDate;

public class ResaTopo {
	
	private Integer id;
	private Date dateDebut;
	private Date dateFin;
	private Integer utilisateurId;
	private Topo topo;
	private Utilisateur emprunteur;
	private Utilisateur proprietaireTopo;
	private Integer topoId;
	
	
	public ResaTopo() {
		
	}
	
	public ResaTopo(Integer id) {
		this.id = id;
	}
	
	public ResaTopo (Date dateDebut,Date dateFin) {
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
	}
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}

	

	public Topo getTopo() {
		return topo;
	}

	public void setTopo(Topo topo) {
		this.topo = topo;
	}
	
	
	
	public Utilisateur getEmprunteur() {
		return emprunteur;
	}

	public void setEmprunteur(Utilisateur emprunteur) {
		this.emprunteur = emprunteur;
	}

	
	
	public Integer getUtilisateurId() {
		return utilisateurId;
	}

	public void setUtilisateurId(Integer utilisateurId) {
		this.utilisateurId = utilisateurId;
	}
	
	
	
	public Utilisateur getProprietaireTopo() {
		return proprietaireTopo;
	}

	public void setProprietaireTopo(Utilisateur proprietaireTopo) {
		this.proprietaireTopo = proprietaireTopo;
	}

	public Integer getTopoId() {
		return topoId;
	}

	public void setTopoId(Integer topoId) {
		this.topoId = topoId;
	}

	
	
	}
	


