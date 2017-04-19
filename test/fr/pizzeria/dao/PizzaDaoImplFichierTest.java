package fr.pizzeria.dao;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import fr.pizzeria.exception.*;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplFichierTest {

	
	
	@Test(expected = StockageException.class)
	public void testFindAllPizzasDataPathInvalide() {
		
		PizzaDaoImplFichier pizzDaoImplFichier = new PizzaDaoImplFichier(" data path non existant");
		
		List<Pizza> resultat = pizzDaoImplFichier.findAllPizzas();
	
	}
	
	@Test
	public void testFindAllPizzasNombreFichierTrouve() {
		
		PizzaDaoImplFichier pizzDaoImplFichier = new PizzaDaoImplFichier("test/dataTest");
		
		List<Pizza> resultat = pizzDaoImplFichier.findAllPizzas();
	
		Assert.assertEquals(2, resultat.size());
	}
	

}
