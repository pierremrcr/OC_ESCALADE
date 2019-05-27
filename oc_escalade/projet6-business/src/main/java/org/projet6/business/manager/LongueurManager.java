package org.projet6.business.manager;

import java.util.List;

import org.projet6.model.bean.Longueur;

public interface LongueurManager {
	
	List<Longueur> getListeLongueur();
	
	Longueur getLongueurByID(int id);
	
	void ajoutLongueur(Longueur longueur, int voieId);
	
	void deleteLongueur(int id);
	
	void updateLongueur(Longueur longueur);
	
}
