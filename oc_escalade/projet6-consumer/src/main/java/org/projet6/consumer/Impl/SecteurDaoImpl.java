package org.projet6.consumer.Impl;

import java.util.List;

import org.projet6.consumer.contract.SecteurDao;
import org.projet6.model.bean.Secteur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.projet6.consumer.Impl.AbstractDaoImpl;

import mapper.MapperSecteur;

public class SecteurDaoImpl extends AbstractDaoImpl implements SecteurDao {

	
	public List<Secteur> listsecteur() {
		
		String vSQL = "SELECT * FROM public.secteur";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		MapperSecteur mapSecteur = new MapperSecteur();
		
		List<Secteur> listSecteur = vJdbcTemplate.query(vSQL, mapSecteur);
		
		return listSecteur;
	}

	

	public Secteur getbyID(int id) {
		
		String vSQL = "SELECT * FROM public.secteur where id = ?";

        JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

        MapperSecteur mapSecteur = new MapperSecteur();

        Secteur secteur = vJdbcTemplate.queryForObject(vSQL, mapSecteur, id);
		
        return secteur;
	}



	public List<Secteur> listSecteurBySpotID(int id) {
		
		String vSQL = "SELECT * FROM public.secteur where spot_id = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		MapperSecteur mapSecteur = new MapperSecteur();
		
		List<Secteur> listeSecteurs = vJdbcTemplate.query(vSQL, mapSecteur, id);
		
		return listeSecteurs;
		
		
	}



	public Secteur create(Secteur secteur, int spot_id) {
		
		String vSQL = "INSERT INTO public.secteur(nom, description, spot_id) VALUES(:nom,:description,:spot_id)";

		SqlParameterSource ajoutSecteur = new MapSqlParameterSource()
				.addValue("nom", secteur.getNom())
				.addValue("description", secteur.getDescription())
				.addValue("spot_id", spot_id);
		

		KeyHolder keyHolder = new GeneratedKeyHolder();

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, ajoutSecteur, keyHolder, new String[]{"id"});
		int newId = keyHolder.getKey().intValue();
		secteur.setId(newId);
		
		System.out.println("Secteur crée" + secteur);

		return secteur;
	}

	


	public void supprimeSecteur(int id) {
		
		String vSQL = "DELETE FROM public.secteur where id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, id);
		
	}



	public void updateSecteur(Secteur secteur) {
		
	String vSQL = "UPDATE public.secteur SET nom=?, description=?, spot_id=? WHERE id = ?";
	
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		vJdbcTemplate.update(vSQL, secteur.getNom(), secteur.getDescription(), secteur.getSpot().getId());
		
	}


}
