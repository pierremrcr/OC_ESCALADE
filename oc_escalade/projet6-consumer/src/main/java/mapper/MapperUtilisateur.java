package mapper;

import java.sql.ResultSet;


import java.sql.SQLException;

import org.projet6.model.bean.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

public class MapperUtilisateur implements RowMapper<Utilisateur> {

	public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		Utilisateur nutil=new Utilisateur();
		
		nutil.setId(rs.getInt("id"));
		nutil.setNom(rs.getString("nom"));
        nutil.setPrenom(rs.getString("prenom"));
        nutil.setAdresseMail(rs.getString("adressemail"));
        nutil.setMotDePasse(rs.getString("motdepasse"));
        nutil.setPresentation(rs.getString("presentation"));
        nutil.setNiveau(rs.getString("niveau"));
        
        return nutil;
	}

}
