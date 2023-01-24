package com.greedy.section02.template;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCTemplate {

	public static Connection getConnection() {

		Connection conn = null;
		Properties prop = new Properties();

		try {
			prop.load(new FileReader("config/jdbc-config.properties"));

			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");

			Class.forName(driver);

			conn = DriverManager.getConnection(url, prop);

		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection conn) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}