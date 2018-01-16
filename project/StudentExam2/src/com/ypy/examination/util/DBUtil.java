package com.ypy.examination.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static final String url = "jdbc:oracle:thin:@192.168.46.52:1521:orcl";
	private static final String user = "j1706";
	private static final String password = "j1706";
	private static Connection conn = null;
	private static final String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
	
	/**
	 * 连接数据库
	 * @return
	 */
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER_NAME);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	
	/**
	 * 关闭数据库（DML）
	 * @param conn
	 * @param ps
	 */
	public static void closeDriver(Connection conn, PreparedStatement ps) {
		try {
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭数据库（DQL）
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void closeDriver(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
			if (ps != null) {
				ps.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
