package zzia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PrepareStatementDemo {
	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet resultSet = null;

	// 查
	private static void adjustUser() {
		connection = JDBCUtils.getConnection();
		try {
			statement = connection
					.prepareStatement("select * from user where username=? and password=?;");
			// 查询是否存在用户名为a,密码为b的用户
			// 数据库注入？如果是静态数据，那么不能解决，如果是动态数据呢
			statement.setString(1, "a");
			statement.setString(2, "b or (1=1)");
			resultSet = statement.executeQuery();
			if (resultSet.next()) {
				System.out.println("用户存在");
				String name = resultSet.getString(2);
				String password = resultSet.getString(3);
				System.out.println(name + "-->" + password);
			} else {
				System.out.println("用户不存在");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, statement, connection);
		}
	}

	// 增
	private static void insertUser() {
		connection = JDBCUtils.getConnection();
		try {
			statement = connection
					.prepareStatement("insert into user (username,password) values(?,?);");
			statement.setString(1, "m");
			statement.setString(2, "m");
			int count = statement.executeUpdate();
			System.out.println("数据插入成功");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, statement, connection);
		}

	}

	// 删
	private static void deletetUser() {
		connection = JDBCUtils.getConnection();
		try {
			statement = connection
					.prepareStatement("delete from user where username=?;");
			statement.setString(1, "m");
			int count = statement.executeUpdate();
			System.out.println("数据删除成功" + "；受影响的行数为" + count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, statement, connection);
		}

	}

	// 改
	private static void updateUser() {
		connection = JDBCUtils.getConnection();
		try {
			statement = connection
					.prepareStatement("update user set password= ? where id>?;");
			statement.setString(1, "gggg");
			statement.setInt(2, 5);
			int count = statement.executeUpdate();
			System.out.println("数据修改成功" + "；受影响的行数为" + count);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(resultSet, statement, connection);
		}

	}

	public static void main(String[] args) {
		// adjustUser();
		// insertUser();
		deletetUser();
		//updateUser();

	}

}
