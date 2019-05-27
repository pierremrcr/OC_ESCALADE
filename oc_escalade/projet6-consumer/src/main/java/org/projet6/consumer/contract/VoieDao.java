package org.projet6.consumer.contract;

import java.util.List;

import org.projet6.model.bean.Voie;

public interface VoieDao {
	
	public List<Voie> listeVoie();
	
	public List<Voie> listeVoiesBySecteurID(int id);
	
	public Voie create(Voie voie, int secteur_id);

	public void supprimeVoie(int id);
	
	public Voie getByID(int id);
	
	public void updateVoie(Voie voie);
	
}
