package org.projet6.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.projet6.model.bean.Utilisateur;
import org.springframework.util.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

public class GestionUtilisateurAction extends ActionSupport implements SessionAware {

  private Integer             id;
  private List<Utilisateur>   listUtilisateur;
  private Utilisateur         utilisateur;
  private Map<String, Object> session;


  public void setSession(Map<String, Object> pSession) {
    this.session = pSession;
  }

  public Map<String, Object> getSession() {
    return session;
  }

  public void setListUtilisateur(List<Utilisateur> listUtilisateur) {
    this.listUtilisateur = listUtilisateur;
  }

  public Utilisateur getUtilisateur() {
    return utilisateur;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public List<Utilisateur> getListUtilisateur() {
    return listUtilisateur;
  }

  public void setUtilisateur(Utilisateur utilisateur) {
    this.utilisateur = utilisateur;
  }

  public String doList() {

    listUtilisateur = WebappHelper.getManagerFactory().getUtilisateurManager().getListUtilisateur();

    return ActionSupport.SUCCESS;

  }

  public String doDetail() {

//		if (id == null) {
//			this.addActionError("Vous devez indiquer un id");
//
//		} else {

    utilisateur = (Utilisateur) this.session.get("user");
//    utilisateur = WebappHelper.getManagerFactory().getUtilisateurManager().getUtilisateur(id);

//	}

    return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;

  }

  public String doCreate() {

    String vResult = ActionSupport.INPUT;

    if (this.utilisateur != null) {

      if (utilisateur.getNom() == null || utilisateur.getPrenom() == null) {
        this.addActionError("Vous devez indiquer un nom et un prénom");
      } else {
        System.out.println("OK");

        if (!this.hasErrors()) {
          try {
            WebappHelper.getManagerFactory().getUtilisateurManager().ajoutUtilisateur(utilisateur);
            vResult = ActionSupport.SUCCESS;
            this.addActionMessage("bienvenue");
          } catch (Exception e) {
            System.out.println(e.getMessage());
            vResult = ActionSupport.INPUT;
          }
        }
      }

    }

    return vResult;

  }

  public String doDelete() {

    String vResult = ActionSupport.INPUT;

    Utilisateur utilisateurEnSession = (Utilisateur) this.session.get("user");

    int utilisateurId = utilisateurEnSession.getId();

    try {

      WebappHelper.getManagerFactory().getUtilisateurManager().deleteUtilisateur(utilisateurId);
      vResult = ActionSupport.SUCCESS;
      this.addActionMessage("votre compte a bien été supprimé");

    } catch (Exception e) {

      vResult = ActionSupport.INPUT;
    }

    return vResult;

  }

 

}