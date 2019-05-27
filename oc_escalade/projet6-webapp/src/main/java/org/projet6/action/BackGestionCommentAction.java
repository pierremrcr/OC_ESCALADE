package org.projet6.action;

import java.util.List;

import org.projet6.model.bean.Commentaire;
import org.springframework.util.StringUtils;

import com.opensymphony.xwork2.ActionSupport;

public class BackGestionCommentAction extends ActionSupport {

  private Commentaire       commentaire;
  private List<Commentaire> listeCommentaires;
  private Integer           id;
  private String            contenu;

  public Commentaire getCommentaire() {
    return commentaire;
  }

  public void setCommentaire(Commentaire commentaire) {
    this.commentaire = commentaire;
  }

  public List<Commentaire> getListeCommentaires() {
    return listeCommentaires;
  }

  public void setListCommentaires(List<Commentaire> listeCommentaires) {
    this.listeCommentaires = listeCommentaires;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getContenu() {
    return contenu;
  }

  public void setContenu(String contenu) {
    this.contenu = contenu;
  }

  public String doListComment() {

    listeCommentaires = WebappHelper.getManagerFactory().getCommentaireManager().getListCommentaire();
    return ActionSupport.SUCCESS;
  }

  public String doDeleteComment() {

    String vResult = ActionSupport.INPUT;

    if (id == null) {
      this.addActionError("veuillez donner un identifiant de commentaire");
    } else {
      try {
        WebappHelper.getManagerFactory().getCommentaireManager().deleteCommentaire(id);
      } catch (Exception E) {
        vResult = ActionSupport.INPUT;
      }
    }

    return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
  }

  public String doDetailComment() {

    String vResult = ActionSupport.INPUT;

    if (id == null) {

      this.addActionError("veuillez donner un identifiant de commentaire");
    } else {

      try {

        commentaire = WebappHelper.getManagerFactory().getCommentaireManager().getCommentaire(id);

      } catch (Exception E) {

        vResult = ActionSupport.INPUT;

      }
    }

    return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
  }

  public String doUpdateComment() {

    String vResult = ActionSupport.INPUT;

    if (id == null) {

      this.addActionError("veuillez donner un identifiant de commentaire");

    } else {

      try {

        commentaire = WebappHelper.getManagerFactory().getCommentaireManager().getCommentaire(id);

        if (!StringUtils.isEmpty(contenu)) {

          commentaire.setContenu(contenu);

          WebappHelper.getManagerFactory().getCommentaireManager().updateCommentaire(commentaire);
        }

      } catch (Exception E) {

        vResult = ActionSupport.INPUT;
      }
    }

    return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
  }

}
