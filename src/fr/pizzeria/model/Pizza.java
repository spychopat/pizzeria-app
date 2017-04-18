package fr.pizzeria.model;

import java.util.ArrayList;

import fr.pizzeria.dao.Stockage;
import fr.pizzeria.dao.StockageArrayList;
import fr.pizzeria.exception.SavePizzaException;



public class Pizza {

	private int id;
	private String codePizza;
	private String nomPizza;
	private float prix;
	
	// pizzas stockés de l'application
	//private static ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	public static Stockage stockage = new StockageArrayList();
	
	public Pizza(String codePizza, String nomPizza, float prix) {
		super();
		
		
		this.id = trouverIDlibre();
		this.codePizza = codePizza;
		this.nomPizza = nomPizza;
		this.prix = prix;
		
		
	}
	
	


	/**
//	 * Supprimer une des pizzas stockées en fonction de son codePizza
//	 * @param codePizza le code de la pizza à supprimer (ex: PEP)
//	 * @return true si la pizza est trouvée et supprimée, false si codePizza non trouvé dans les pizzas stockées
//	 */
//	public static boolean deletePizza(String codePizza){
//		return stockage.findAllPizzas().remove(getPizza(codePizza));
//	}
//	

	/**
	 * Renvoi un nouvel ID non dupliqué dans la liste des pizzas stockées
	 * @return nouvel ID libre, renvoi -1 si aucun ID de libre (très improbable !)
	 */
	private int trouverIDlibre() {
		for(int i = 0; i < Integer.MAX_VALUE;i++){
			boolean dejaPrit = false;
			for (Pizza pizza: stockage.findAllPizzas()) {
    		    if(pizza.id == i)
    		    	dejaPrit = true;
			}
			if(!dejaPrit)
				return i;
		}
		return -1;
	}





	public static int getNombrePizza(){
		return stockage.findAllPizzas().size();
	}
	
	
	
	public String getCodePizza() {
		return codePizza;
	}



	public void setCodePizza(String codePizza) {
		this.codePizza = codePizza;
	}



	public String getNomPizza() {
		return nomPizza;
	}



	public void setNomPizza(String nomPizza) {
		this.nomPizza = nomPizza;
	}



	public float getPrix() {
		return prix;
	}



	public void setPrix(float prix) {
		this.prix = prix;
	}
	
	
	
	
	
}
