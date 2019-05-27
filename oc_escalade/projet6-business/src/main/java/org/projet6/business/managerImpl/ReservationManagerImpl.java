package org.projet6.business.managerImpl;

import java.util.ArrayList;
import java.util.List;

import org.projet6.business.manager.AbstractManager;
import org.projet6.business.manager.ReservationManager;
import org.projet6.model.bean.ResaTopo;
import org.projet6.model.bean.Topo;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class ReservationManagerImpl extends AbstractManager implements ReservationManager {

  public List<ResaTopo> listeReservation() {

    List<ResaTopo> listeResa = getDaoFactory().getReservationDao().listeResaTopo();

    return listeResa;
  }

  public ResaTopo getResaById(int id) {

    ResaTopo resaTopo = getDaoFactory().getReservationDao().getResaTopoById(id);

    return resaTopo;
  }

  @Transactional(value = "txManager")
  public void ajoutResa(final ResaTopo resaTopo) {

    TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());

    vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {

      @Override
      protected void doInTransactionWithoutResult(TransactionStatus status) {

        getDaoFactory().getReservationDao().create(resaTopo);

      }
    });

  }

  public List<ResaTopo> listeResaTopoByTopoId(int topoId) {

    List<ResaTopo> listeResaTopo = getDaoFactory().getReservationDao().listeResaTopoByTopoId(topoId);

    return listeResaTopo;

  }

  public List<Topo> listeTopoDispo(Integer utilisateurId, boolean displayMyOwn) {

    List<Topo> listeTopo = getDaoFactory().getTopoDao().listTopo();

    List<Topo> listTopoReworked = new ArrayList<Topo>();

    for (Topo topo : listeTopo) {

      // on exclus les topos dont le propriétaire est identique à l'utilisateur qui
      // fait la requête
      if (!topo.getProprietaire().getId().equals(utilisateurId) || displayMyOwn) {

        listTopoReworked.add(topo);
      }
    }
    return listTopoReworked;
  }

  public List<Topo> listeLoanedTopo(Integer loanerId) {

    List<Topo> listTopo = getDaoFactory().getTopoDao().listeTopoByLoanerId(loanerId);

    return listTopo;
  }

  public List<Topo> listeBorrowedTopo(Integer borrowerId) {

    List<Topo> listTopo = getDaoFactory().getTopoDao().listeTopoByBorrowerId(borrowerId);

    return listTopo;
  }

  public List<Topo> listeTopoDispo(Integer utilisateurId) {
    // TODO Auto-generated method stub
    return null;
  }

  public List<ResaTopo> listeResaTopoByUtilisateurId(int utilisateurId) {

    List<ResaTopo> listeResaTopo = getDaoFactory().getReservationDao().listeResaTopoByUtilisateurId(utilisateurId);

    return listeResaTopo;
  }

  public void deleteReservationbyId(int resaId) {

    getDaoFactory().getReservationDao().deleteReservationById(resaId);

  }

}