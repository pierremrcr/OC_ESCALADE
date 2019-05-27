package org.projet6.business.managerImpl;

import java.util.List;

import org.projet6.business.manager.AbstractManager;
import org.projet6.business.manager.LongueurManager;
import org.projet6.model.bean.Longueur;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

public class LongueurManagerImpl extends AbstractManager implements LongueurManager {

	public List<Longueur> getListeLongueur() {

		List<Longueur> listeLongueur = getDaoFactory().getLongueurDao().listeLongueur();

		return listeLongueur;
		
	}

	public Longueur getLongueurByID(int id) {

		Longueur longueur = getDaoFactory().getLongueurDao().getByID(id);

		return longueur;
	}

	@Transactional(value = "txManager")
	public void ajoutLongueur(final Longueur longueur, final int voieId) {

		TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());

		vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {

				getDaoFactory().getLongueurDao().create(longueur, voieId);

			}
		});

	}

	public void deleteLongueur(int id) {
		
		getDaoFactory().getLongueurDao().supprimeLongueur(id);
		
	}

	public void updateLongueur(Longueur longueur) {
		
		getDaoFactory().getLongueurDao().updateLongueur(longueur);
		
	}

}
