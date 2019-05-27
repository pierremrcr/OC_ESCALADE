package org.projet6.business.manager;

import java.util.List;

import org.projet6.model.bean.Commentaire;

public interface CommentaireTopoManager {
	

	List<Commentaire> getListCommentaireTopo();
	
	Commentaire getCommentaireTopo(int id);
	
	List<Commentaire> getListCommentaireByTopoId(int id);
	
	void ajoutCommentaireTopo(Commentaire commentaire, int topoId);
	
	void updateCommentaire(Commentaire commentaireTopo);
	
	void deleteCommentaireTopo(int id);
	
	void deleteCommentaireByTopo(int id);
	
	void deleteCommentaireByUser(int id);
	

}
