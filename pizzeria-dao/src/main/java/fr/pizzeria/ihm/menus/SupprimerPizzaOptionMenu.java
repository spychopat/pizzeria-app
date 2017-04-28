package fr.pizzeria.ihm.menus;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.*;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

public class SupprimerPizzaOptionMenu extends OptionMenu {

	private IPizzaDao stockage;

	public SupprimerPizzaOptionMenu(IPizzaDao stockage) {
		super("Supprimer une pizza");
		this.stockage = stockage;
	}

	@Override 
	public boolean execute() {
		Scanner clavier = new Scanner(System.in);
		
		new ListerPizzasOptionMenu(this.stockage).execute();
		
		System.out.println("Quelle pizza voulez vous supprimer ?");
		String saisie = clavier.next();
		//Pizza.deletePizza(saisie);
		
		
		try {
			this.stockage.deletePizza(saisie);
		} catch (StockageException e) {
			e.printStackTrace();
			
		}
		
		return true;
	}

}
