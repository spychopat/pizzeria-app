package fr.pizzeria.ihm.menus;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.ihm.OptionMenu;
import fr.pizzeria.model.Pizza;

/**
 * Liste les pizzas sauvegard�s dans le systeme
 * sur la sortie console
 * @author Pierre Brengues
 *
 */
public class ListerPizzasOptionMenu extends OptionMenu {

	IPizzaDao stockage;
	
	public ListerPizzasOptionMenu(IPizzaDao stockage) {
		super("Lister les pizzas");
		this.stockage = stockage;
	}

	@Override
	public boolean execute() {
		for (Pizza pizza: stockage.findAllPizzas()) {
		    System.out.println(pizza.getCodePizza() + " - " + pizza.getNomPizza() +" - "+ pizza.getPrix() +"€");
		}
		return true;
	}

}
 