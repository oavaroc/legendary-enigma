package com.trms.util;
/*
 * This is a utility class that will be used to return JDBC connections as needed.
 * Using this abstraction, we can write code that handles passing credentials a single time
 */

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static ConnectionFactory cu = null;
	private static Properties props;

	private ConnectionFactory() {
		props = new Properties();
		try {
			InputStream dbProps = ConnectionFactory.class.getClassLoader().getResourceAsStream("database.properties");
			props.load(dbProps);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static synchronized ConnectionFactory getConnectionUtil() {
		if (cu == null) {
			cu = new ConnectionFactory();
		}
		return cu;
	}

	public Connection getConnection() {
		Connection conn = null;
		try {
			// if driver class cannot be located, you can force java to load the class:
			Class.forName(props.getProperty("drv"));

			conn = DriverManager.getConnection(props.getProperty("aws"),
					props.getProperty("usr"), 
					props.getProperty("psw"));
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;

	}
}
