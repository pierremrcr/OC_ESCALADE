package org.projet6.consumer.contract;

import java.util.List;

import org.projet6.model.bean.ResaTopo;

public interface ReservationDao {

  ResaTopo getResaTopoById(int id);

  List<ResaTopo> listeResaTopo();

  List<ResaTopo> listeResaTopoByTopoId(int topoId);

  ResaTopo create(ResaTopo resaTopo);

  ResaTopo supprimeResa(int id);

  List<ResaTopo> listeResaTopoByUtilisateurId(int utilisateurId);

  void deleteReservationById(int resaId);

}
