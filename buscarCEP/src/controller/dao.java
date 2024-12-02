package controller;

import java.sql.Connection;
import java.sql.DriverManager;

public class dao {

	public static Connection getConnection() throws Exception {
		
        String url = "jdbc:mysql://localhost:3306/correios";
        String user = "root";
        String password = "";
        Class.forName("com.mysql.jdbc.Driver");
		
        return DriverManager.getConnection(url, user, password);		
	}
	
}
