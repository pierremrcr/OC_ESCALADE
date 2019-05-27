package org.projet6.action;

import java.util.List;


import org.projet6.model.bean.Secteur;
import org.projet6.model.bean.Voie;

import com.opensymphony.xwork2.ActionSupport;

public class GestionVoieAction extends ActionSupport {
	
	private Integer id;
	
	private Voie voie = new Voie();
	
	private List<Voie> listeVoie;
	
	private List<Secteur> listeSecteur;
	
    private Secteur secteur;
	
	private int secteurId;
	
	private int voieId;

	
	public Integer getId() {
		return id;
	}
	
	

	public void setId(Integer id) {
		this.id = id;
	}

	public Voie getVoie() {
		return voie;
	}

	public void setVoie(Voie voie) {
		this.voie = voie;
	}

	public List<Voie> getListeVoie() {
		return listeVoie;
	}

	public void setListeVoie(List<Voie> listeVoie) {
		this.listeVoie = listeVoie;
	}
	
	
	public Secteur getSecteur() {
		return secteur;
	}

	public void setSecteur(Secteur secteur) {
		this.secteur = secteur;
	}

	public List<Secteur> getListeSecteur() {
		return listeSecteur;
	}

	public void setListeSecteur(List<Secteur> listeSecteur) {
		this.listeSecteur = listeSecteur;
	}
	

	public int getSecteurId() {
		return secteurId;
	}



	public void setSecteurId(int secteurId) {
		this.secteurId = secteurId;
	}

	
	public int getVoieId() {
		return voieId;
	}



	public void setVoieId(int voieId) {
		this.voieId = voieId;
	}



	public String doList() {
		
		listeVoie = WebappHelper.getManagerFactory().getVoieManager().getListeVoie();
		
		return ActionSupport.SUCCESS;
	}
	
	public String doDetail() {
		
    if (id == null) {
			
			this.addActionError("Vous devez indiquer un id");
			
		} else {
		
		voie = WebappHelper.getManagerFactory().getVoieManager().getVoiebyId(id);
		
		}

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
		
		
	}
	
	public String doCreate() {
		
		String vResult = ActionSupport.INPUT;

		
				try {
					
					WebappHelper.getManagerFactory().getVoieManager().ajoutVoie(voie,secteurId);
					voieId = voie.getId();
					vResult = ActionSupport.SUCCESS;
					this.addActionMessage("Création d'une nouvelle voie");
					
				} catch (NullPointerException pEX) {
					
				listeSecteur = WebappHelper.getManagerFactory().getSecteurManager().getListSecteur();
				
				} catch (Exception e) {
					
				listeSecteur = WebappHelper.getManagerFactory().getSecteurManager().getListSecteur();
					
				}
					
		return vResult;
		
		
	}
	
	
	
}
	
	


