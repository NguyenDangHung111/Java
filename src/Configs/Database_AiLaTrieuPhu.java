package Configs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database_AiLaTrieuPhu {
		private  String url = "jdbc:mysql://localhost:3306/AiLaTrieuPhu";
	    private  String user = "root";
	    private  String password = "123456789";

	    public Connection getConnection() {
	        Connection conn = null;
	        try {
	            conn = DriverManager.getConnection(url, user, password);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return conn;
	    }
    }
