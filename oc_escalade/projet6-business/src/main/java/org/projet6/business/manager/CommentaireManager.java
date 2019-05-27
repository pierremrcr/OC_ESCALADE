package org.projet6.business.manager;

import java.util.List;

import org.projet6.model.bean.Commentaire;

public interface CommentaireManager {
	
	List<Commentaire> getListCommentaire();
	
	Commentaire getCommentaire(int id);
	
	List<Commentaire> getListCommentaireSpot(int id);
	
	void ajoutCommentaire(Commentaire commentaire, int spotId);
	
	void updateCommentaire(Commentaire commentaire);
	
	void deleteCommentaire(int id);
	
	void deleteCommentaireBySpot(int id);
	
	void deleteCommentaireByUser(int id);
	
	
}
