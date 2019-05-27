package mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.projet6.consumer.Impl.VoieDaoImpl;
import org.projet6.model.bean.Longueur;
import org.springframework.jdbc.core.RowMapper;

public class MapperLongueur implements RowMapper<Longueur>{

	public Longueur mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Longueur longueur = new Longueur(rs.getInt("id"));
		longueur.setNom(rs.getString("nom"));
		longueur.setNombreDePoints(rs.getInt("nombredepoints"));
		longueur.setCotation(rs.getString("cotation"));
		longueur.setHauteur(rs.getString("hauteur"));
		longueur.setVoieId(rs.getInt("voie_id"));
		
		return longueur;
	}

}
