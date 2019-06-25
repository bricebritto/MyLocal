package com.siemens.tracker.backend.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;




@Component
@PropertySource("classpath:tracker-db.properties")

public class TrackerDbConnection{
	
	private static final Logger logger = LoggerFactory.getLogger(TrackerDbConnection.class);

	
		/** The tracker db driver name. */
	@Value("${trackerDbDriverName}")
	private String trackerDbDriverName;
	
	/** The tracker db connection url. */
	@Value("${trackerDbConnectionUrl}")
	private String trackerDbConnectionUrl;
	
	/** The tracker user name. */
	@Value("${trackerUsername}")
	private String trackerUserName;
	
	/** The tracker password. */
	@Value("${trackerPassword}")
	private String trackerPassword;
	
	
	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	public Connection getConnection() {
		logger.debug("getConnection-start");
		Connection connection = null;
		try {
			Class.forName(trackerDbDriverName);
		} catch (ClassNotFoundException e) {
			logger.error(e.getMessage() + e);
		}
		try {
			connection = DriverManager.getConnection(trackerDbConnectionUrl, trackerUserName,trackerPassword);
		} catch (SQLException e) {
			logger.error(e.getMessage() + e);
		}

		logger.debug("getConnection-end");
		return connection;
	}

	/**
	 * Close connection.
	 *
	 * @param connection the connection
	 */
	public void closeConnection(Connection connection) {
		try {
			logger.debug("closeConnection-start");
			connection.close();
			logger.debug("closeConnection-end");
		} catch (SQLException e) {
			logger.error(e.getMessage() + e);
		}
	}
}

	