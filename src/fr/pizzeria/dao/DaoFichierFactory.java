package fr.pizzeria.dao;

public class DaoFichierFactory implements DaoFactory {

	
	private Stockage pizzaDao = new PizzaDaoImplFichier("data");
	
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
