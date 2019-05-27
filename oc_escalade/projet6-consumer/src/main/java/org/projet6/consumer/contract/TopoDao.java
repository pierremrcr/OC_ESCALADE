package org.projet6.consumer.contract;
import java.util.List;

import org.projet6.model.bean.ResaTopo;
import org.projet6.model.bean.Topo;

public interface TopoDao {
	
	public Topo getTopoByID(int id);
	
	public List<Topo> listTopo();
	
	public Topo create(Topo topo);
	
	public void supprimeTopo(int id);
	
	public void updateTopo(Topo topo);

	public List<Topo> listTopoDispoByUtilisateurId(int utilisateurId);

	public List<Topo> listeTopoByLoanerId(Integer loanerId);
	
	public List<Topo> listeTopoByBorrowerId(Integer borrowerId);
	
	public List<Topo> listeTopoByReservation (ResaTopo resaTopo);

}
