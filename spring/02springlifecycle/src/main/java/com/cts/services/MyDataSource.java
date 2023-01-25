package com.cts.services;

public class MyDataSource {
	String dbUrl;
	String dbPort;
	String dbUser;
	@Override
	public String toString() {
		return "MyDataSource [dbUrl=" + dbUrl + ", dbPort=" + dbPort + ", dbUser=" + dbUser + "]";
	}
	public String getDbUrl() {
		return dbUrl;
	}
	public void setDbUrl(String dbUrl) {
		this.dbUrl = dbUrl;
	}
	public String getDbPort() {
		return dbPort;
	}
	public void setDbPort(String dbPort) {
		this.dbPort = dbPort;
	}
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	
	

}
