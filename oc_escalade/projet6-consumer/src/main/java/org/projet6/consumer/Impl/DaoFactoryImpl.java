package org.projet6.consumer.Impl;

import org.projet6.consumer.contract.AdresseDao;
import org.projet6.consumer.contract.CommentaireDao;
import org.projet6.consumer.contract.CommentaireTopoDao;
import org.projet6.consumer.contract.DaoFactory;
import org.projet6.consumer.contract.LongueurDao;
import org.projet6.consumer.contract.ReservationDao;
import org.projet6.consumer.contract.SecteurDao;
import org.projet6.consumer.contract.SpotDao;
import org.projet6.consumer.contract.TopoDao;
import org.projet6.consumer.contract.UtilisateurDao;
import org.projet6.consumer.contract.VoieDao;

public class DaoFactoryImpl implements DaoFactory {
	
	private AdresseDao adresseDao;
	
	private SpotDao spotDao;
	
	private CommentaireDao commentaireDao;
	
	private LongueurDao longueurDao;
	
	private ReservationDao reservationDao;
	
	private SecteurDao secteurDao;
	
	private UtilisateurDao utilisateurDao;
	
	private VoieDao voieDao;
	
	private TopoDao topoDao;
	
	private CommentaireTopoDao commentaireTopoDao;
	

	public UtilisateurDao getUtilisateurDao() {
		
		return utilisateurDao;
	}

	public SpotDao getSpotDao() {
		
		return spotDao;
	}

	public SecteurDao getSecteurDao() {
		
		return secteurDao;
	}

	public AdresseDao getAdresseDao() {
		
		return adresseDao;
	}

	public VoieDao getVoieDao() {
		
		return voieDao;
	}

	public LongueurDao getLongueurDao() {

		return longueurDao;
	}

	public CommentaireDao getCommentaireDao() {
		
		return commentaireDao;
	}

	public TopoDao getTopoDao() {
		
		return topoDao;
	}

	public ReservationDao getReservationDao() {
		
		return reservationDao;
	}

	public void setAdresseDao(AdresseDao adresseDao) {
		this.adresseDao = adresseDao;
	}

	public void setSpotDao(SpotDao spotDao) {
		this.spotDao = spotDao;
	}

	public void setCommentaireDao(CommentaireDao commentaireDao) {
		this.commentaireDao = commentaireDao;
	}

	public void setLongueurDao(LongueurDao longueurDao) {
		this.longueurDao = longueurDao;
	}

	public void setReservationDao(ReservationDao reservationDao) {
		this.reservationDao = reservationDao;
	}

	public void setSecteurDao(SecteurDao secteurDao) {
		this.secteurDao = secteurDao;
	}

	public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
		this.utilisateurDao = utilisateurDao;
	}

	public void setVoieDao(VoieDao voieDao) {
		this.voieDao = voieDao;
	}

	public void setTopoDao(TopoDao topoDao) {
		this.topoDao = topoDao;
	}

	public CommentaireTopoDao getCommentaireTopoDao() {
		return commentaireTopoDao;
	}

	public void setCommentaireTopoDao(CommentaireTopoDao commentaireTopoDao) {
		this.commentaireTopoDao = commentaireTopoDao;
	}
	
	

}
