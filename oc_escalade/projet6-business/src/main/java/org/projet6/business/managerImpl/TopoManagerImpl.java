package org.projet6.business.managerImpl;

import java.util.List;

import org.projet6.business.manager.AbstractManager;
import org.projet6.business.manager.TopoManager;
import org.projet6.model.bean.Commentaire;
import org.projet6.model.bean.Topo;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;


public class TopoManagerImpl extends AbstractManager implements TopoManager {

	public List<Topo> getListeTopo() {
		
		List<Topo> listeTopo = getDaoFactory().getTopoDao().listTopo();
		
		return listeTopo;
	}

	public Topo getTopoById(int id) {
		
		Topo topo = getDaoFactory().getTopoDao().getTopoByID(id);
		
		List<Commentaire> listeCommentairesTopo = getDaoFactory().getCommentaireTopoDao().getCommentaireTopoByTopoID(topo.getId());
		
		topo.setListeCommentaires(listeCommentairesTopo);
		
		return topo;
	}
	

	@Transactional(value = "txManager")
	public void ajoutTopo(final Topo topo) {

		TransactionTemplate vTransactionTemplate = new TransactionTemplate(getPlatformTransactionManager());

		vTransactionTemplate.execute(new TransactionCallbackWithoutResult() {

			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				

				getDaoFactory().getTopoDao().create(topo);

			}
		});

	}
	

	public void deleteTopo(int id) {
		
		getDaoFactory().getTopoDao().supprimeTopo(id);
		
	}

	public void updateTopo(Topo topo) {
		
		getDaoFactory().getTopoDao().updateTopo(topo);
		
	}

}
