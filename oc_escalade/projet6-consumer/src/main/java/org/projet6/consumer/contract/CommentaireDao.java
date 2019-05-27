package org.projet6.consumer.contract;

import java.util.List;

import org.projet6.model.bean.Commentaire;


public interface CommentaireDao {
	
	public Commentaire getCommentaireByID(int id);
	
	public Commentaire ajoutCommentaireBySpotId(Commentaire commentaire, int spotId);
	
	public List<Commentaire> listeCommentaire();
	
	public void supprimeCommentaire(int id);
	
	public List<Commentaire> getCommentaireBySpot(int id);
	
	public void deleteCommentaireByUser(int utilisateurId);
	
	public void deleteCommentaireBySpot(int spotId);
	
	public void updateCommentaire(Commentaire commentaire);
	
	//public Commentaire create(Commentaire commentaire);

	
	
}
