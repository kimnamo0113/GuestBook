package gb.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {
	
	public static Connection getConnection() {
		Connection conn=null;
		String jdbcDriver="jdbc:apache:commons:dbcp:guestbook";
		try {
			conn = DriverManager.getConnection(jdbcDriver);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
	}
}
