package fr.pizzeria.console;

import fr.pizzeria.dao.DaoFactory;
import fr.pizzeria.dao.DaoFichierFactory;
import fr.pizzeria.dao.Stockage;
import fr.pizzeria.ihm.Menu;

import java.util.ResourceBundle;

import com.github.lalyos.jfiglet.FigletFont;

public class PizzeriaAdminConsoleApp {


	
	public static void main(String[] args) {
		
		
		
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		System.out.println(bundle.getString("super.mega.test"));
		System.out.println(bundle.getString("super.giga.test"));
		String value = bundle.getString("dao.impl");
		System.out.println(value);
		
		//String uneClasse = "fr.pizzeria.dao.memoire.PizzaDaoImplMemoire";
		try {
			Class<?> maClasse = Class.forName(value);
			Stockage unObjet = (Stockage) maClasse.newInstance();
			unObjet.findAllPizzas().forEach(p -> System.out.println(p.toString()));
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		
		
		
		//DaoFactory memFact = new DaoMemoireFactory();
		DaoFactory memFact = new DaoFichierFactory();
		
		
		
		Menu menu = new Menu(memFact.getPizzaDao());
		
//		memFact.getPizzaDao().saveNewPizza(new Pizza("PEP","Peperoni",10.47));
//		memFact.getPizzaDao().saveNewPizza(new Pizza("ROY","Royale",12.50));
//		memFact.getPizzaDao().saveNewPizza(new Pizza("4FR","4 Fromages",9.10));
//		memFact.getPizzaDao().saveNewPizza(new Pizza("YOP","Yopiti",18.69));
//		memFact.getPizzaDao().saveNewPizza(new Pizza("GIG","Gigapizz",99.99));
	
		
		System.out.println(FigletFont.convertOneLine("UBER-PIZZA"));
		
		

		
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
//				+ "3. Mettre � jour une pizza\n"
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
//	 * Permet � l'utilisateur de saisir une nouvelle pizza
//	 * elle est directement ajout�e � la liste des pizzas
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
//	 * Affiche toutes les pizzas � l'�cran
//	 * L'utilisateur doit appuyer sur Entr�e pour continuer
//	 */
//	private static void listerPizza() {
//		int i = 0;
//		for (Pizza pizza: Pizza.pizzas) {
//		    System.out.println(i+". " +pizza.getCodePizza() + " - " + pizza.getNomPizza() +" - "+ pizza.getPrix() +"�");
//		    i++;
//		}
//	}

}
