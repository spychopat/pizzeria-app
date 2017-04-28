package fr.pizzeria.ihm.menus;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

public class ModifierPizzaOptionMenu extends OptionMenu {

	private IPizzaDao stockage;

	public ModifierPizzaOptionMenu(IPizzaDao stockage) {
		super("Mettre à jour une pizza");
		this.stockage = stockage;
	} 

	@Override
	public boolean execute() {
		
		Scanner clavier = new Scanner(System.in);
		
		new ListerPizzasOptionMenu(this.stockage).execute();
		
		System.out.println("Quelle pizza voulez vous modifier ?");
		String codePizzaAModifier = clavier.next();
		
		String saisieCode, saisieNom;
		Double saisiePrix;
		System.out.println("Veuillez saisir le nouveau code Pizza :");
		saisieCode = clavier.next();
		System.out.println("Veuillez saisir le nouveau nom de la Pizza :");
		saisieNom = clavier.next();
		System.out.println("Veuillez saisir le nouveau prix de la pizza :");
		saisiePrix = clavier.nextDouble();
		
		//Pizza PizzaAModifier = Pizza.getPizza(codePizzaAModifier);

//		PizzaAModifier.setCodePizza(saisieCode);
//		PizzaAModifier.setNomPizza(saisieNom);
//		PizzaAModifier.setPrix(saisiePrix);
		
		Pizza pizzaDeRemplacement = new Pizza(saisieCode,saisieNom,saisiePrix);
		
		
		
		try {
			this.stockage.updatePizza(codePizzaAModifier, pizzaDeRemplacement);
		} catch (StockageException e) {
			e.printStackTrace();
		}
		
		return true;
	}

}
