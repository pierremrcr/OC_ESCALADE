package org.projet6.action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.projet6.model.bean.Utilisateur;
import org.springframework.util.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

public class BackGestionUtilisateurAction extends ActionSupport implements SessionAware {

  private Map<String, Object> session;
  private Utilisateur         utilisateur;
  private String              nom;
  private String              prenom;
  private String              adresseMail;
  private String              motDePasse;
  private String              presentation;
  private String              niveau;
  private Integer             id;

  public Utilisateur getUtilisateur() {
    return utilisateur;
  }

  public void setUtilisateur(Utilisateur utilisateur) {
    this.utilisateur = utilisateur;
  }

  public String getNom() {
    return nom;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public String getPrenom() {
    return prenom;
  }

  public void setPrenom(String prenom) {
    this.prenom = prenom;
  }

  public String getAdresseMail() {
    return adresseMail;
  }

  public void setAdresseMail(String adresseMail) {
    this.adresseMail = adresseMail;
  }

  public String getMotDePasse() {
    return motDePasse;
  }

  public void setMotDePasse(String motDePasse) {
    this.motDePasse = motDePasse;
  }

  public String getPresentation() {
    return presentation;
  }

  public void setPresentation(String presentation) {
    this.presentation = presentation;
  }

  public String getNiveau() {
    return niveau;
  }

  public void setNiveau(String niveau) {
    this.niveau = niveau;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public void setSession(Map<String, Object> pSession) {
    this.session = pSession;
  }

  public Map<String, Object> getSession() {
    return session;
  }

  public String doDetail() {

    utilisateur = (Utilisateur) this.session.get("user");

    return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;

  }

  public String doUpdate() {

    String vResult = ActionSupport.INPUT;

    boolean champVide = true;

    if (id == null) {

      this.addActionError("veuillez donner un identifiant");

    } else {

      try {

        Utilisateur utilisateurEnSession = (Utilisateur) this.session.get("user");

        if (!StringUtils.isEmpty(nom)) {
          utilisateurEnSession.setNom(nom);
          champVide = false;
        }

        if (!StringUtils.isEmpty(prenom)) {
          utilisateurEnSession.setPrenom(prenom);
          champVide = false;
        }

        if (!StringUtils.isEmpty(adresseMail)) {
          utilisateurEnSession.setAdresseMail(adresseMail);
          champVide = false;
        }

        if (!StringUtils.isEmpty(motDePasse)) {
          utilisateurEnSession.setMotDePasse(motDePasse);
          champVide = false;
        }

        if (!StringUtils.isEmpty(presentation)) {
          utilisateurEnSession.setPresentation(presentation);
          champVide = false;
        }

        if (!StringUtils.isEmpty(niveau)) {
          utilisateurEnSession.setNiveau(niveau);
          champVide = false;
        }

        if (champVide == true) {

          return ActionSupport.INPUT;

        }

        WebappHelper.getManagerFactory().getUtilisateurManager().updateUtilisateur(utilisateurEnSession);

      } catch (Exception E) {

        vResult = ActionSupport.INPUT;

      }

    }

    return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;

  }

}