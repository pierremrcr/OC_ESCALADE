package org.projet6.consumer.Impl;

import java.util.List;





import mapper.MapperVoie;

import org.projet6.consumer.contract.VoieDao;
import org.projet6.model.bean.Voie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.projet6.consumer.Impl.AbstractDaoImpl;

public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao {

	public List<Voie> listeVoie() {
		
        String vSQL = "SELECT * FROM public.voie";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		MapperVoie mapVoie = new MapperVoie();
		
		List<Voie> listeVoies = vJdbcTemplate.query(vSQL, mapVoie);
		
		return listeVoies;
		
	}

	public List<Voie> listeVoiesBySecteurID(int id) {
		
    String vSQL = "SELECT * FROM public.voie where secteur_id = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		MapperVoie mapVoie = new MapperVoie();
		
		List<Voie> listeVoies = vJdbcTemplate.query(vSQL, mapVoie, id);
		
		return listeVoies;
	}
	
	public Voie getByID(int id) {
		
		String vSQL = "SELECT * FROM public.voie where id = ?";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        MapperVoie mapVoie = new MapperVoie();

        Voie voie = vJdbcTemplate.queryForObject(vSQL, mapVoie, id);
		
        return voie;
	}

	public Voie create(Voie voie, int secteur_id) {
		
		String vSQL = "INSERT INTO public.voie(nom, description, secteur_id) VALUES(:nom,:description,:secteur_id)";

		SqlParameterSource ajoutVoie = new MapSqlParameterSource()
				.addValue("nom", voie.getNom())
				.addValue("description", voie.getDescription())
				.addValue("secteur_id", secteur_id);

		KeyHolder keyHolder = new GeneratedKeyHolder();

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, ajoutVoie, keyHolder, new String[]{"id"});
		int newId = keyHolder.getKey().intValue();
		voie.setId(newId);
		
		System.out.println("Voie crée" + voie);

		return voie;
	}

	public void supprimeVoie(int id) {
		
    String vSQL = "DELETE FROM public.voie where id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, id);
		

	}

	public void updateVoie(Voie voie) {
	
		String vSQL = "UPDATE public.voie SET nom=?, description=?, secteur_id=? WHERE id = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		vJdbcTemplate.update(vSQL, voie.getNom(), voie.getDescription(), voie.getSecteur().getId());
		
	}
	
	



}