package fa.training.utils;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBconnection {
	private static String DRIVER, SERVER_NAME, DB_NAME, USER_NAME, PASSWORD;
	static final String FILE_NAME = "/properties/DBConfig.properties";


	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		Properties properties = new Properties();
		properties.load(DBconnection.class.getResourceAsStream(FILE_NAME));
		DRIVER = properties.getProperty("driver");
		SERVER_NAME = properties.getProperty("server");
		DB_NAME = properties.getProperty("dbname");
		USER_NAME = properties.getProperty("username");
		PASSWORD = properties.getProperty("password");
		Class.forName(DRIVER);
		return DriverManager.getConnection(SERVER_NAME + ";databaseName=" + DB_NAME +";encrypt=true;trustServerCertificate=true", USER_NAME, PASSWORD);
	}

	public static void closeConnection(Connection connection){
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
