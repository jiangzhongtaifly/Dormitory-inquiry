package com.doc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doc.domain.Student;
import com.doc.utils.JDBCUtils;

public class DorServlet extends HttpServlet {
	public DorServlet() {
		super();
	}
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("get");
		req.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html;charset=UTF-8");
		String s_name = req.getParameter("s_name");
		String s_number = req.getParameter("s_number");
		Student student = null;
		String errMsg = "";

		Connection con = null;
		PreparedStatement state = null;
		ResultSet result = null;
		try {
			con = JDBCUtils.getConnection();
			String sql = "select * from student where name=?and student_number=?";
			state = con.prepareStatement(sql);
			state.setString(1, s_name);
			state.setString(2, s_number);

			result = state.executeQuery();
			while (result.next()) {
				student = new Student();
				student.setName(result.getString("name"));
				student.setStudent_number(result.getString("student_number"));
				student.setDormitory_number(result.getString("dormitory_number"));
			}

		} catch (Exception e) {
			errMsg = e.getMessage();
		} finally {
			if (result != null) {
				try {
					result.close();
				} catch (SQLException e) {
					errMsg = e.getMessage();
				}
			}
			if (state != null) {
				try {
					state.close();
				} catch (SQLException e) {
					errMsg = e.getMessage();
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (SQLException e) {
					errMsg = e.getMessage();
				}
			}
			
		}

		if (student != null) {
			req.setAttribute("student", student);
			req.getRequestDispatcher("/WEB-INF/info.jsp").forward(req, resp);
		} else {
			errMsg="查无此人，请核对信息";
			req.setAttribute("errMsg", errMsg);
			System.out.println(errMsg);
			req.getRequestDispatcher("/WEB-INF/error.jsp").forward(req, resp);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
