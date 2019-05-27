package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.projet6.model.bean.Adresse;
import org.springframework.jdbc.core.RowMapper;

public class MapperAdresse implements RowMapper<Adresse> {

	public Adresse mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Adresse adresse = new Adresse(rs.getInt("id"));
		adresse.setRue(rs.getString("rue"));
		adresse.setNumero(rs.getInt("numero"));
		adresse.setCodePostal(rs.getString("codepostal"));
		adresse.setVille(rs.getString("ville"));
		adresse.setDepartement(rs.getString("departement"));
		
		return adresse;
	}
	
	
}
