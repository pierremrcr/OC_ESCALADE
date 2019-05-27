package org.projet6.business.managerImpl;

import java.util.List;



import org.projet6.business.manager.AbstractManager;
import org.projet6.business.manager.CommentaireTopoManager;
import org.projet6.model.bean.Commentaire;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import java.sql.Timestamp;
import java.time.Instant;

public class CommentaireTopoManagerImpl extends AbstractManager implements CommentaireTopoManager {

	public List<Commentaire> getListCommentaireTopo() {

		List<Commentaire> listeCommentairesTopo = getDaoFactory().getCommentaireTopoDao().listeCommentaireTopo();

		return listeCommentairesTopo;
	}

	public Commentaire getCommentaireTopo(int id) {

		Commentaire commentaireTopo = getDaoFactory().getCommentaireTopoDao().getCommentaireTopoByID(id);

		return commentaireTopo;
	}

	public List<Commentaire> getListCommentaireByTopoId(int id) {

		List<Commentaire> listeCommentairesTopo = getDaoFactory().getCommentaireTopoDao().listeCommentaireTopoByTopoId(id);

		return listeCommentairesTopo;
	}

	@Transactional(value = "txManager")
	public void ajoutCommentaireTopo(final Commentaire commentaireTopo, final int topoId) {

		TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());

		vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {

				commentaireTopo.setDate(Timestamp.from(Instant.now()));
				
				getDaoFactory().getCommentaireTopoDao().ajoutCommentaireTopo(commentaireTopo, topoId);
			}
		});

	}

	

	public void updateCommentaire(Commentaire commentaireTopo) {
		// TODO Auto-generated method stub

	}

	public void deleteCommentaireTopo(int id) {
		// TODO Auto-generated method stub

	}

	public void deleteCommentaireByTopo(int id) {
		// TODO Auto-generated method stub

	}

	public void deleteCommentaireByUser(int id) {
		// TODO Auto-generated method stub

	}


}
