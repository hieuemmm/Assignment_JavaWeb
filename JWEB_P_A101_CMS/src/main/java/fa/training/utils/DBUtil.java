package fa.training.utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDataSource;
import com.microsoft.sqlserver.jdbc.SQLServerException;

/**
 * class handle create connection and close it.
 * @author FA
 *
 */
public class DBUtil {	
	public static final String HOST_NAME = "localhost";
	public static final String SERVER_NAME = "DESKTOP-CHT52UJ";
	public static final String USER_NAME = "sa";
	public static final String PASSWORD = "123";
	public static final String DATABASE_NAME = "JNWEBML101_SMS";
	public static final int PORT_NUMBER = 1433;
	
	public static Connection getConnection() {
		SQLServerDataSource sqlServerDataSource = new SQLServerDataSource();
		sqlServerDataSource.setHostNameInCertificate(HOST_NAME);
		sqlServerDataSource.setUser(USER_NAME);
		sqlServerDataSource.setPassword(PASSWORD);
		sqlServerDataSource.setServerName(SERVER_NAME);
		sqlServerDataSource.setPortNumber(PORT_NUMBER);
		sqlServerDataSource.setDatabaseName(DATABASE_NAME);
		sqlServerDataSource.setTrustServerCertificate(true);
		try {
			return sqlServerDataSource.getConnection();
		} catch (SQLServerException e) {
			System.out.println("Connect fail!!!");
			return null;
		}
	}

	public static void closeAll(ResultSet resultSet, PreparedStatement preparedStatement, Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
