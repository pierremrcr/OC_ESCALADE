package org.projet6.consumer.contract;

import java.util.List;

import org.projet6.model.bean.Utilisateur;

public interface UtilisateurDao {

    
    public List<Utilisateur> listutilisateur();
    
    public Utilisateur getbyID(int id);
    
    public Utilisateur getbyPassword(String adresseMail, String motdepasse);
    
    public void supprimeUtilisateur(int Id);
    
    public Utilisateur create(Utilisateur utilisateur);
    
    public void updateUtilisateur(Utilisateur utilisateur);
    
    
        
    
}