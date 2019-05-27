package org.projet6.business.manager;

import java.util.List;

import org.projet6.model.bean.Secteur;


public interface SecteurManager {
	
	List<Secteur> getListSecteur();
	
	Secteur getSecteur(int id);
	
	void ajoutSecteur(Secteur secteur, int spotId);
	
	List<Secteur> listeSecteurBySpot(int id);
	
	void deleteSecteur(int id);
	
	void updateSecteur(Secteur secteur);
	
	
}

