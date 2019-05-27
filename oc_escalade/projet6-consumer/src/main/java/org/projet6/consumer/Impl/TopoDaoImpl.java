package org.projet6.consumer.Impl;


import java.util.List;

import org.projet6.consumer.contract.TopoDao;
import org.projet6.model.bean.ResaTopo;
import org.projet6.model.bean.Topo;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import mapper.MapperTopo;


public class TopoDaoImpl extends AbstractDaoImpl implements TopoDao {

	public Topo getTopoByID(int id) {
		
		String vSQL = "SELECT * FROM public.topo where id = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		MapperTopo mapTopo = new MapperTopo();

		Topo topo = vJdbcTemplate.queryForObject(vSQL, mapTopo, id);

		return topo;
		
		
	}

	public List<Topo> listTopo() {
		
		String vSQL = "SELECT * FROM public.topo";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		MapperTopo mapTopo = new MapperTopo();

		List<Topo> listeTopos = vJdbcTemplate.query(vSQL, mapTopo);

		return listeTopos;
	
	}

	public Topo create(Topo topo) {
		
		String vSQL = "INSERT INTO public.topo(nom, description, proprietaire_id) VALUES(:nom,:description,:proprietaire_id)";

		SqlParameterSource ajoutTopo = new MapSqlParameterSource()
				.addValue("nom", topo.getNom())
				.addValue("description", topo.getDescription())
				.addValue("proprietaire_id", topo.getProprietaire().getId());

		KeyHolder keyHolder = new GeneratedKeyHolder();

		NamedParameterJdbcTemplate vJdbcTemplate = new NamedParameterJdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, ajoutTopo, keyHolder, new String[]{"id"});
		int newId = keyHolder.getKey().intValue();
		topo.setId(newId);
		
		System.out.println("Topo crée" + topo);

		return topo;
	}

	public void supprimeTopo(int id) {
		
        String vSQL = "DELETE FROM public.topo where id= ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		vJdbcTemplate.update(vSQL, id);
		
		
	}

	public void updateTopo(Topo topo) {
		
	String vSQL = "UPDATE public.topo SET nom=?, description=?, proprietaire_id=? WHERE id = ?";
		
		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());
		
		vJdbcTemplate.update(vSQL, topo.getNom(), topo.getDescription(), topo.getProprietaire().getId());
		
	}

	public List<Topo> listTopoDispoByUtilisateurId(int utilisateurId) {
		
		String vSQL = "SELECT * FROM public.topo where proprietaire_id = ?";

		JdbcTemplate vJdbcTemplate = new JdbcTemplate(getDataSource());

		MapperTopo mapTopo = new MapperTopo();

		List<Topo> listeTopo = vJdbcTemplate.query(vSQL, mapTopo, utilisateurId);

		return listeTopo;
	}

	public List<Topo> listeTopoByLoanerId(Integer loanerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Topo> listeTopoByBorrowerId(Integer borrowerId) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Topo> listeTopoByReservation(ResaTopo resaTopo) {
		
		   String vSQL = "SELECT * FROM public.topo WHERE id = " + resaTopo.getTopo().getId();
		   
		   JdbcTemplate vJdbcTemplate =  new JdbcTemplate(getDataSource());
		   
		   MapperTopo mapTopo = new MapperTopo();
		   
		   List<Topo> listeTopo = vJdbcTemplate.query(vSQL, mapTopo, resaTopo);
		   
		   return listeTopo;
		   
	}
	
	

}
