package org.projet6.consumer.Impl;

import javax.sql.DataSource;

public abstract class AbstractDaoImpl {
	
	private static DataSource dataSource;

	protected DataSource getDataSource() {
		return dataSource;
	}

	public static void setDataSource(DataSource dataSource) {
		AbstractDaoImpl.dataSource = dataSource;
	}
		
	
}