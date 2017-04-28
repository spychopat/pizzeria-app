package fr.pizzeria.dao;

public class DaoFichierFactory implements DaoFactory {

	
	private IPizzaDao pizzaDao = new PizzaDaoImplFichier("src/main/resources/data");
	
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
