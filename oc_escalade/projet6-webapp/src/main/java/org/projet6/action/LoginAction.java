package org.projet6.action;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.interceptor.SessionAware;
import org.projet6.model.bean.Utilisateur;

import com.opensymphony.xwork2.ActionSupport;



public class LoginAction extends ActionSupport implements SessionAware {
	

    private Map<String, Object> session;
    
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }
    
    private String adresseMail;
    
    private String password;
    
    
    public String getAdresseMail() {
        return adresseMail;
    }
    
    public void setAdresseMail(String adresseMail) {
        this.adresseMail = adresseMail;
    }
    
    
    public String getPassword() {
        return password;
    }
    
    public void setPassword(String pPassword) {
        password = pPassword;
    }
    
  
    public String doLogin() {

        String vResult = ActionSupport.INPUT;
        
        if (!StringUtils.isAllEmpty(adresseMail, password)) {
            
        	try {
                Utilisateur vUtilisateur
                        = WebappHelper.getManagerFactory().getUtilisateurManager()
                                      .getUtilisateur(adresseMail, password);
                
                // Ajout de l'utilisateur en session
                this.session.put("user", vUtilisateur);
                
                vResult = ActionSupport.SUCCESS;
            } catch (Exception e) {
                this.addActionError("Identifiant ou mot de passe invalide !");
            }
        }
        return vResult;
    }


   
    public String doLogout() {
    	
        this.session.remove("user");
        return ActionSupport.SUCCESS;
    }
    
}
    