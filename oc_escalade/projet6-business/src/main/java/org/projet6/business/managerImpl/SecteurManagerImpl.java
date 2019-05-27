

package org.projet6.business.managerImpl;

import java.util.List;

import org.projet6.business.manager.AbstractManager;
import org.projet6.business.manager.SecteurManager;
import org.projet6.model.bean.Secteur;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;



public class SecteurManagerImpl extends AbstractManager implements SecteurManager {
	
	public List<Secteur> getListSecteur() {
		
		List<Secteur> listeSecteur = getDaoFactory().getSecteurDao().listsecteur();
		
		return listeSecteur;
				
	}
	
	
	public Secteur getSecteur(int id) {
		
		Secteur secteur = getDaoFactory().getSecteurDao().getbyID(id);
		
		return secteur;
	}

	@Transactional(value="txManager")
	public void ajoutSecteur(final Secteur secteur, final int spotId) {
	
		TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());
		
		vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				
				getDaoFactory().getSecteurDao().create(secteur, spotId);
			}
		});
		
	}
	
	


	public List<Secteur> listeSecteurBySpot(int id) {
		
		List<Secteur> listeSecteur = getDaoFactory().getSecteurDao().listSecteurBySpotID(id);
		
		return listeSecteur;
	}


	public void deleteSecteur(int id) {
		
		getDaoFactory().getSecteurDao().supprimeSecteur(id);
		
	}


	public void updateSecteur(Secteur secteur) {
		
		getDaoFactory().getSecteurDao().updateSecteur(secteur);
		
	}
}




