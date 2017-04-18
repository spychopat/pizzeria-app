package fr.pizzeria.ihm.menus;

import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * Liste les pizzas sauvegardés dans le systeme
 * sur la sortie console
 * @author Pierre Brengues
 *
 */
public class ListerPizzasOptionMenu extends OptionMenu {

	
	
	public ListerPizzasOptionMenu() {
		super("Lister les pizzas");
	}

	@Override
	public boolean execute() {
		for (Pizza pizza: Pizza.stockage.findAllPizzas()) {
		    System.out.println(pizza.getCodePizza() + " - " + pizza.getNomPizza() +" - "+ pizza.getPrix() +"€");
		}
		return true;
	}

}
