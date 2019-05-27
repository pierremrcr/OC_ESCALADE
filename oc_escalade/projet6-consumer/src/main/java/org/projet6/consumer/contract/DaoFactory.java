package org.projet6.consumer.contract;


public interface DaoFactory {
	
	UtilisateurDao getUtilisateurDao();
	
	SpotDao getSpotDao();
	
	SecteurDao getSecteurDao();
	
	AdresseDao getAdresseDao();
	
	VoieDao getVoieDao();
	
	LongueurDao getLongueurDao();
	
	CommentaireDao getCommentaireDao();
	
	TopoDao getTopoDao();
	
	ReservationDao getReservationDao();
	
	CommentaireTopoDao getCommentaireTopoDao();
	
		

}
