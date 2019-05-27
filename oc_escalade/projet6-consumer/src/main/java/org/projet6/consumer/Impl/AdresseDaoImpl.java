package org.projet6.consumer.Impl;

import java.util.List;


import mapper.MapperAdresse;
import org.projet6.consumer.contract.AdresseDao;
import org.projet6.model.bean.Adresse;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.projet6.consumer.Impl.AbstractDaoImpl;

public class AdresseDaoImpl extends AbstractDaoImpl implements AdresseDao {

	public Adresse getAdresseByID(int id) {
		
		  String vSQL = "SELECT * FROM public.adresse where id = ?";

	        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

	        MapperAdresse mapAdresse = new MapperAdresse();

	        Adresse adresse = vJdbcTemplate.queryForObject(vSQL, mapAdresse, id);
			
	        return adresse;
	        
	}

	public List<Adresse> listadresse() {
		
	String vSQL = "SELECT * FROM public.adresse";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		MapperAdresse mapAdresse = new MapperAdresse();
		
		List<Adresse> listeAdresses = vJdbcTemplate.query(vSQL, mapAdresse);
		
		return listeAdresses;
	}
	
	public Adresse create(Adresse adresse) {
		
		String vSQL = "INSERT INTO public.adresse(rue, numero, codepostal, ville, departement) VALUES(:rue,:numero,:codepostal,:ville,:departement)";
		
		 SqlParameterSource ajoutAdresse = new MapSqlParameterSource()
		 .addValue("rue", adresse.getRue())
		 .addValue("numero", adresse.getNumero())
		 .addValue("codepostal", adresse.getCodePostal())
		 .addValue("ville", adresse.getVille())
		 .addValue("departement", adresse.getDepartement());
		 
		 KeyHolder keyHolder = new GeneratedKeyHolder();
		 
		 NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
         vJdbcTemplate.update(vSQL, ajoutAdresse, keyHolder, new String[]{"id"});
         int newId = keyHolder.getKey().intValue();
         adresse.setId(newId);
         
         System.out.println("nouvelle adresse crée" + adresse);
         
         return adresse;	
         
		
	}

	public void supprimeAdresse(int id) {
		
        String vSQL = "DELETE FROM adresse where id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, id);
		
		
	}
	
	

	public void updateAdresse(Adresse adresse) {
		
	String vSQL = "UPDATE adresse SET rue=?, numero=?, codepostal=?, ville=?, departement=? WHERE id = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		vJdbcTemplate.update(vSQL, adresse.getRue(), adresse.getNumero(), adresse.getCodePostal(), adresse.getVille(), adresse.getDepartement());
		
	}
	
	


}
