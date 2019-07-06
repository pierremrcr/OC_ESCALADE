package org.projet6.consumer.Impl;

import java.util.List;

import org.projet6.consumer.contract.SpotDao;
import org.projet6.model.bean.Spot;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import mapper.MapperSpot;

public class SpotDaoImpl extends AbstractDaoImpl implements SpotDao {

	public List<Spot> listspot() {

		String vSQL = "SELECT * FROM public.spot";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		MapperSpot mapSpot = new MapperSpot();

		List<Spot> listspot = vJdbcTemplate.query(vSQL, mapSpot);

		return listspot;
	}

	public Spot getbyID(int id) {

		String vSQL = "SELECT * FROM public.spot where id= ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		MapperSpot mapSpot = new MapperSpot();

		Spot spot = vJdbcTemplate.queryForObject(vSQL, mapSpot, id);

		return spot;
	}

	public void supprimeSpot(int Id) {

		String vSQL = "DELETE FROM public.spot where id= ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		vJdbcTemplate.update(vSQL, Id);

	}

	public Spot create(final Spot spot) {

		String vSQL = "INSERT INTO public.spot(nom, description, adresse_id, region) VALUES(:nom,:description,:adresse_id,:region)";

		SqlParameterSource ajoutSpot = new MapSqlParameterSource()
				.addValue("nom", spot.getNom())
				.addValue("description", spot.getDescription())
				.addValue("adresse_id", spot.getAdresse().getId())
				.addValue("region", spot.getRegion());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, ajoutSpot, keyHolder, new String[] { "id" });
		int newId = keyHolder.getKey().intValue();
		spot.setId(newId);

		System.out.println("Spot crée" + spot);

		return spot;

	}

	public Spot getSpotByAdresseID(int id) {

		String vSQL = "SELECT * FROM public.spot where adresse_id = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		MapperSpot mapSpot = new MapperSpot();

		Spot spot = vJdbcTemplate.queryForObject(vSQL, mapSpot, id);

		return spot;

	}

	public void updateSpot(Spot spot) {

		String vSQL = "UPDATE public.spot SET nom=?, description=?, adresse_id=?, utilisateur_id=? WHERE id = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		vJdbcTemplate.update(vSQL, spot.getNom(), spot.getDescription(), spot.getAdresse().getId(), spot.getId());

	}

//	public List<Spot> rechercheMultiCriteres(int nombreDePoints, String typeCotation) {
//		
//		String vSQL = "SELECT distinct spot.* FROM spot\n"
//				      + "INNER JOIN secteur ON spot.id = secteur.spot_id\n"
//					  + "INNER JOIN voie ON secteur.id = voie.secteur_id\n"
//					  + "INNER JOIN longueur on voie.id = longueur.voie_id\n"
//					  + "WHERE longueur.nombredepoints = " + "'" + nombreDePoints + "'"
//					  + "AND longueur.cotation = " + "'" + typeCotation + "'";
//		
//		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
//		
//		MapperSpot mapSpot= new MapperSpot();
//		
//		List<Spot> listeSpot = vJdbcTemplate.query(vSQL, mapSpot);
//		
//		
//		
//		return listeSpot;
//	}

	public List<Spot> rechercheMultiCriteres(String region, int nombreDePoints, String typeCotation) {

		String vSQL = "SELECT distinct spot.* FROM spot\n"
				+ " INNER JOIN secteur ON spot.id = secteur.spot_id\n"
				+ " INNER JOIN voie ON secteur.id = voie.secteur_id\n"
				+ " INNER JOIN longueur on voie.id = longueur.voie_id\n" 
				+ " WHERE longueur.nombredepoints =  " + "'" + nombreDePoints + "'" 
				+ " AND longueur.cotation =  " + "'" + typeCotation + "'"
				+ " AND spot.region =  " + "'" + region + "'";
				
		System.out.println(vSQL);
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		MapperSpot mapSpot = new MapperSpot();

		List<Spot> listeSpot = vJdbcTemplate.query(vSQL, mapSpot);
		
		System.out.println("Requête exécutée");
		
		return listeSpot;

	}
	

	public List<Spot> getSpotByRegion(String region) {
		
		String vSQL = "SELECT * FROM public.spot where region = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		MapperSpot mapSpot = new MapperSpot();

		List<Spot> listeSpot = vJdbcTemplate.query(vSQL, mapSpot, region);

		return listeSpot;
	}

}
