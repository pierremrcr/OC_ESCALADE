package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.projet6.consumer.Impl.TopoDaoImpl;
import org.projet6.consumer.Impl.UtilisateurDaoImpl;
import org.projet6.model.bean.ResaTopo;
import org.springframework.jdbc.core.RowMapper;

public class MapperReservation implements RowMapper<ResaTopo> {

  public ResaTopo mapRow(ResultSet rs, int rowNum) throws SQLException {

    ResaTopo resaTopo = new ResaTopo(rs.getInt("id"));
    resaTopo.setDateDebut(rs.getDate("datedebut"));
    resaTopo.setDateFin(rs.getDate("datefin"));

    TopoDaoImpl topoDao = new TopoDaoImpl();
    UtilisateurDaoImpl userDao = new UtilisateurDaoImpl();

    resaTopo.setTopo(topoDao.getTopoByID(rs.getInt("topo_id")));
    resaTopo.setProprietaireTopo(userDao.getbyID(rs.getInt("utilisateur_id")));

    return resaTopo;
  }

}
