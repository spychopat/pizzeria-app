package fr.pizzeria.dao.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import fr.pizzeria.dao.Stockage;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class JDBC implements Stockage{

	
	
	
	private String URL_BDD ;//= "jdbc:mysql://localhost:3306/pizzeria?useSSL=false";
	private String USERNAME_BDD;// = "root";
	private String MDP_BDD;// = "";
	
	//private Connection maConnection;
	//private Statement statement;
	
	
	
	public JDBC(){
		
		ResourceBundle bundle = ResourceBundle.getBundle("jdbc");
		URL_BDD = bundle.getString("jdbc.bdd.url");
		USERNAME_BDD = bundle.getString("jdbc.bdd.username");
		MDP_BDD = bundle.getString("jdbc.bdd.password");
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			//maConnection = DriverManager.getConnection(URL_BDD,USERNAME_BDD,MDP_BDD);
			//statement = maConnection.createStatement();
			
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
			//e.printStackTrace();
		}
	}
	
	
	
	@Override
	public List<Pizza> findAllPizzas() {
		try {
			Connection maConnection = DriverManager.getConnection(URL_BDD,USERNAME_BDD,MDP_BDD);
			Statement statement = maConnection.createStatement();
			ResultSet resultat = statement.executeQuery("SELECT * FROM PIZZA;");
			List<Pizza> pizzas = new ArrayList<Pizza>();
			
			
			while(resultat.next()){
				pizzas.add(new Pizza(resultat.getString(2), resultat.getString(3), resultat.getDouble(4)));
			}

			resultat.close();
			statement.close();
			return pizzas;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		try {
			Connection maConnection = DriverManager.getConnection(URL_BDD,USERNAME_BDD,MDP_BDD);
			Statement statement = maConnection.createStatement();
			statement.executeUpdate("INSERT INTO `pizza` (`ID`, `ID_PIZZA`, `nom`, `prix`, `type`) "
					+ "VALUES (NULL, '"+pizza.getCodePizza()+"', '"+pizza.getNomPizza()+"', '"+pizza.getPrix()+"', '"+pizza.getCatPizz()+"')");

			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		try {

			Connection maConnection = DriverManager.getConnection(URL_BDD,USERNAME_BDD,MDP_BDD);
			Statement statement = maConnection.createStatement();
			statement.executeUpdate("UPDATE `pizza` "
					+ "SET `ID_PIZZA` = '"+pizza.getCodePizza()+"', "
							+ "`nom` = '"+pizza.getNomPizza()+"', "
									+ "`prix` = '"+pizza.getPrix()+"', `type` = '"+pizza.getCatPizz()+"' "
					+ "WHERE `pizza`.`ID_PIZZA` = '"+codePizza+"'");

			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		try {

			Connection maConnection = DriverManager.getConnection(URL_BDD,USERNAME_BDD,MDP_BDD);
			Statement statement = maConnection.createStatement();
			statement.executeUpdate("DELETE FROM `pizza` WHERE `pizza`.`ID_PIZZA` = '"+codePizza+"'");

			statement.close();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

}
