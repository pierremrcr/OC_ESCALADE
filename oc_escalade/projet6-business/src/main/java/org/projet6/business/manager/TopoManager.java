package org.projet6.business.manager;

import java.util.List;

import org.projet6.model.bean.Topo;

public interface TopoManager {
	
	List<Topo> getListeTopo();
	
	Topo getTopoById(int id);
	
	void ajoutTopo(Topo topo);
	
	void deleteTopo(int id);
	
	void updateTopo(Topo topo);
	
	

}
