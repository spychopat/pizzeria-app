package fr.pizzeria.console;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TestJdbc {


	public static void main(String[] args) throws ClassNotFoundException, SQLException{



		Class.forName("com.mysql.jdbc.Driver");
		Connection maConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/pizzeria?useSSL=false","root","");
		Statement statement = maConnection.createStatement();
		
		//ResultSet resultat = statement.executeQuery("SELECT * FROM client;");

		
		PreparedStatement selectPizzaSt = maConnection.prepareStatement("SELECT * FROM PIZZA WHERE ID=?");
		ResultSet resultat;
		
		selectPizzaSt.setInt(1,1);
		resultat = selectPizzaSt.executeQuery();
		afficherResultats(resultat);
		
		
		selectPizzaSt.setInt(1,3);
		resultat = selectPizzaSt.executeQuery();
		afficherResultats(resultat);
		
		 
	}

	
	
	
	private static void afficherResultats(ResultSet resultat) throws SQLException {
		while(resultat.next()){
			System.out.print(resultat.getString(1));
			System.out.print(" - "+resultat.getString(2));
			System.out.println(" - "+resultat.getString(3));
		}
		resultat.close();
	}


}
