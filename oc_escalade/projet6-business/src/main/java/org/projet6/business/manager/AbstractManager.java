package org.projet6.business.manager;


import org.projet6.consumer.contract.DaoFactory;

import org.springframework.transaction.PlatformTransactionManager;



public abstract class AbstractManager {

	private DaoFactory daoFactory;
	
	private	PlatformTransactionManager platformTransactionManager;
	
	public DaoFactory getDaoFactory() {
		return daoFactory;
	}
	
	public void setDaoFactory(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	
    public PlatformTransactionManager getPlatformTransactionManager() {
		return platformTransactionManager;
	}

	public void setPlatformTransactionManager(PlatformTransactionManager platformTransactionManager) {
		this.platformTransactionManager = platformTransactionManager;
	}

	
}