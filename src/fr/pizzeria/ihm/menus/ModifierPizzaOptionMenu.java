package fr.pizzeria.ihm.menus;

import java.util.Scanner;

import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {

	public ModifierPizzaOptionMenu() {
		super("Mettre à jour une pizza");
	}

	@Override
	public boolean execute() {
		
		Scanner clavier = new Scanner(System.in);
		
		new ListerPizzasOptionMenu().execute();
		
		System.out.println("Quelle pizza voulez vous modifier ?");
		String codePizzaAModifier = clavier.next();
		
		String saisieCode, saisieNom;
		float saisiePrix;
		System.out.println("Veuillez saisir le nouveau code Pizza :");
		saisieCode = clavier.next();
		System.out.println("Veuillez saisir le nouveau nom de la Pizza :");
		saisieNom = clavier.next();
		System.out.println("Veuillez saisir le nouveau prix de la pizza :");
		saisiePrix = clavier.nextFloat();
		
		//Pizza PizzaAModifier = Pizza.getPizza(codePizzaAModifier);

//		PizzaAModifier.setCodePizza(saisieCode);
//		PizzaAModifier.setNomPizza(saisieNom);
//		PizzaAModifier.setPrix(saisiePrix);
		
		Pizza pizzaDeRemplacement = new Pizza(saisieCode,saisieNom,saisiePrix);
		
		
		
		try {
			Pizza.stockage.updatePizza(codePizzaAModifier, pizzaDeRemplacement);
		} catch (StockageException e) {
			e.printStackTrace();
		}
		
		return true;
	}

}
