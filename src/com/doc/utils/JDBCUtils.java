package com.doc.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

public class JDBCUtils {
	/**
	 * �ر���Դ����ѯ��رգ����ӡ��޸ġ�ɾ����ر�
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
	 * ��������
	 * 
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public static Connection getConnection() throws SQLException,
			ClassNotFoundException {
		// ���������ļ�
		ResourceBundle bundle = ResourceBundle.getBundle("dbconfig");
		String driverClass = bundle.getString("driverClass");
		String url = bundle.getString("url");
		String user = bundle.getString("user");
		String pwd = bundle.getString("pwd");
		// ��������
		Class.forName(driverClass);
		// ��������
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
