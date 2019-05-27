package org.projet6.business.managerImpl;

import org.projet6.business.manager.AdresseManager;
import org.projet6.business.manager.CommentaireManager;
import org.projet6.business.manager.CommentaireTopoManager;
import org.projet6.business.manager.LongueurManager;
import org.projet6.business.manager.ManagerFactory;
import org.projet6.business.manager.ReservationManager;
import org.projet6.business.manager.SecteurManager;
import org.projet6.business.manager.SpotManager;
import org.projet6.business.manager.TopoManager;
import org.projet6.business.manager.UtilisateurManager;
import org.projet6.business.manager.VoieManager;


public class ManagerFactoryImpl implements ManagerFactory {

	private UtilisateurManager utilisateurManager;

	private SpotManager spotManager;
	
	private AdresseManager adresseManager;
	
	private CommentaireManager commentaireManager;
	
	private SecteurManager secteurManager;
	
	private TopoManager topoManager;
	
	private VoieManager voieManager;
	
	private LongueurManager longueurManager;
	
	private ReservationManager reservationManager;
	
	private CommentaireTopoManager commentaireTopoManager;
	
	

	public SpotManager getSpotManager() {
		return spotManager;
	}

	public void setSpotManager(SpotManager spotManager) {
		this.spotManager = spotManager;
	}

	public UtilisateurManager getUtilisateurManager() {
		return utilisateurManager;
	}

	public void setUtilisateurManager(UtilisateurManager utilisateurManager) {
		this.utilisateurManager = utilisateurManager;
	}

	public AdresseManager getAdresseManager() {
		return adresseManager;
	}

	public void setAdresseManager(AdresseManager adresseManager) {
		this.adresseManager = adresseManager;
		
	}

	public CommentaireManager getCommentaireManager() {
		return commentaireManager;
	}

	public void setCommentaireManager(CommentaireManager commentaireManager) {
		this.commentaireManager = commentaireManager;
		
	}

	public SecteurManager getSecteurManager() {
		return secteurManager;
	}

	public void setSecteurManager(SecteurManager secteurManager) {
		this.secteurManager = secteurManager;
		
	}

	public VoieManager getVoieManager() {
		return voieManager;
	}

	public void setVoieManager(VoieManager voieManager) {
		this.voieManager = voieManager;
		
	}

	public TopoManager getTopoManager() {
		return topoManager;
	}

	public void setTopoManager(TopoManager topoManager) {
		this.topoManager = topoManager;
		
	}

	public LongueurManager getLongueurManager() {
		return longueurManager;
	}

	public void setLongueurManager(LongueurManager longueurManager) {
		this.longueurManager = longueurManager;
		
	}

	public ReservationManager getReservationManager() {
		return reservationManager;
	}

	public void setReservationManager(ReservationManager reservationManager) {
		this.reservationManager = reservationManager;
		
	}

	public CommentaireTopoManager getCommentaireTopoManager() {
		return commentaireTopoManager;
	}

	public void setCommentaireTopoManager(CommentaireTopoManager commentaireTopoManager) {
		this.commentaireTopoManager = commentaireTopoManager;
		
	}



}