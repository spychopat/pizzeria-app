package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplMemoire implements Stockage{

	
	private static ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
	
	
	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		boolean result = pizzas.add(pizza);
		if(!result)
			throw new SavePizzaException("Code pizza déjà existant.");
		return result;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		Pizza pizzaAmodifier = getPizza(codePizza);
		
		if(pizzaAmodifier != null){
			pizzas.set(pizzas.indexOf(pizzaAmodifier), pizza);
			return true;
		} else {
			throw new UpdatePizzaException("Code pizza introuvable.");
		}
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		Pizza pizzaAsupprimer = getPizza(codePizza);
		
		if(pizzaAsupprimer != null){
			pizzas.remove(pizzaAsupprimer);
			return true;
		}
		
		throw new DeletePizzaException("Code pizza introuvable.");
	}
	
	private Pizza getPizza(String codePizza){
		for (Pizza pizza: pizzas) {
			if(pizza.getCodePizza().equals(codePizza))
				return pizza;
		}
		return null;
	}

}
