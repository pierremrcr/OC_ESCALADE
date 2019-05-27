package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.projet6.consumer.Impl.UtilisateurDaoImpl;
import org.projet6.model.bean.Topo;
import org.springframework.jdbc.core.RowMapper;

public class MapperTopo implements RowMapper<Topo> {

	public Topo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Topo topo = new Topo(rs.getInt("id"));
		topo.setNom(rs.getString("nom"));
		topo.setDescription(rs.getString("description"));
		
		
		UtilisateurDaoImpl userDao = new UtilisateurDaoImpl();
		
		topo.setProprietaire(userDao.getbyID(rs.getInt("proprietaire_id")));
		
		return topo;
	}

}
