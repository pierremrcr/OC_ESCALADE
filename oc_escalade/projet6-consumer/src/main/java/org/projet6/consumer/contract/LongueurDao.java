package org.projet6.consumer.contract;

import java.util.List;

import org.projet6.model.bean.Longueur;

public interface LongueurDao {
	
	List<Longueur> listeLongueur();
	
	List<Longueur> listeLongueursByVoieID(int id);
	
	Longueur create(Longueur longueur, int voie_id);
	
	void supprimeLongueur(int id);
	
	Longueur getByID(int id);
	
	void updateLongueur(Longueur longueur);

}
