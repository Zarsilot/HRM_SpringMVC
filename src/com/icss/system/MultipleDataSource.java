package com.icss.system;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/*
 * 
 * 2016-09-12
 */
public class MultipleDataSource extends AbstractRoutingDataSource{
	private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<>();
	
	
	public static void setDataSourceKey(String dataSource){
		dataSourceKey.set(dataSource);
	}

	@Override
	protected Object determineCurrentLookupKey() {
		// TODO Auto-generated method stub
		return dataSourceKey.get();
	}

}
