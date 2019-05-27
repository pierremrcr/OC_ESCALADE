package org.projet6.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.projet6.model.bean.Commentaire;
import org.projet6.model.bean.Spot;
import org.projet6.model.bean.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;

public class GestionSpotAction extends ActionSupport implements SessionAware {

	private Integer id;

	private List<Spot> listeSpots;

	private Spot spot;

	private int spotId;

	private Map<String, Object> session;

	private Commentaire commentaire = new Commentaire();

	private Integer commentaireId;

	public Spot getSpot() {
		return spot;

	}

	public void setSpot(Spot spot) {
		this.spot = spot;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public int getSpotId() {
		return spotId;
	}

	public void setSpotId(int spotId) {
		this.spotId = spotId;
	}

	public List<Spot> getListeSpots() {

		return listeSpots;
	}

	public void setListeSpots(List<Spot> listeSpots) {
		this.listeSpots = listeSpots;
	}

	public Commentaire getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}

	public Map<String, Object> getSession() {
		return session;
	}

	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

	public Integer getCommentaireId() {
		return commentaireId;
	}

	public void setCommentaireId(Integer commentaireId) {
		this.commentaireId = commentaireId;
	}

	public String doList() {

		listeSpots = WebappHelper.getManagerFactory().getSpotManager().getListSpot();

		return ActionSupport.SUCCESS;

	}

	public String doDetail() {

		if (id == null) {
			this.addActionError("Vous devez indiquer un id");

		} else {
			// try {
			spot = WebappHelper.getManagerFactory().getSpotManager().getSpot(id);
			// } catch (NotFoundException pE) {
			// this.addActionError("Utilisateur non trouvé. id = " + id);
			// }

		}

		return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;

	}

	public String doCreate() {

		String vResult = ActionSupport.INPUT;

		try {

			WebappHelper.getManagerFactory().getSpotManager().ajoutSpot(spot);
			spotId = spot.getId();
			vResult = ActionSupport.SUCCESS;
			this.addActionMessage("Création d'un nouveau spot");

		} catch (Exception e) {
			System.out.println(e.getMessage());

		}

		return vResult;

	}

	public String doAddComment() {
		// On récupère l'utilisateur en session
		Utilisateur utilisateurEnSession = (Utilisateur) this.session.get("user");
		// Pour en récupérer l'id
		commentaire.setUtilisateur(utilisateurEnSession);
		//
		// logger.info(commentaire.getId()+" "+commentaire.getContenu()+" id = " + id);
		WebappHelper.getManagerFactory().getCommentaireManager().ajoutCommentaire(commentaire, id);

		return ActionSupport.SUCCESS;
	}

	public String doDelete() {

		String vResult = ActionSupport.INPUT;

		if (id == null) {
			vResult = ActionSupport.INPUT;
		}

		else {

			WebappHelper.getManagerFactory().getSpotManager().deleteSpot(id);

			vResult = ActionSupport.SUCCESS;
		}

		return vResult;
	}

	public String doDeleteComment() {

		String vResult = ActionSupport.INPUT;

		if (commentaireId == null) {

			vResult = ActionSupport.INPUT;
		}

		else {

			WebappHelper.getManagerFactory().getCommentaireManager().deleteCommentaire(commentaireId);

			vResult = ActionSupport.SUCCESS;
		}

		return vResult;
	}

}