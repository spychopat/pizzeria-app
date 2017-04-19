package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.Stockage;
import fr.pizzeria.ihm.menus.ListerPizzasOptionMenu;
import fr.pizzeria.ihm.menus.ModifierPizzaOptionMenu;
import fr.pizzeria.ihm.menus.NouvellePizzaOptionMenu;
import fr.pizzeria.ihm.menus.SupprimerPizzaOptionMenu;

public class Menu {

	private OptionMenu[] actions;
	
	
	private ListerPizzasOptionMenu listeurPizza;
	private NouvellePizzaOptionMenu createurPizza;
	private SupprimerPizzaOptionMenu supprimeurPizza;
	private ModifierPizzaOptionMenu modifieurPizza;
	
	
	
	
	
	public Menu(Stockage stockage) {
		super();
		listeurPizza = new ListerPizzasOptionMenu(stockage);
		createurPizza = new NouvellePizzaOptionMenu(stockage);
		supprimeurPizza = new SupprimerPizzaOptionMenu(stockage);
		modifieurPizza = new ModifierPizzaOptionMenu(stockage);
		
	}




	/**
	 * Affiche toutes les options menu
	 * sur la sortie console
	 * @return true si on veut quitter l'appli
	 */
	public boolean afficher(){
		Scanner clavier = new Scanner(System.in);
		
		System.out.println("\n"
				+ "***** Pizzeria Administration *****\n"
				+ "1. "+listeurPizza.getLibelle()+"\n"
				+ "2. "+createurPizza.getLibelle()+"\n"
				+ "3. "+modifieurPizza.getLibelle()+"\n"
				+ "4. "+supprimeurPizza.getLibelle()+"\n"
				+ "99. Sortir");

		switch(clavier.nextInt()){
		case 1:
			listeurPizza.execute();
			break;
		case 2:
			createurPizza.execute();
			break;
		case 3:
			modifieurPizza.execute();
			break;
		case 4:
			supprimeurPizza.execute();
			break;
		case 99:
			return true;
		}
		return false;
	}
	
}
