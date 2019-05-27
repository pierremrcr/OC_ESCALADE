package org.projet6.action;

import java.util.List;

import org.projet6.model.bean.Adresse;

import com.opensymphony.xwork2.ActionSupport;

public class GestionAdresseAction extends ActionSupport {
	
	private Integer id;
	
	private Adresse adresse;
	
	private List<Adresse> listeAdresse;

	public Integer getId() {
		return id;
		
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public List<Adresse> getListeAdresse() {
		return listeAdresse;
	}

	public void setListeAdresse(List<Adresse> listeAdresse) {
		this.listeAdresse = listeAdresse;
	}
	
	
	public String doList() {
		
		listeAdresse = WebappHelper.getManagerFactory().getAdresseManager().getListAdresse();
		
		return ActionSupport.SUCCESS;
	}
	
	
	
	public String doDetail() {
		if (id == null) {
			this.addActionError("Vous devez indiquer un id");
		} else {
			//try {
			adresse = WebappHelper.getManagerFactory().getAdresseManager().getAdresse(id);
			//} catch (NotFoundException pE) {
				//this.addActionError("Utilisateur non trouvé. id = " + id);
			//}
			
		}
		
		
		return (this.hasErrors()) ? ActionSupport.ERROR :ActionSupport.SUCCESS;
	
	}
	
	public String doCreate() {

		String vResult = ActionSupport.INPUT;

		if (this.adresse != null) {

			if (adresse.getDepartement() == null)  {
				this.addActionError("Vous devez indiquer un département");
			}
			
			if (adresse.getCodePostal() == null) {
				this.addActionError("Vous devez indiquer un code postal");
			}
			
			if (adresse.getVille() == null) {
				this.addActionError("Vous devez indiquer une ville");
			}

			if (!this.hasErrors()) {
				try {
					WebappHelper.getManagerFactory().getAdresseManager().ajoutAdresse(adresse);
					vResult = ActionSupport.SUCCESS;
					this.addActionMessage("Création d'une nouvelle adresse");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}

		}
		
		return vResult;

	}
	

}
