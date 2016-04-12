package zzia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import zzia.utils.JDBCUtils;

public class Test {
	static Connection connection = null;
	static PreparedStatement statement = null;

	public static void insertData1() {
		connection = JDBCUtils.getConnection();
		String sql = "insert into Student(name,gender,age,major)values(?,?,?,?)";
		try {
			statement = connection.prepareStatement(sql);
			long start = System.currentTimeMillis();// 开始插入数据的时间
			for (int i = 1; i <= 100; i++) {
				statement.setString(1, "name" + i);
				statement.setString(2, "男");
				statement.setInt(3, i);
				statement.setString(4, "major" + i);
				statement.executeUpdate();
			}
			long end = System.currentTimeMillis();// 插入数据结束后的时间
			System.out.println("普通方法耗时：" + (end - start));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, statement, connection);
		}
	}

	public static void insertData2() {
		connection = JDBCUtils.getConnection();
		String sql = "insert into Student(name,gender,age,major)values(?,?,?,?)";
		try {
			statement = connection.prepareStatement(sql);
			long start = System.currentTimeMillis();// 开始插入数据的时间
			for (int i = 1; i <= 100; i++) {
				statement.setString(1, "name" + i);
				statement.setString(2, "男");
				statement.setInt(3, i);
				statement.setString(4, "major" + i);

				statement.addBatch();

			}
			statement.executeBatch();
			long end = System.currentTimeMillis();// 插入数据结束后的时间
			System.out.println("批处理方法耗时：" + (end - start));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, statement, connection);
		}
	}
	public static void insertData3() {
		connection = JDBCUtils.getConnection();
		String sql = "insert into Student(name,gender,age,major)values(?,?,?,?)";
		try {
			statement = connection.prepareStatement(sql);
			long start = System.currentTimeMillis();// 开始插入数据的时间
			for (int i = 1; i <= 100; i++) {
				statement.setString(1, "name" + i);
				if(i==5){
					statement.setString(2, "性别：男");
				}else if(i%2==0){
					statement.setString(2, "男");
				}else {
					statement.setString(2, "女");
				}
				
				statement.setInt(3, i);
				statement.setString(4, "major" + i);

				statement.addBatch();

			}
			statement.executeBatch();
			long end = System.currentTimeMillis();// 插入数据结束后的时间
			System.out.println("批处理方法耗时：" + (end - start));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, statement, connection);
		}
	}
	public static void insertData4() {
		connection = JDBCUtils.getConnection();
		String sql = "insert into Student(name,gender,age,major)values(?,?,?,?)";
		try {
			statement = connection.prepareStatement(sql);
			long start = System.currentTimeMillis();// 开始插入数据的时间
			for (int i = 1; i <= 100; i++) {
				statement.setString(1, "name" + i);
				if(i==5){
					statement.setString(2, "性别：男");
				}else if(i%2==0){
					statement.setString(2, "男");
				}else {
					statement.setString(2, "女");
				}
				statement.setInt(3, i);
				statement.setString(4, "major" + i);
				statement.executeUpdate();
			}
			long end = System.currentTimeMillis();// 插入数据结束后的时间
			System.out.println("普通方法耗时：" + (end - start));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JDBCUtils.close(null, statement, connection);
		}
	}
	public static void insertData5() {
		
		try {
			//禁止系统自动提交
			connection.setAutoCommit(false);
			connection = JDBCUtils.getConnection();
			String sql = "insert into Student(name,gender,age,major)values(?,?,?,?)";
			statement = connection.prepareStatement(sql);
			
			for (int i = 1; i <= 100; i++) {
				statement.setString(1, "name" + i);
				if(i==5){
					statement.setString(2, "性别：男");
				}else if(i%2==0){
					statement.setString(2, "男");
				}else {
					statement.setString(2, "女");
				}
				statement.setInt(3, i);
				statement.setString(4, "major" + i);
				statement.executeUpdate();
			}
			//如果可以执行完成for循环，则表示正常执行，可以提交执行结果
			connection.commit();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			//产生异常，说明数据没有全部插入工程，回滚，返回到之前的状态
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		} finally {
			JDBCUtils.close(null, statement, connection);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//insertData1();
		//insertData2();
		//insertData3();
		//insertData4();
		insertData5();
	}

}
