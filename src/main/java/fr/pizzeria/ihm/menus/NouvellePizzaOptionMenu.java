package fr.pizzeria.ihm.menus;

import java.util.Scanner;

import fr.pizzeria.dao.Stockage;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;
/**
 * Permet � l'utilisateur de saisir une nouvelle pizza
 * elle est directement ajout�e � la liste des pizzas
 */
public class NouvellePizzaOptionMenu extends OptionMenu {
private Stockage stockage;
	public NouvellePizzaOptionMenu( Stockage stockage) {
		super("Ajouter une nouvelle pizza");
		this.stockage = stockage;
	}

	@Override
	public boolean execute() {
		
		Scanner clavier = new Scanner(System.in);
		
		String saisieCode, saisieNom;
		Double saisiePrix;
		System.out.println("Veuillez saisir le code Pizza :");
		saisieCode = clavier.next();
		System.out.println("Veuillez saisir le nom de la Pizza :");
		saisieNom = clavier.next();
		System.out.println("Veuillez saisir le prix de la pizza :");
		saisiePrix = clavier.nextDouble();
		
		Pizza newPizza = new Pizza(saisieCode,saisieNom,saisiePrix);
		
		try {
			this.stockage.saveNewPizza(newPizza);
		} catch (SavePizzaException e) {
			e.printStackTrace();
		}
		
		return true;
	}

}
