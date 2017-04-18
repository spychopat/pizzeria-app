package fr.pizzeria.ihm.menus;

import java.util.Scanner;

import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;
/**
 * Permet à l'utilisateur de saisir une nouvelle pizza
 * elle est directement ajoutée à la liste des pizzas
 */
public class NouvellePizzaOptionMenu extends OptionMenu {

	public NouvellePizzaOptionMenu() {
		super("Ajouter une nouvelle pizza");
	}

	@Override
	public boolean execute() {
		
		Scanner clavier = new Scanner(System.in);
		
		String saisieCode, saisieNom;
		float saisiePrix;
		System.out.println("Veuillez saisir le code Pizza :");
		saisieCode = clavier.next();
		System.out.println("Veuillez saisir le nom de la Pizza :");
		saisieNom = clavier.next();
		System.out.println("Veuillez saisir le prix de la pizza :");
		saisiePrix = clavier.nextFloat();
		
		Pizza newPizza = new Pizza(saisieCode,saisieNom,saisiePrix);
		
		try {
			Pizza.stockage.saveNewPizza(newPizza);
		} catch (SavePizzaException e) {
			e.printStackTrace();
		}
		
		return true;
	}

}
