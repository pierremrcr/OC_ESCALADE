package org.projet6.business.manager;

import java.util.List;

import org.projet6.model.bean.ResaTopo;
import org.projet6.model.bean.Topo;

public interface ReservationManager {

  List<ResaTopo> listeReservation();

  List<Topo> listeTopoDispo(Integer utilisateurId, boolean displayMyOwn);

  public List<Topo> listeTopoDispo(Integer utilisateurId);

  List<ResaTopo> listeResaTopoByTopoId(int topoId);

  List<ResaTopo> listeResaTopoByUtilisateurId(int utilisateurId);

  ResaTopo getResaById(int id);

  void ajoutResa(ResaTopo resaTopo);

  List<Topo> listeLoanedTopo(Integer loanerId);

  List<Topo> listeBorrowedTopo(Integer borrowerId);

  void deleteReservationbyId(int resaId);

}
