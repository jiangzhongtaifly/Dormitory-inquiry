package com.doc.utils;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class TestConnection {
	@Test
	public void testCon() {
		Connection conn=null;
		try {
			conn = JDBCUtils.getConnection();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(conn);
	}
}
