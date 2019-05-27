package mapper;

import java.sql.ResultSet;

import java.sql.SQLException;

import org.projet6.consumer.Impl.TopoDaoImpl;
import org.projet6.consumer.Impl.UtilisateurDaoImpl;
import org.projet6.model.bean.Commentaire;
import org.springframework.jdbc.core.RowMapper;

public class MapperCommentaireTopo implements RowMapper<Commentaire> {

	public Commentaire mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Commentaire commentaireTopo = new Commentaire(rs.getInt("id"));
		commentaireTopo.setContenu(rs.getString("contenu"));
		commentaireTopo.setDate(rs.getDate("date"));
		
		UtilisateurDaoImpl userDao = new UtilisateurDaoImpl();
		TopoDaoImpl topoDao = new TopoDaoImpl();
		
		commentaireTopo.setUtilisateur(userDao.getbyID(rs.getInt("utilisateur_id")));
		commentaireTopo.setTopo(topoDao.getTopoByID(rs.getInt("topo_id")));
		
		return commentaireTopo;
	}

}
