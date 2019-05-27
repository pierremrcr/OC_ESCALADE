package org.projet6.consumer.Impl;

import java.util.List;

import org.projet6.consumer.contract.ReservationDao;
import org.projet6.model.bean.ResaTopo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import mapper.MapperReservation;

public class ReservationDaoImpl extends AbstractDaoImpl implements ReservationDao {

  public ResaTopo getResaTopoById(int id) {

    String vSQL = "SELECT * FROM public.resatopo where id = ?";

    JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

    MapperReservation mapResa = new MapperReservation();

    ResaTopo resa = vJdbcTemplate.queryForObject(vSQL, mapResa, id);

    return resa;
  }

  public List<ResaTopo> listeResaTopo() {

    String vSQL = "SELECT * FROM public.resatopo";

    JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

    MapperReservation mapResa = new MapperReservation();

    List<ResaTopo> listeResa = vJdbcTemplate.query(vSQL, mapResa);

    return listeResa;
  }

  public ResaTopo create(ResaTopo resaTopo) {

    String vSQL = "INSERT INTO public.resatopo(datedebut, datefin, topo_id, utilisateur_id) VALUES(:datedebut,:datefin,:topo_id,:utilisateur_id)";

    SqlParameterSource ajoutResa = new MapSqlParameterSource().addValue("datedebut", resaTopo.getDateDebut())
        .addValue("datefin", resaTopo.getDateFin()).addValue("topo_id", resaTopo.getTopo().getId())
        .addValue("utilisateur_id", resaTopo.getEmprunteur().getId());

    KeyHolder keyHolder = new GeneratedKeyHolder();

    NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());

    vJdbcTemplate.update(vSQL, ajoutResa, keyHolder, new String[] { "id" });

    int newId = keyHolder.getKey().intValue();

    resaTopo.setId(newId);

    System.out.println("Reservation de topo crée" + "" + resaTopo);

    return resaTopo;

  }

  public ResaTopo supprimeResa(int id) {

    String vSQL = "DELETE FROM public.resatopo where id= ?";

    JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

    vJdbcTemplate.update(vSQL, id);

    return null;

  }

  public List<ResaTopo> listeResaTopoByTopoId(int topoId) {

    String vSQL = "SELECT * FROM public.resatopo where topo_id = ?";

    JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

    MapperReservation mapResa = new MapperReservation();

    List<ResaTopo> listeResa = vJdbcTemplate.query(vSQL, mapResa, topoId);

    return listeResa;

  }

  public List<ResaTopo> listeResaTopoByUtilisateurId(int utilisateurId) {

    String vSQL = "SELECT * FROM public.resatopo where utilisateur_id = ?";

    JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

    MapperReservation mapResa = new MapperReservation();

    List<ResaTopo> listeResa = vJdbcTemplate.query(vSQL, mapResa, utilisateurId);

    return listeResa;

  }

  public void deleteReservationById(int resaId) {

    String vSQL = "DELETE FROM public.resatopo where id = ?";

    JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

    vJdbcTemplate.update(vSQL, resaId);

  }

}
