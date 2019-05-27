package org.projet6.consumer.Impl;

import java.util.List;

import mapper.MapperLongueur;
import org.projet6.consumer.contract.LongueurDao;
import org.projet6.model.bean.Longueur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.projet6.consumer.Impl.AbstractDaoImpl;

public class LongueurDaoImpl extends AbstractDaoImpl implements LongueurDao {

	public List<Longueur> listeLongueur() {
		
		 String vSQL = "SELECT * FROM public.longueur";
			
			JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
			
			MapperLongueur mapLongueur = new MapperLongueur();
			
			List<Longueur> listeLongueurs = vJdbcTemplate.query(vSQL, mapLongueur);
			
			return listeLongueurs;
	}

	public List<Longueur> listeLongueursByVoieID(int id) {
		
		  String vSQL = "SELECT * FROM public.longueur where voie_id = ?";
			
			JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
			
			MapperLongueur mapLongueur = new MapperLongueur();
			
			List<Longueur> listeLongueurs = vJdbcTemplate.query(vSQL, mapLongueur, id);
			
		    return listeLongueurs;
	}
	
	
	public Longueur getByID(int id) {
		
		String vSQL = "SELECT * FROM public.longueur where id = ?";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        MapperLongueur mapLongueur = new MapperLongueur();

        Longueur longueur = vJdbcTemplate.queryForObject(vSQL, mapLongueur, id);
		
        return longueur;
	}

	public Longueur create(Longueur longueur, int voie_id) {
		
		String vSQL = "INSERT INTO public.longueur(nom, nombredepoints, cotation, hauteur, voie_id) VALUES(:nom,:nombredepoints, :cotation, :hauteur, :voie_id)";

		SqlParameterSource ajoutLongueur = new MapSqlParameterSource()
				.addValue("nom", longueur.getNom())
				.addValue("nombredepoints", longueur.getNombreDePoints())
				.addValue("cotation", longueur.getCotation())
				.addValue("hauteur", longueur.getHauteur())
				.addValue("voie_id", voie_id);

		KeyHolder keyHolder = new GeneratedKeyHolder();

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, ajoutLongueur, keyHolder, new String[]{"id"});
		int newId = keyHolder.getKey().intValue();
		longueur.setId(newId);
		
		System.out.println("longueur crée" + longueur);

		return longueur;
		
	}

	public void supprimeLongueur(int id) {
	
		String vSQL = "DELETE FROM public.longueur where id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, id);
		
	}

	public void updateLongueur(Longueur longueur) {
		
	String vSQL = "UPDATE public.longueur SET nom=?, nombredepoints=?, cotation=?, hauteur=?, voie_id=? WHERE id = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		vJdbcTemplate.update(vSQL, longueur.getNom(), longueur.getNombreDePoints(), longueur.getCotation(), longueur.getHauteur(), longueur.getVoie().getId());
		
	}
	

	

}