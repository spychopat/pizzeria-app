package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import fr.pizzeria.dao.Stockage;

@Entity
@Table(name="pizza")
public class Pizza {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Enumerated()
    @Transient
	private CategoriePizza catPizz;
	
	@Column(name = "ID_PIZZA")
	private String codePizza;
	
	@Column(name = "nom")
	private String nomPizza;
	
	@Column(name = "prix")
	private Double prix;
	
	
	public Pizza(){

		this.catPizz = CategoriePizza.VIANDE;
		this.codePizza = "NOP";
		this.nomPizza = "DEFAULT-NAME";
		this.prix = 0.0;
	}
	
	
	// pizzas stock�s de l'application
	//private static ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	//public static Stockage stockage = new StockageArrayList();
	
	public Pizza(String codePizza, String nomPizza, Double prix) {
		super();
		
		
		//this.id = trouverIDlibre();
		this.catPizz = CategoriePizza.VIANDE;
		this.codePizza = codePizza;
		this.nomPizza = nomPizza;
		this.prix = prix;
		
		
	}
	
	 


	/**
//	 * Supprimer une des pizzas stock�es en fonction de son codePizza
//	 * @param codePizza le code de la pizza � supprimer (ex: PEP)
//	 * @return true si la pizza est trouv�e et supprim�e, false si codePizza non trouv� dans les pizzas stock�es
//	 */
//	public static boolean deletePizza(String codePizza){
//		return stockage.findAllPizzas().remove(getPizza(codePizza));
//	}
//	

	public Pizza(String codePizza, String nomPizza, Double prix, CategoriePizza categorie) {
		//this.id = trouverIDlibre();
		this.catPizz = categorie;
		this.codePizza = codePizza;
		this.nomPizza = nomPizza;
		this.prix = prix;
	}




	/**
	 * Renvoi un nouvel ID non dupliqu� dans la liste des pizzas stock�es
	 * @return nouvel ID libre, renvoi -1 si aucun ID de libre (tr�s improbable !)
	 */
//	private int trouverIDlibre(Stockage stockage) {
//		for(int i = 0; i < Integer.MAX_VALUE;i++){
//			boolean dejaPrit = false;
//			for (Pizza pizza: stockage.findAllPizzas()) {
//    		    if(pizza.id == i)
//    		    	dejaPrit = true;
//			}
//			if(!dejaPrit)
//				return i;
//		}
//		return -1;
//	}





	public static int getNombrePizza(Stockage stockage){
		return stockage.findAllPizzas().size();
	}
	
	
	
	public CategoriePizza getCatPizz() {
		return catPizz;
	}




	public void setCatPizz(CategoriePizza catPizz) {
		this.catPizz = catPizz;
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



	public Double getPrix() {
		return prix;
	}



	public void setPrix(Double prix) {
		this.prix = prix;
	}


	public String toString(){
		return display();
	}

	public String display() {
		return codePizza +" - "+nomPizza+" - "+prix+"€";
	}
	
	
	
	
	
}
