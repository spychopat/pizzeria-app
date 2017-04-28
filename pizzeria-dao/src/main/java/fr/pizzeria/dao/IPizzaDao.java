package fr.pizzeria.dao;

import java.util.List;

import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

public interface IPizzaDao {
		
	List<Pizza> findAllPizzas();
	boolean saveNewPizza(Pizza pizza) throws SavePizzaException;
	boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
	boolean deletePizza(String codePizza) throws DeletePizzaException;
}
