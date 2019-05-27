package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.projet6.consumer.Impl.SecteurDaoImpl;
import org.projet6.model.bean.Voie;
import org.springframework.jdbc.core.RowMapper;

public class MapperVoie implements RowMapper<Voie> {

	public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {
		Voie voie = new Voie(rs.getInt("id"));
		voie.setNom(rs.getString("nom"));
		voie.setDescription(rs.getString("description"));
		voie.setSecteurId(rs.getInt("secteur_id"));
		
		
//		SecteurDaoImpl secteurDao = new SecteurDaoImpl();
//		
//		voie.setSecteur(secteurDao.getbyID(rs.getInt("secteur_id")));
		
		return voie;
		
	}

}