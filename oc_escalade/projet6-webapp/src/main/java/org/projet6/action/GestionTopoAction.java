package org.projet6.action;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts2.interceptor.SessionAware;
import org.projet6.model.bean.Commentaire;
import org.projet6.model.bean.ResaTopo;
import org.projet6.model.bean.Topo;
import org.projet6.model.bean.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

public class GestionTopoAction extends ActionSupport implements SessionAware {

  private Integer             id;
  private Topo                topo;
  private Date                dateDebut;
  private Date                dateFin;
  private Integer             topo_id;
  private List<Topo>          listeTopo;
  private Map<String, Object> session;
  private Utilisateur         utilisateurEnSession;
  private Commentaire         commentaire = new Commentaire();
  private List<ResaTopo>      listeEmprunt;
  private List<ResaTopo>      listeBorrowedTopo;
  private Integer             utilisateurId;

  static final Log logger = LogFactory.getLog(GestionResaTopoAction.class);

  public Utilisateur getUtilisateurEnSession() {
    return utilisateurEnSession;
  }

  public void setUtilisateurEnSession(Utilisateur utilisateurEnSession) {
    this.utilisateurEnSession = utilisateurEnSession;
  }

  public Commentaire getCommentaire() {
    return commentaire;
  }

  public void setCommentaire(Commentaire commentaire) {
    this.commentaire = commentaire;
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

  public List<Topo> getListeTopo() {
    return listeTopo;
  }

  public void setListeTopo(List<Topo> listeTopo) {
    this.listeTopo = listeTopo;
  }

  public Map<String, Object> getSession() {
    return session;
  }

  public void setSession(Map<String, Object> session) {
    this.session = session;
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

  public List<ResaTopo> getListeEmprunt() {
    return listeEmprunt;
  }

  public void setListeEmprunt(List<ResaTopo> listeEmprunt) {
    this.listeEmprunt = listeEmprunt;
  }

  public Integer getTopo_id() {
    return topo_id;
  }

  public void setTopo_id(Integer topo_id) {
    this.topo_id = topo_id;
  }

  public List<ResaTopo> getListeBorrowedTopo() {
    return listeBorrowedTopo;
  }

  public void setListeBorrowedTopo(List<ResaTopo> listeBorrowedTopo) {
    this.listeBorrowedTopo = listeBorrowedTopo;
  }

  public Integer getUtilisateurId() {
    return utilisateurId;
  }

  public void setUtilisateurId(Integer utilisateurId) {
    this.utilisateurId = utilisateurId;
  }

  public String doList() {

    listeTopo = WebappHelper.getManagerFactory().getTopoManager().getListeTopo();

    return ActionSupport.SUCCESS;

  }

  public String doDetail() {

    if (id == null) {

      this.addActionError("Vous devez indiquer un id");

    } else {

      topo = WebappHelper.getManagerFactory().getTopoManager().getTopoById(id);

    }

    return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;

  }

  public String doCreate() {

    String vResult = ActionSupport.INPUT;

    if (this.topo != null) {

      if (topo.getNom() == null || topo.getDescription() == null) {
        this.addActionError("Vous devez indiquer un nom et une description");
      }

      if (!this.hasErrors()) {

        try {

          Utilisateur utilisateurEnSession = (Utilisateur) this.session.get("user");
          System.out.println(utilisateurEnSession.getId());
          topo.setProprietaire(utilisateurEnSession);
          WebappHelper.getManagerFactory().getTopoManager().ajoutTopo(topo);
          this.addActionMessage("Création d'un nouveau topo");
          vResult = ActionSupport.SUCCESS;

        } catch (Exception e) {

          System.out.println("error : " + e.getMessage());
          vResult = ActionSupport.INPUT;
        }
      }
    }

    return vResult;

  }

  public String doAddComment() {

    String vResult = ActionSupport.INPUT;

    Utilisateur utilisateurEnSession = (Utilisateur) this.session.get("user");

    commentaire.setUtilisateur(utilisateurEnSession);

    WebappHelper.getManagerFactory().getCommentaireTopoManager().ajoutCommentaireTopo(commentaire, id);

    return ActionSupport.SUCCESS;
  }

  public String doDelete() {

    String vResult = ActionSupport.INPUT;

    if (id == null) {
      vResult = ActionSupport.INPUT;
    }

    else {

      WebappHelper.getManagerFactory().getTopoManager().deleteTopo(id);

      vResult = ActionSupport.SUCCESS;
    }

    return vResult;
  }

  public String doBorrow() {

    String vResult = ActionSupport.INPUT;

    utilisateurEnSession = (Utilisateur) this.session.get("user");

    logger.info("nom user : " + utilisateurEnSession.getNom());

    // On récupère la liste des emprunts du topo

    try {

      topo = WebappHelper.getManagerFactory().getTopoManager().getTopoById(id);
      topo_id = topo.getId();
      listeEmprunt = WebappHelper.getManagerFactory().getReservationManager().listeResaTopoByTopoId(topo_id);

    } catch (Exception e) {

      e.printStackTrace();
    }

    boolean[] testReservation = new boolean[listeEmprunt.size()];
    int i = 0;
    logger.info("Date de début : " + dateDebut);

    if (dateDebut == null || dateFin == null) {

      return vResult;
    }

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

      logger.info(dateDebut);
      logger.info(dateFin);
      logger.info(topo.getNom());

      WebappHelper.getManagerFactory().getReservationManager().ajoutResa(reservation);
      this.addActionMessage("une réservation effectuée");
      return vResult = ActionSupport.SUCCESS;

    }

    else {

      this.addActionMessage("une réservation est en cours pendant la période demandé");

    }

    return vResult;

  }

  public static boolean areAllTrue(boolean[] array) {

    for (boolean b : array)

      if (!b) {

        return false;
      }

    return true;
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
