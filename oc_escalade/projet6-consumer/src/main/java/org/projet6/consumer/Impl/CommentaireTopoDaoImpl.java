package org.projet6.consumer.Impl;

import java.util.List;

import org.projet6.consumer.contract.CommentaireTopoDao;
import org.projet6.model.bean.Commentaire;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import mapper.MapperCommentaireTopo;

public class CommentaireTopoDaoImpl extends AbstractDaoImpl implements CommentaireTopoDao {

  public Commentaire getCommentaireTopoByID(int id) {

    String vSQL = "SELECT * FROM public.commentaire_topo where id = ?";

    JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

    MapperCommentaireTopo mapCommentaireTopo = new MapperCommentaireTopo();

    Commentaire commentaireTopo = vJdbcTemplate.queryForObject(vSQL, mapCommentaireTopo, id);

    return commentaireTopo;
  }

  public Commentaire ajoutCommentaireTopo(Commentaire commentaireTopo, int topo_id) {

    String vSQL = "INSERT INTO public.commentaire_topo(contenu, date, utilisateur_id,topo_id) VALUES(:contenu,:date,:utilisateur_id,:topo_id)";

    SqlParameterSource ajoutCommentaireTopo = new MapSqlParameterSource()
        .addValue("contenu", commentaireTopo.getContenu())
        .addValue("date", commentaireTopo.getDate())
        .addValue("utilisateur_id", commentaireTopo.getUtilisateur().getId())
        .addValue("topo_id", topo_id);

    KeyHolder keyHolder = new GeneratedKeyHolder();

    NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
    vJdbcTemplate.update(vSQL, ajoutCommentaireTopo, keyHolder, new String[] { "id" });
    int newId = keyHolder.getKey().intValue();
    commentaireTopo.setId(newId);

    return commentaireTopo;

  }

  public List<Commentaire> listeCommentaireTopo() {

    String vSQL = "SELECT * FROM public.commentaire_topo";

    JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

    MapperCommentaireTopo mapCommentaireTopo = new MapperCommentaireTopo();

    List<Commentaire> listeCommentairesTopo = vJdbcTemplate.query(vSQL, mapCommentaireTopo);

    return listeCommentairesTopo;
  }

  public void supprimeCommentaireTopo(int id) {

    String vSQL = "DELETE FROM public.commentaire_topo where id= ?";

    JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

    vJdbcTemplate.update(vSQL, id);

  }

  public void deleteCommentaireTopoByUser(int id) {

    String vSQL = "DELETE FROM public.commentaire_topo where utilisateur_id= ?";

    JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

    vJdbcTemplate.update(vSQL, id);

  }

  public List<Commentaire> getCommentaireTopoByTopoID(int id) {

    String vSQL = "SELECT * FROM public.commentaire_topo where topo_id= ?";

    JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

    MapperCommentaireTopo mapCommentaireTopo = new MapperCommentaireTopo();

    List<Commentaire> listeCommentairesTopo = vJdbcTemplate.query(vSQL, mapCommentaireTopo, id);

    return listeCommentairesTopo;
  }

  public List<Commentaire> listeCommentaireTopoByTopoId(int topoId) {
    // TODO Auto-generated method stub
    return null;
  }

  public void updateCommentaireTopo(Commentaire commentaireTopo) {
    // TODO Auto-generated method stub

  }

}
