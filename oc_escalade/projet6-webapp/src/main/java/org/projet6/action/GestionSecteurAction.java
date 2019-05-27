package org.projet6.action;

import java.util.List;

import org.projet6.model.bean.Secteur;
import org.projet6.model.bean.Spot;

import com.opensymphony.xwork2.ActionSupport;

public class GestionSecteurAction extends ActionSupport {

	private Integer id;

	private Secteur secteur = new Secteur();

	private List<Secteur> listeSecteur;

	private List<Spot> listeSpot;

	private Spot spot;

	private int spotId;

	private int secteurId;

	public int getSpotId() {
		return spotId;
	}

	public void setSpotId(int spotId) {
		this.spotId = spotId;
	}

	public List<Spot> getListeSpot() {
		return listeSpot;
	}

	public void setListeSpot(List<Spot> listeSpot) {
		this.listeSpot = listeSpot;
	}

	public Spot getSpot() {
		return spot;
	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	public Integer getId() {

		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String doList() {

		listeSecteur = WebappHelper.getManagerFactory().getSecteurManager().getListSecteur();

		return ActionSupport.SUCCESS;
	}

	public String doDetail() {

		if (id == null) {

			this.addActionError("Vous devez indiquer un id");

		} else {

			secteur = WebappHelper.getManagerFactory().getSecteurManager().getSecteur(id);

		}
		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;

	}

	public String doCreate() {

		String vResult = ActionSupport.INPUT;

		try {

			WebappHelper.getManagerFactory().getSecteurManager().ajoutSecteur(secteur, spotId);
			secteurId = secteur.getId();
			vResult = ActionSupport.SUCCESS;
			this.addActionMessage("Création d'un nouveau secteur");

		} catch (NullPointerException pEX) {

			listeSpot = WebappHelper.getManagerFactory().getSpotManager().getListSpot();

		} catch (Exception e) {

			listeSpot = WebappHelper.getManagerFactory().getSpotManager().getListSpot();

		}

		return vResult;

	}
	
	public String doDelete() {

		String vResult = ActionSupport.INPUT;

		if (id == null) {
			vResult = ActionSupport.INPUT;
		}

		else {

			WebappHelper.getManagerFactory().getSecteurManager().deleteSecteur(id);

			vResult = ActionSupport.SUCCESS;
		}

		return vResult;
	}

}
