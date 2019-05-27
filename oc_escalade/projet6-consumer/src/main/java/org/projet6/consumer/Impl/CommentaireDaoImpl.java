package org.projet6.consumer.Impl;

import java.util.List;

import org.projet6.consumer.contract.CommentaireDao;
import org.projet6.model.bean.Commentaire;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import mapper.MapperCommentaire;

public class CommentaireDaoImpl extends AbstractDaoImpl implements CommentaireDao {

	public Commentaire getCommentaireByID(int id) {

		String vSQL = "SELECT * FROM public.commentaire where id = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		MapperCommentaire mapCommentaire = new MapperCommentaire();

		Commentaire commentaire = vJdbcTemplate.queryForObject(vSQL, mapCommentaire, id);

		return commentaire;
	}

	public Commentaire ajoutCommentaireBySpotId(Commentaire commentaire, int spot_id) {

		String vSQL = "INSERT INTO public.commentaire(contenu, date, utilisateur_id,spot_id) VALUES(:contenu,:date,:utilisateur_id,:spot_id)";

		SqlParameterSource ajoutCommentaire = new MapSqlParameterSource().addValue("contenu", commentaire.getContenu())
				.addValue("date", commentaire.getDate())
				.addValue("utilisateur_id", commentaire.getUtilisateur().getId()).addValue("spot_id", spot_id);

		KeyHolder keyHolder = new GeneratedKeyHolder();

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, ajoutCommentaire, keyHolder, new String[] { "id" });
		int newId = keyHolder.getKey().intValue();
		commentaire.setId(newId);

		return commentaire;
	}

	public List<Commentaire> listeCommentaire() {

		String vSQL = "SELECT * FROM public.commentaire";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		MapperCommentaire mapCommentaire = new MapperCommentaire();

		List<Commentaire> listeCommentaires = vJdbcTemplate.query(vSQL, mapCommentaire);

		return listeCommentaires;
	}

	public void supprimeCommentaire(int id) {

		String vSQL = "DELETE FROM public.commentaire where id= ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		vJdbcTemplate.update(vSQL, id);

	}

	public List<Commentaire> getCommentaireBySpot(int id) {

		String vSQL = "SELECT * FROM public.commentaire where spot_id= ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		MapperCommentaire mapCommentaire = new MapperCommentaire();

		List<Commentaire> listeCommentaire = vJdbcTemplate.query(vSQL, mapCommentaire, id);

		return listeCommentaire;
	}

	public void deleteCommentaireByUser(int id) {

		String vSQL = "DELETE FROM public.commentaire where utilisateur_id= ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		vJdbcTemplate.update(vSQL, id);

	}

	public void deleteCommentaireBySpot(int id) {

		String vSQL = "DELETE FROM public.commentaire where spot_id= ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		vJdbcTemplate.update(vSQL, id);

	}

	public void updateCommentaire(Commentaire commentaire) {

		String vSQL = "UPDATE public.commentaire SET contenu = ? WHERE id = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		vJdbcTemplate.update(vSQL, commentaire.getContenu(), commentaire.getId());

	}

//	public Commentaire create(Commentaire commentaire) {
//		String vSQL = "INSERT INTO public.commentaire(contenu, date, utilisateur_id,spot_id) VALUES(:contenu,:date,:utilisateur_id,:spot_id)";
//
//		SqlParameterSource ajoutCommentaire = new MapSqlParameterSource()
//				.addValue("contenu", commentaire.getContenu())
//				.addValue("date", commentaire.getDate())
//				.addValue("utilisateur_id", commentaire.getUtilisateur().getId())
//				.addValue("spot_id", commentaire.getSpot().getId());
//
//		KeyHolder keyHolder = new GeneratedKeyHolder();
//
//		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
//		vJdbcTemplate.update(vSQL, ajoutCommentaire, keyHolder, new String[]{"id"});
//		int newId = keyHolder.getKey().intValue();
//		commentaire.setId(newId);
//
//		return commentaire;
//	}

}
