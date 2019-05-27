package mapper;

import java.sql.ResultSet;



import java.sql.SQLException;

import org.projet6.consumer.Impl.SpotDaoImpl;
import org.projet6.consumer.Impl.UtilisateurDaoImpl;
import org.projet6.model.bean.Commentaire;
import org.springframework.jdbc.core.RowMapper;


public class MapperCommentaire implements RowMapper<Commentaire> {

	public Commentaire mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Commentaire commentaire = new Commentaire(rs.getInt("id"));
		commentaire.setContenu(rs.getString("contenu"));
		commentaire.setDate(rs.getDate("date"));
		
		UtilisateurDaoImpl userDao = new UtilisateurDaoImpl();
		SpotDaoImpl spotDao = new SpotDaoImpl();
		
		commentaire.setUtilisateur(userDao.getbyID(rs.getInt("utilisateur_id")));
		commentaire.setSpot(spotDao.getbyID(rs.getInt("spot_id")));
		

		return commentaire;
	}

}
