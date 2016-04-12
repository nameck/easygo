package com.zzia.util;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3P0Util {
	private static ComboPooledDataSource cpds = null;
	private static Connection connection = null;
	//C3P0数据库连接池只需要初始化一次
	static{
		cpds = new ComboPooledDataSource();
		try {
			cpds.setDriverClass( "com.mysql.jdbc.Driver" );
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} //loads the jdbc driver            
		cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/0408work?characterEncoding=utf8&useSSL=true" );
		cpds.setUser("root");                                  
		cpds.setPassword(""); 
	}
	
	//获取数据库连接对象
	public static Connection getConnection(){
		try {
			connection = cpds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	
	//关闭数据库连接
	public static void close(ResultSet resultSet, Statement statement,Connection connection){
		try {
			if (resultSet != null) {
				resultSet.close();
			}
			if (statement != null) {
				statement.close();
			}
			if (connection != null) {
				connection.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
