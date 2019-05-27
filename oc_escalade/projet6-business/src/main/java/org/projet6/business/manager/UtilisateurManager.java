package org.projet6.business.manager;

import java.util.List;

import org.projet6.model.bean.Utilisateur;

public interface UtilisateurManager {
	
	// Renvoie la liste des utilisateurs

	List<Utilisateur> getListUtilisateur();
	
	// Renvoie Renvoie l'utilisateur demandé en fonction de son ID
	
	Utilisateur getUtilisateur(int id);
	
	// Renvoie l'utilisateur correspondant au couple login / mot de passe
	
	Utilisateur getUtilisateur(String adresseMail, String password) /*throws NotFoundException*/;

	// Ajoute un nouvel utilisateur
	
	void ajoutUtilisateur(Utilisateur utilisateur);
	
	void deleteUtilisateur(int id);
	
	void updateUtilisateur(Utilisateur utilisateur);
	
	
}