package services;

import java.sql.Connection;
import java.sql.DriverManager;

public class Singleton {
private static Connection cnx;
private Singleton() {

	
	
}
public static Connection getCnx() {
	
	if(cnx==null) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnx=DriverManager.getConnection("jdbc:mysql://localhost:3306/formulaire","root","");
			new Singleton();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
	return cnx;
}
}
