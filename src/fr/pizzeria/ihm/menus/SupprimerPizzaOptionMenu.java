package fr.pizzeria.ihm.menus;

import java.util.Scanner;

import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	public SupprimerPizzaOptionMenu() {
		super("Supprimer une pizza");
	}

	@Override
	public boolean execute() {
		Scanner clavier = new Scanner(System.in);
		
		new ListerPizzasOptionMenu().execute();
		
		System.out.println("Quelle pizza voulez vous supprimer ?");
		String saisie = clavier.next();
		//Pizza.deletePizza(saisie);
		
		
		try {
			Pizza.stockage.deletePizza(saisie);
		} catch (StockageException e) {
			e.printStackTrace();
			
		}
		
		return true;
	}

}
