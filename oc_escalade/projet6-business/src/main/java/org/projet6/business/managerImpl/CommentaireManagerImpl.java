package org.projet6.business.managerImpl;

import java.util.List;



import org.projet6.business.manager.AbstractManager;
import org.projet6.business.manager.CommentaireManager;
import org.projet6.model.bean.Commentaire;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import java.sql.Timestamp;
import java.time.Instant;


public class CommentaireManagerImpl extends AbstractManager implements CommentaireManager {

	public List<Commentaire> getListCommentaire() {
		
		List<Commentaire> listeCommentaires = getDaoFactory().getCommentaireDao().listeCommentaire();
		
		return listeCommentaires;
	}

	public Commentaire getCommentaire(int id) {
		
		Commentaire commentaire = getDaoFactory().getCommentaireDao().getCommentaireByID(id);
		
		return commentaire;
	}



	public List<Commentaire> getListCommentaireSpot(int id) {
		
		
		List<Commentaire> listeCommentaire = getDaoFactory().getCommentaireDao().getCommentaireBySpot(id);
		
		
		return listeCommentaire;
	}
	

	@Transactional(value="txManager")
	public void ajoutCommentaire(final Commentaire commentaire, final int spotId) {
		
		TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());
		
		vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				commentaire.setDate(Timestamp.from(Instant.now()));
				
				getDaoFactory().getCommentaireDao().ajoutCommentaireBySpotId(commentaire, spotId);
			}
		});
		
	}

	public void deleteCommentaire(int id) {
		
		getDaoFactory().getCommentaireDao().supprimeCommentaire(id);
		
	}

	

	public void deleteCommentaireBySpot(int id) {
		
		getDaoFactory().getCommentaireDao().deleteCommentaireBySpot(id);
		
	}

	public void deleteCommentaireByUser(int id) {
	
		getDaoFactory().getCommentaireDao().deleteCommentaireByUser(id);
	}

	public void updateCommentaire(Commentaire commentaire) {
		
		getDaoFactory().getCommentaireDao().updateCommentaire(commentaire);
		
	}


}
