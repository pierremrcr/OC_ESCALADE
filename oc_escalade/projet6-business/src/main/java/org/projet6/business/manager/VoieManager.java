package org.projet6.business.manager;

import java.util.List;

import org.projet6.model.bean.Voie;

public interface VoieManager {
	
	List<Voie> getListeVoie();
	
	Voie getVoiebyId(int id);
	
	void ajoutVoie(Voie voie, int secteurId);
	
	void updateVoie(Voie voie);
	
	void deleteVoie(int id);
	
	

}
