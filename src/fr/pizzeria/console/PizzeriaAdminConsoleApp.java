package fr.pizzeria.console;

import java.util.ArrayList;
import java.util.Scanner;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Pizza;


public class PizzeriaAdminConsoleApp {


	
	public static void main(String[] args) {
		
		Menu menu = new Menu();
		
		try {
			Pizza.stockage.saveNewPizza(new Pizza("PEP","Peperoni",10.47f));
			Pizza.stockage.saveNewPizza(new Pizza("ROY","Royale",12.50f));
			Pizza.stockage.saveNewPizza(new Pizza("4FR","4 Fromages",9.10f));
			Pizza.stockage.saveNewPizza(new Pizza("YOP","Yopiti",18.69f));
			Pizza.stockage.saveNewPizza(new Pizza("GIG","Gigapizz",99.99f));
		} catch (SavePizzaException e) {
			e.printStackTrace();
		}
		
		
	
		
		

		
		boolean sortir;
		do{
			sortir = menu.afficher();
		} while(!sortir);
		

		
		
	}
	
	
//	/**
//	 * Affiche le menu et attend un choix de l'utilisateur
//	 * Redirige l'utilisateur en fonction de son choix
//	 * @return true si l'utilisateur souhaite quitter l'application
//	 */
//	private static boolean accueil() {
//		System.out.println("\n***** Pizzeria Administration *****\n"
//				+ "1. Lister les pizzas\n"
//				+ "2. Ajouter une nouvelle pizza\n"
//				+ "3. Mettre à jour une pizza\n"
//				+ "4. Supprimer une pizza\n"
//				+ "99. Sortir");
//		
//		switch(clavier.nextInt()){
//		case 1:
//			listerPizza();
//			break;
//		case 2:
//			ajouterPizza();
//			break;
//		case 3:
//			majPizza();
//			break;
//		case 4:
//			supprimerPizza();
//			break;
//		case 99:
//			return true;
//		}
//		return false;
//	}
//
//	private static void supprimerPizza() {
//		listerPizza();
//		System.out.println("Quelle pizza voulez vous supprimer ?");
//		int saisie = clavier.nextInt();
//		Pizza.pizzas.remove(saisie);
//	}
//
//	private static void majPizza() {
//		listerPizza();
//		System.out.println("Quelle pizza voulez vous modifier ?");
//		int saisieID = clavier.nextInt();
//		
//		String saisieCode, saisieNom;
//		float saisiePrix;
//		System.out.println("Veuillez saisir le nouveau code Pizza :");
//		saisieCode = clavier.next();
//		System.out.println("Veuillez saisir le nouveau nom de la Pizza :");
//		saisieNom = clavier.next();
//		System.out.println("Veuillez saisir le nouveau prix de la pizza :");
//		saisiePrix = clavier.nextFloat();
//		
//		Pizza.pizzas.get(saisieID).setCodePizza(saisieCode);
//		Pizza.pizzas.get(saisieID).setNomPizza(saisieNom);
//		Pizza.pizzas.get(saisieID).setPrix(saisiePrix);
//		
//		
//		
//	}
//	
//	
//	/**
//	 * Permet à l'utilisateur de saisir une nouvelle pizza
//	 * elle est directement ajoutée à la liste des pizzas
//	 */
//	private static void ajouterPizza() {
//		String saisieCode, saisieNom;
//		float saisiePrix;
//		
//		System.out.println("Veuillez saisir le code Pizza :");
//		saisieCode = clavier.next();
//		System.out.println("Veuillez saisir le nom de la Pizza :");
//		saisieNom = clavier.next();
//		System.out.println("Veuillez saisir le prix de la pizza :");
//		saisiePrix = clavier.nextFloat();
//		
//		Pizza.pizzas.add(new Pizza(saisieCode,saisieNom,saisiePrix));
//	}
//	
//	
//	/**
//	 * Affiche toutes les pizzas à l'écran
//	 * L'utilisateur doit appuyer sur Entrée pour continuer
//	 */
//	private static void listerPizza() {
//		int i = 0;
//		for (Pizza pizza: Pizza.pizzas) {
//		    System.out.println(i+". " +pizza.getCodePizza() + " - " + pizza.getNomPizza() +" - "+ pizza.getPrix() +"€");
//		    i++;
//		}
//	}

}
