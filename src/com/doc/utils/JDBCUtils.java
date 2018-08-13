package com.doc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtils {
	/**
	 * 关闭资源：查询后关闭，增加、修改、删除后关闭
	 */
	public static void release(Statement stmt, Connection conn) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			stmt = null;
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			conn = null;
		}
	}

	public static void release(ResultSet rs, Statement stmt, Connection conn) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			rs = null;
		}
		release(stmt, conn);
	}

	/**
	 * 建立连接
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		// 加载配置文件
		ResourceBundle bundle = ResourceBundle.getBundle("dbconfig");
		String driverClass = bundle.getString("driverClass");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String pwd = bundle.getString("pwd");
		// 加载驱动
		Class.forName(driverClass);
		// 建立连接
		Connection conn = DriverManager.getConnection(url, user, pwd);
		return conn;
	}
	public static void main(String[] args) {
		try {
			System.out.println(JDBCUtils.getConnection());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
