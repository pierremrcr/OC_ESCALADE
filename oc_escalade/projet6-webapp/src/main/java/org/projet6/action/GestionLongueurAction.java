package org.projet6.action;

import java.util.List;

import org.projet6.model.bean.Longueur;
import org.projet6.model.bean.Voie;

import com.opensymphony.xwork2.ActionSupport;

public class GestionLongueurAction extends ActionSupport {

	private Integer id;

	private Longueur longueur = new Longueur();

	private List<Longueur> listeLongueur;
	
	private List<Voie> listeVoie;
	
	private Voie voie;
	
	private int voieId;
	
	

	public Integer getId() {
		return id;
	}
	

	public void setId(Integer id) {
		this.id = id;
	}

	public Longueur getLongueur() {
		return longueur;
	}

	public void setLongueur(Longueur longueur) {
		this.longueur = longueur;
	}

	public List<Longueur> getListeLongueur() {
		return listeLongueur;
	}

	public void setListeLongueur(List<Longueur> listeLongueur) {
		this.listeLongueur = listeLongueur;
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
	
	

	public int getVoieId() {
		return voieId;
	}


	public void setVoieId(int voieId) {
		this.voieId = voieId;
	}


	public String doList() {

		listeLongueur = WebappHelper.getManagerFactory().getLongueurManager().getListeLongueur();

		return ActionSupport.SUCCESS;
	}

	public String doDetail() {

		if (id == null) {

			this.addActionError("Vous devez indiquer un id");


		} else {

			longueur = WebappHelper.getManagerFactory().getLongueurManager().getLongueurByID(id);
		}

		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;

	}
	
	    public String doCreate() {
		
		String vResult = ActionSupport.INPUT;

//		//Le secteur n'est pas nul donc le formulaire vient d'être validé et je dois le traiter
//		if (this.longueur != null) {
//
//			if (longueur.getNom() == null || longueur.getNombreDePoints() == 0 || longueur.getCotation() == null || longueur.getHauteur() == null) {
//				
//				this.addActionError("Vous devez indiquer un nom, un nombre de points, une cotation et une hauteur");
//			} else {
//				System.out.println("OK");
//			}
//
//			if (!this.hasErrors()) {
				
		       try {
					
					WebappHelper.getManagerFactory().getLongueurManager().ajoutLongueur(longueur,voieId);
					vResult = ActionSupport.SUCCESS;
					this.addActionMessage("Création d'une nouvelle longueur");
					
				} catch (NullPointerException pEX) {
					
					listeVoie = WebappHelper.getManagerFactory().getVoieManager().getListeVoie();
			
					
				} catch (Exception e) {
					
					listeVoie = WebappHelper.getManagerFactory().getVoieManager().getListeVoie();
			
		       }
//				}
//		}
//		else {
			// le secteur est nul donc je dois afficher le formulaire
			
		//}
		
		return vResult;
		
	}

}
