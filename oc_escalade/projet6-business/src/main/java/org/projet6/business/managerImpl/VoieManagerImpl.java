package org.projet6.business.managerImpl;

import java.util.List;

import org.projet6.business.manager.AbstractManager;
import org.projet6.business.manager.VoieManager;
import org.projet6.model.bean.Voie;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;



public class VoieManagerImpl extends AbstractManager implements VoieManager {

	public List<Voie> getListeVoie() {
		
		List<Voie> listeVoie = getDaoFactory().getVoieDao().listeVoie();
		
		return listeVoie;
	}

	public Voie getVoiebyId(int id) {
		
		Voie voie = getDaoFactory().getVoieDao().getByID(id);
		
		return voie;
	}

	@Transactional(value = "txManager")
	public void ajoutVoie(final Voie voie, final int secteurId) {

		TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());

		vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {

				getDaoFactory().getVoieDao().create(voie, secteurId);

			}

		});

	}
	

	public void updateVoie(Voie voie) {
		
		getDaoFactory().getVoieDao().updateVoie(voie);
		
	}

	public void deleteVoie(int id) {
		
		getDaoFactory().getVoieDao().supprimeVoie(id);
		
	}

}
