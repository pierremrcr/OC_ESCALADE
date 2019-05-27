package org.projet6.business.manager;

public interface ManagerFactory {

	public UtilisateurManager getUtilisateurManager();

	public void setUtilisateurManager(UtilisateurManager utilisateurManager);
	
	public SpotManager getSpotManager();
	
	public void setSpotManager(SpotManager spotManager);
	
	public AdresseManager getAdresseManager();
	
	public void setAdresseManager(AdresseManager adresseManager);
	
	public CommentaireManager getCommentaireManager();
	
	public void setCommentaireManager(CommentaireManager commentaireManager);
	
	public SecteurManager getSecteurManager();
	
	public void setSecteurManager(SecteurManager secteurManager);
	
	public VoieManager getVoieManager();
	
	public void setVoieManager(VoieManager voieManager);
	
	public TopoManager getTopoManager();
	
	public void setTopoManager(TopoManager topoManager);
	
	public LongueurManager getLongueurManager();
	
	public void setLongueurManager(LongueurManager longueurManager);
	
	public ReservationManager getReservationManager();
	
	public void setReservationManager(ReservationManager reservationManager);
	
	public CommentaireTopoManager getCommentaireTopoManager();
	
	public void setCommentaireTopoManager(CommentaireTopoManager commentaireTopoManager);
	


}