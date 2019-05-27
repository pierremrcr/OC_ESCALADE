package org.projet6.business.managerImpl;

public class NotFoundException extends Exception {
	
	public NotFoundException() {
		super("Aucun utilisateur correspondant au couple login / password fourni");
	}

}
