package org.projet6.business.managerImpl;

import java.util.List;

import org.projet6.business.manager.AbstractManager;
import org.projet6.business.manager.UtilisateurManager;
import org.projet6.model.bean.Utilisateur;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

  public List<Utilisateur> getListUtilisateur() {

    List<Utilisateur> usersList = getDaoFactory().getUtilisateurDao().listutilisateur();

    return usersList;

  }

  public Utilisateur getUtilisateur(int Id) {

    Utilisateur utilisateur = getDaoFactory().getUtilisateurDao().getbyID(Id);

    return utilisateur;
  }

  public Utilisateur getUtilisateur(String adresseMail, String password) /* throws NotFoundException */ {
    // List<Utilisateur> listeUtilisateurs = this.getListUtilisateur();
    Utilisateur utilisateur = getDaoFactory().getUtilisateurDao().getbyPassword(adresseMail, password);
    // for (Utilisateur utilisateur : listeUtilisateurs) {
    // if (StringUtils.equals(adresseMail, utilisateur.getAdresseMail()) &&
    // StringUtils.equals(password, utilisateur.getMotDePasse())) {
    // if (adresseMail.equals(utilisateur.getAdresseMail()) &&
    // password.equals(utilisateur.getMotDePasse())) {
    return utilisateur;
    // }

    // throw new NotFoundException();
  }

  @Transactional(value = "txManager")
  public void ajoutUtilisateur(final Utilisateur utilisateur) {

    TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());

    vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {

      @Override
      protected void doInTransactionWithoutResult(TransactionStatus status) {

        getDaoFactory().getUtilisateurDao().create(utilisateur);
      }
    });

  }

  public void deleteUtilisateur(int id) {

    getDaoFactory().getUtilisateurDao().supprimeUtilisateur(id);

  }

  @Transactional(value = "txManager")
  public void updateUtilisateur(final Utilisateur utilisateur) {

    TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());

    vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {

      @Override
      protected void doInTransactionWithoutResult(TransactionStatus status) {

        getDaoFactory().getUtilisateurDao().updateUtilisateur(utilisateur);

      }
    });

  }

}
