package com.zzia.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.zzia.dao.IGoodDAO;
import com.zzia.model.Good;
import com.zzia.util.C3P0Util;

public class GoodDAOImp implements IGoodDAO {

	@Override
	public List<Good> getAllGood() {
		// 存储查询结果的集合
				List<Good> list = new ArrayList<Good>();
				Connection connection = C3P0Util.getConnection();
				PreparedStatement preparedStatement = null;
				ResultSet resultSet = null;
				String sql = "SELECT name,count,price FROM good;";
				try {
					preparedStatement = connection.prepareStatement(sql);
					// 执行查询操作
					resultSet = preparedStatement.executeQuery();
					while (resultSet.next()) {
						
						String name = resultSet.getString(1);
						int count = resultSet.getInt(2);
						double price = resultSet.getDouble(3);

						Good good = new Good(name,count, price);
						System.out.println(good);
						list.add(good);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					C3P0Util.close(resultSet, preparedStatement, connection);
				}
				return list;
	}

	@Override
	public void updateGood(String name,int count,double price,String updataName) {
		// TODO Auto-generated method stub
		//List<Good> list = new ArrayList<Good>();
		Connection connection = C3P0Util.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "UPDATE good SET name=?,count=?,price=? WHERE name=?;";
		try {
			preparedStatement = connection.prepareStatement(sql);
			// 执行更新操作
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, count);
			preparedStatement.setDouble(3, price);
			preparedStatement.setString(4, updataName);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Util.close(resultSet, preparedStatement, connection);
		}
	}

	@Override
	public void deleteGood(String name) {
		// TODO Auto-generated method stub
		Connection connection = C3P0Util.getConnection();
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "DELETE FROM good WHERE name=?;";
		try {
			preparedStatement = connection.prepareStatement(sql);
			// 执行删除操作
			preparedStatement.setString(1, name);
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			C3P0Util.close(resultSet, preparedStatement, connection);
		}
	}

}
