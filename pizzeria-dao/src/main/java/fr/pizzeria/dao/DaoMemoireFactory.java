package fr.pizzeria.dao;

public class DaoMemoireFactory implements DaoFactory {

	
	private IPizzaDao pizzaDao = new PizzaDaoImplMemoire();
	
	/*
	public DaoMemoireFactory(Stockage pizzaDao) {
		super();
		this.pizzaDao = pizzaDao;
	}
*/

	@Override
	public IPizzaDao getPizzaDao() {
		return pizzaDao;
	}

}
