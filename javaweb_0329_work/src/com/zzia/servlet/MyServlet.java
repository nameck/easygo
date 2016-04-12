package com.zzia.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.zzia.utils.JDBCUtils;
//11111222
public class MyServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MyServlet() {
		super();
	}

	
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		Connection connection =JDBCUtils.getConnection();
		PreparedStatement statement=null;
		ResultSet resultSet = null;
		String sql = "select *from users where username=? and password=?";
		try {
			statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			resultSet = statement.executeQuery();
			if(resultSet.next()){
				System.out.println("查到此人");
				
			}else {
				System.out.println("没查到此人");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}finally{
			JDBCUtils.close(resultSet, statement, connection);
		}
		
		System.out.println(username+";"+password);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
