//package org.projet6.action;
//
//import java.util.List;
//import java.util.Map;
//
//import org.apache.struts2.interceptor.SessionAware;
//import org.projet6.model.bean.CommentaireTopo;
//import org.projet6.model.bean.Topo;
//import org.projet6.model.bean.Utilisateur;
//
//import com.opensymphony.xwork2.ActionSupport;
//
//public class GestionCommentaireTopoAction extends ActionSupport implements SessionAware {
//
//	private Integer id;
//
//	private CommentaireTopo commentaireTopo = new CommentaireTopo();
//
//	private List<CommentaireTopo> listeCommentaireTopo;
//
//	private int topoId;
//
//	private List<Topo> listeTopo;
//
//	private Map<String, Object> session;
//
//	public Integer getId() {
//		return id;
//	}
//
//	public void setId(Integer id) {
//		this.id = id;
//	}
//
//	public CommentaireTopo getCommentaireTopo() {
//		return commentaireTopo;
//	}
//
//	public void setCommentaireTopo(CommentaireTopo commentaireTopo) {
//		this.commentaireTopo = commentaireTopo;
//	}
//
//	public List<CommentaireTopo> getListeCommentaireTopo() {
//		return listeCommentaireTopo;
//	}
//
//	public void setListeCommentaireTopo(List<CommentaireTopo> listeCommentaireTopo) {
//		this.listeCommentaireTopo = listeCommentaireTopo;
//	}
//
//	
//	public int getTopoId() {
//		return topoId;
//	}
//
//	public void setTopoId(int topoId) {
//		this.topoId = topoId;
//	}
//
//	public List<Topo> getListeTopo() {
//		return listeTopo;
//	}
//
//	public void setListeTopo(List<Topo> listeTopo) {
//		this.listeTopo = listeTopo;
//	}
//
//	public Map<String, Object> getSession() {
//		return session;
//	}
//
//	public void setSession(Map<String, Object> session) {
//		this.session = session;
//	}
//
//	public String doList() {
//
//		listeCommentaireTopo = WebappHelper.getManagerFactory().getCommentaireTopoManager().getListCommentaireTopo();
//
//		return ActionSupport.SUCCESS;
//	}
//	
//	public String doDetail() {
//		
//		if (id == null) {
//			
//			this.addActionError("Vous devez indiquer un id");
//		
//		} else {
//			
//			commentaireTopo = WebappHelper.getManagerFactory().getCommentaireTopoManager().getCommentaireTopo(id);
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
//		if (this.commentaireTopo != null) {
//
//			if (commentaireTopo.getContenu() == null)  {
//				this.addActionError("Vous devez indiquer une description");
//			}
//			
//			if (commentaireTopo.getDate() == null) {
//				this.addActionError("Vous devez indiquer une date");
//			}
//
//			if (!this.hasErrors()) {
//				
//				try {
//					
//					Utilisateur utilisateurEnSession = (Utilisateur) this.session.get("user");
//					System.out.println(utilisateurEnSession.getId());
//					commentaireTopo.setUtilisateur(utilisateurEnSession);
//					WebappHelper.getManagerFactory().getCommentaireTopoManager().ajoutCommentaireTopo(commentaireTopo, topoId);
//					vResult = ActionSupport.SUCCESS;
//					this.addActionMessage("Création d'un nouveau commentaire");
//				
//				} catch (Exception e) {
//					
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
//}
