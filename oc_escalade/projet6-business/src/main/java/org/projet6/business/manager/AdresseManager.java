package org.projet6.business.manager;

import java.util.List;

import org.projet6.model.bean.Adresse;

public interface AdresseManager {
	
	List<Adresse> getListAdresse();
	
	Adresse getAdresse(int id);
	
	void ajoutAdresse(Adresse adresse);
	
	void updateAdresse(Adresse adresse);
	
	void deleteAdresse(int id);
	
	
	

}