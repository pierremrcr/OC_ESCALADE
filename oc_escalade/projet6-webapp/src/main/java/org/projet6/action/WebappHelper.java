package org.projet6.action;

import org.projet6.business.manager.*;


public abstract class WebappHelper {
	
	private static ManagerFactory managerFactory;
	
	public static ManagerFactory getManagerFactory() {
	        return managerFactory;
	    }
	
     public static void setManagerFactory(ManagerFactory pManagerFactory) {
	        managerFactory = pManagerFactory;
	    }

}

