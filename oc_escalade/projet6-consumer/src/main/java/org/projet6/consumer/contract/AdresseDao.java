package org.projet6.consumer.contract;

import java.util.List;

import org.projet6.model.bean.Adresse;


public interface AdresseDao {
	
	public Adresse getAdresseByID(int id);

	public List<Adresse> listadresse();

	public Adresse create(Adresse adresse);
	
    public void supprimeAdresse(int id);
	
	public void updateAdresse(Adresse adresse);


}
