package mapper;


import java.sql.ResultSet;
import java.sql.SQLException;

import org.projet6.consumer.Impl.AdresseDaoImpl;
import org.projet6.consumer.Impl.UtilisateurDaoImpl;
import org.projet6.model.bean.Spot;
import org.springframework.jdbc.core.RowMapper;


public class MapperSpot implements RowMapper<Spot>   {
	
	

	public Spot mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Spot spot= new Spot(rs.getInt("id"));
		spot.setNom(rs.getString("nom"));
		spot.setDescription(rs.getString("description"));	
		AdresseDaoImpl adresseDao = new AdresseDaoImpl();
		spot.setAdresse(adresseDao.getAdresseByID(rs.getInt("adresse_id")));
		spot.setRegion(rs.getString("region"));
		
		return spot;
	
	}


	
}
