package org.projet6.business.managerImpl;

import java.util.List;



import org.projet6.business.manager.AbstractManager;
import org.projet6.business.manager.AdresseManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;
import org.projet6.model.bean.Adresse;


public class AdresseManagerImpl extends AbstractManager implements AdresseManager {

	public List<Adresse> getListAdresse() {
		
		List<Adresse> listeAdresses = getDaoFactory().getAdresseDao().listadresse();
		
		return listeAdresses;
	}
	

	
	
	public Adresse getAdresse(int id) {
		
		Adresse adresse = getDaoFactory().getAdresseDao().getAdresseByID(id);
		return adresse;
	}

	@Transactional(value = "txManager")
	public void ajoutAdresse(final Adresse adresse) {
		
		TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());

		vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {

				getDaoFactory().getAdresseDao().create(adresse);
		}
			
	});
		
		
}
	@Transactional(value = "txManager")
	public void updateAdresse(final Adresse adresse) {
	  
	  TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());
	  
    vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {
      
    @Override
    protected void doInTransactionWithoutResult(TransactionStatus status) {
		
		getDaoFactory().getAdresseDao().updateAdresse(adresse);
		
    }
    
    });
            
  }

	public void deleteAdresse(int id) {
		
		getDaoFactory().getAdresseDao().supprimeAdresse(id);
		
	}

}