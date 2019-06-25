package org.projet6.consumer.Impl;

import java.util.List;

import org.projet6.consumer.contract.UtilisateurDao;
import org.projet6.model.bean.Utilisateur;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import mapper.MapperUtilisateur;

public class UtilisateurDaoImpl extends AbstractDaoImpl implements UtilisateurDao {

	public List<Utilisateur> listutilisateur() {

		String vSQL = "SELECT * FROM public.utilisateur";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		MapperUtilisateur maputil = new MapperUtilisateur();

		List<Utilisateur> vutil = vJdbcTemplate.query(vSQL, maputil);

		return vutil;

	}

	public Utilisateur getbyID(int id) {
		// creation d'une requete avec pour resultat un parametre iD
		String vSQL = "SELECT * FROM public.utilisateur where id= ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		MapperUtilisateur maputil = new MapperUtilisateur();

		Utilisateur utilisateur = vJdbcTemplate.queryForObject(vSQL, maputil, id);

		return utilisateur;
	}

	public Utilisateur getbyPassword(String adresseMail, String motdepasse) {
		// creation d'une requete avec pour resultat un parametre iD
		String vSQL = "SELECT * FROM public.utilisateur where adressemail = ? and motdepasse = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		MapperUtilisateur maputil = new MapperUtilisateur();

		Utilisateur utilisateur = vJdbcTemplate.queryForObject(vSQL, maputil, adresseMail, motdepasse);

		return utilisateur;
	}

	public void supprimeUtilisateur(int id) {

		String vSQL = "DELETE FROM public.utilisateur where id = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		vJdbcTemplate.update(vSQL, id);

	}

	public Utilisateur create(Utilisateur utilisateur) {

		String vSQL = "INSERT INTO public.utilisateur(nom, prenom, adressemail, motdepasse, presentation, niveau) VALUES(:nom,:prenom,:adressemail,:motdepasse,:presentation,:niveau)";

		SqlParameterSource ajoutUtil = new MapSqlParameterSource().addValue("nom", utilisateur.getNom())
				.addValue("prenom", utilisateur.getPrenom()).addValue("adressemail", utilisateur.getAdresseMail())
				.addValue("motdepasse", utilisateur.getMotDePasse())
				.addValue("presentation", utilisateur.getPresentation()).addValue("niveau", utilisateur.getNiveau());

		// Gestion de la clé primaire
		KeyHolder holder = new GeneratedKeyHolder();

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, ajoutUtil, holder, new String[] { "id" });

		int id = holder.getKey().intValue();
		utilisateur.setId(id);

		System.out.println("utilisateur crée" + utilisateur);

		return utilisateur;

	}

	public void updateUtilisateur(Utilisateur utilisateur) {

		String vSQL = "UPDATE public.utilisateur SET nom=?, prenom=?, adressemail=?, motdepasse=?, presentation=?, niveau=? WHERE id = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		vJdbcTemplate.update(vSQL, utilisateur.getNom(), utilisateur.getPrenom(), utilisateur.getAdresseMail(),
				utilisateur.getMotDePasse(), utilisateur.getPresentation(), utilisateur.getNiveau(), utilisateur.getId());
	}

}