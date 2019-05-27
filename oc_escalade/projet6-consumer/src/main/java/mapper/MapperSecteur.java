package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.projet6.consumer.Impl.SpotDaoImpl;
import org.projet6.model.bean.Secteur;
import org.springframework.jdbc.core.RowMapper;

public class MapperSecteur implements RowMapper<Secteur> {
	

	public Secteur mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Secteur secteur = new Secteur(rs.getInt("id"));
		secteur.setNom(rs.getString("nom"));
		secteur.setDescription(rs.getString("description"));
		secteur.setSpotId(rs.getInt("spot_id"));
		
		
		//SpotDaoImpl spotDao = new SpotDaoImpl();
		
		//On récupère le spot correspondant au secteur à partir de son id
		//secteur.setSpot(spotDao.getbyID(rs.getInt("spot_id")));
		
		return secteur;
		
	}

}