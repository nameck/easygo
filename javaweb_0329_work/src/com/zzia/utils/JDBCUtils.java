package com.zzia.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//存放工具类的包
public class JDBCUtils {
	public static Connection connection = null;
	private static String url = "jdbc:mysql://localhost:3306/0329work?characterEncoding=utf8&useSSL=true";
	private static String user = "root";
	private static String password = "";
	//获取数据库连接
	public static Connection getConnection() {
		try {
			connection = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}
	//关闭数据库
	public static void close(ResultSet resultSet,Statement statement,Connection connection) {
		try {
			if(resultSet !=null){
			resultSet.close();
			}
			if(statement != null){
				statement.close();
			}
			if(connection != null){
				connection.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
