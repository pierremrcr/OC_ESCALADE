package org.projet6.consumer.contract;

import java.util.List;

import org.projet6.model.bean.Secteur;

public interface SecteurDao {
	
	public List<Secteur> listsecteur();
	
	public List<Secteur> listSecteurBySpotID(int id);
	
	public Secteur create(Secteur secteur, int spot_id);
	
	public void supprimeSecteur(int id);
	
	public Secteur getbyID(int id);
	
	public void updateSecteur(Secteur secteur);

}
