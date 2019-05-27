package org.projet6.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.projet6.model.bean.ResaTopo;
import org.projet6.model.bean.Topo;
import org.projet6.model.bean.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

public class GestionResaTopoAction extends ActionSupport implements SessionAware {

  private Integer             id;
  private Topo                topo;
  private Date                dateDebut;
  private Date                dateFin;
  private Integer             topo_id;
  private List<Topo>          listeTopoDispo;
  private List<ResaTopo>      listeBorrowedTopo;
  private List<Topo>          listeLoanedTopo;
  private List<ResaTopo>      listeEmprunt;
  private Map<String, Object> session;
  private Utilisateur         utilisateurEnSession;
  private Integer             utilisateurId;

  public Map<String, Object> getSession() {
    return session;
  }

  public void setSession(Map<String, Object> session) {
    this.session = session;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Topo getTopo() {
    return topo;
  }

  public void setTopo(Topo topo) {
    this.topo = topo;
  }

  public Date getDateDebut() {
    return dateDebut;
  }

  public void setDateDebut(Date dateDebut) {
    this.dateDebut = dateDebut;
  }

  public Date getDateFin() {
    return dateFin;
  }

  public void setDateFin(Date dateFin) {
    this.dateFin = dateFin;
  }

  public List<Topo> getListeTopoDispo() {
    return listeTopoDispo;
  }

  public void setListeTopoDispo(List<Topo> listeTopoDispo) {
    this.listeTopoDispo = listeTopoDispo;
  }

  public List<ResaTopo> getListeBorrowedTopo() {
    return listeBorrowedTopo;
  }

  public void setListeBorrowedTopo(List<ResaTopo> listeBorrowedTopo) {
    this.listeBorrowedTopo = listeBorrowedTopo;
  }

  public List<Topo> getListeLoanedTopo() {
    return listeLoanedTopo;
  }

  public void setListeLoanedTopo(List<Topo> listeLoanedTopo) {
    this.listeLoanedTopo = listeLoanedTopo;
  }

  public List<ResaTopo> getListeEmprunt() {
    return listeEmprunt;
  }

  public void setListeEmprunt(List<ResaTopo> listeEmprunt) {
    this.listeEmprunt = listeEmprunt;
  }

  public Utilisateur getUtilisateurEnSession() {
    return utilisateurEnSession;
  }

  public void setUtilisateurEnSession(Utilisateur utilisateurEnSession) {
    this.utilisateurEnSession = utilisateurEnSession;
  }

  public Integer getUtilisateurId() {
    return utilisateurId;
  }

  public void setUtilisateurId(Integer utilisateurId) {
    this.utilisateurId = utilisateurId;
  }

  public Integer getTopo_id() {
    return topo_id;
  }

  public void setTopo_id(Integer topo_id) {
    this.topo_id = topo_id;
  }

  public String doList() {

    listeEmprunt = WebappHelper.getManagerFactory().getReservationManager().listeResaTopoByTopoId(topo.getId());

    return ActionSupport.SUCCESS;

  }

  public String doBorrow() {

    String vResult = ActionSupport.INPUT;

    utilisateurEnSession = (Utilisateur) this.session.get("user");

    topo = WebappHelper.getManagerFactory().getTopoManager().getTopoById(id);

    listeEmprunt = WebappHelper.getManagerFactory().getReservationManager().listeResaTopoByTopoId(id);

    boolean[] testReservation = new boolean[listeEmprunt.size()];
    int i = 0;

    for (ResaTopo reservation : listeEmprunt) {

      if (reservation.getDateFin().compareTo(dateDebut) < 0) {
        // réservation fini
        testReservation[i] = true;
      } else if (reservation.getDateDebut().compareTo(dateDebut) > 0
          && reservation.getDateDebut().compareTo(dateFin) > 0) {
        // réservation pas encore commencé
        testReservation[i] = true;
      } else {
        // en plein pendant la période de réservation
        testReservation[i] = false;

      }

      i++;

    }

    if (areAllTrue(testReservation)) {

      // add reservation
      ResaTopo reservation = new ResaTopo();

      reservation.setDateDebut(dateDebut);
      reservation.setDateFin(dateFin);
      reservation.setTopo(topo);
      reservation.setEmprunteur(utilisateurEnSession);

      WebappHelper.getManagerFactory().getReservationManager().ajoutResa(reservation);
      this.addActionMessage("une réservation effectuée");
      return vResult = ActionSupport.SUCCESS;

    }

    else {

      this.addActionMessage("une réservation est en cours pendant la période demandé");

    }

    return vResult;

  }

  public static boolean areAllTrue(boolean[] array)

  {
    for (boolean b : array)

      if (!b) {

        return false;
      }

    return true;
  }

  public String doCancel() {

    String vResult = ActionSupport.INPUT;

    if (id == null) {

      vResult = ActionSupport.INPUT;

    }

    else {

      WebappHelper.getManagerFactory().getReservationManager().deleteReservationbyId(id);

      vResult = ActionSupport.SUCCESS;

    }

    return vResult;
  }

  public String doManageMyLoan() {

    Utilisateur utilisateurEnSession = (Utilisateur) this.session.get("user");
    utilisateurId = utilisateurEnSession.getId();

    listeBorrowedTopo = WebappHelper.getManagerFactory().getReservationManager()
        .listeResaTopoByUtilisateurId(utilisateurId);

    for (ResaTopo reservation : listeBorrowedTopo) {

      topo = reservation.getTopo();
      topo_id = topo.getId();

    }

    return ActionSupport.SUCCESS;

  }

}
