package fr.pizzeria.dao;

public class DaoMemoireFactory implements DaoFactory {

	
	private Stockage pizzaDao = new PizzaDaoImplMemoire();
	
	/*
	public DaoMemoireFactory(Stockage pizzaDao) {
		super();
		this.pizzaDao = pizzaDao;
	}
*/

	@Override
	public Stockage getPizzaDao() {
		return pizzaDao;
	}

}
