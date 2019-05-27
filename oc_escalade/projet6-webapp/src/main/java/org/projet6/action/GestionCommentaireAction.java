//package org.projet6.action;
//
//import java.util.List;
//import java.util.Map;
//
//import org.apache.struts2.interceptor.SessionAware;
//import org.projet6.model.bean.Commentaire;
//import org.projet6.model.bean.Spot;
//import org.projet6.model.bean.Topo;
//import org.projet6.model.bean.Utilisateur;
//
//import com.opensymphony.xwork2.ActionSupport;
//
//public class GestionCommentaireAction extends ActionSupport implements SessionAware {
//	
//	private Integer id;
//	
//	private Commentaire commentaire;
//	
//	private List<Commentaire> listeCommentaire;
//	
//	private int spotId;
//	
//	private List<Spot> listeSpot;
//	
//	private Map<String, Object> session;
//	
//	
//
//	public Integer getId() {
//		return id;
//	}
//
//	
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public Commentaire getCommentaire() {
//		return commentaire;
//	}
//
//	public void setCommentaire(Commentaire commentaire) {
//		this.commentaire = commentaire;
//	}
//
//	public List<Commentaire> getListeCommentaire() {
//		return listeCommentaire;
//	}
//
//	public void setListeCommentaire(List<Commentaire> listeCommentaire) {
//		this.listeCommentaire = listeCommentaire;
//	}
//	
//	
//	public int getSpotId() {
//		return spotId;
//	}
//
//
//	public void setSpotId(int spotId) {
//		this.spotId = spotId;
//	}
//
//
//	public List<Spot> getListeSpot() {
//		return listeSpot;
//	}
//
//
//	public void setListeSpot(List<Spot> listeSpot) {
//		this.listeSpot = listeSpot;
//	}
//
//
//	public Map<String, Object> getSession() {
//		return session;
//	}
//	
//	public void setSession(Map<String, Object> session) {
//		this.session = session;
//	}
//
//
//	public String doList() {
//		
//		listeCommentaire = WebappHelper.getManagerFactory().getCommentaireManager().getListCommentaire();
//		
//		return ActionSupport.SUCCESS;
//	}
//	
//	
//	
//	public String doDetail() {
//		if (id == null) {
//			this.addActionError("Vous devez indiquer un id");
//		} else {
//			//try {
//			commentaire = WebappHelper.getManagerFactory().getCommentaireManager().getCommentaire(id);
//			//} catch (NotFoundException pE) {
//				//this.addActionError("Utilisateur non trouvé. id = " + id);
//			//}
//			
//		}
//		
//		return (this.hasErrors()) ? ActionSupport.ERROR :ActionSupport.SUCCESS;
//	
//	}
//	
//	public String doCreate() {
//
//		String vResult = ActionSupport.INPUT;
//
//		if (this.commentaire != null) {
//
//			if (commentaire.getContenu() == null)  {
//				this.addActionError("Vous devez indiquer une description");
//			}
//			
//			if (commentaire.getDate() == null) {
//				this.addActionError("Vous devez indiquer une date");
//			}
//
//			if (!this.hasErrors()) {
//				try {
//					Utilisateur utilisateurEnSession = (Utilisateur) this.session.get("user");
//					System.out.println(utilisateurEnSession.getId());
//					commentaire.setUtilisateur(utilisateurEnSession);
//					WebappHelper.getManagerFactory().getCommentaireManager().ajoutCommentaire(commentaire, spotId);
//					vResult = ActionSupport.SUCCESS;
//					this.addActionMessage("Création d'un nouveau commentaire");
//				} catch (Exception e) {
//					System.out.println(e.getMessage());
//				}
//			}
//
//		}
//		
//		return vResult;
//
//	}
//	
//
//
//	
//
//}
