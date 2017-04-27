package fr.pizzeria.dao.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import fr.pizzeria.dao.Stockage;
import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;



public class JPA implements Stockage {

	
	
	
	private EntityManagerFactory entManFact;
	
	
	
	public JPA(EntityManagerFactory entManFact) {
		super();
		this.entManFact = entManFact;
	}
	
	

	@Override
	public List<Pizza> findAllPizzas() {
		
		List<Pizza> pizzas = new ArrayList<Pizza>();
		EntityManager entMan = entManFact.createEntityManager();
		Query query = entMan.createQuery("select p from Pizza p");
		
		for(Object pizza : query.getResultList()){
			pizzas.add((Pizza) pizza);
		}
		
		entMan.close();
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		EntityManager entMan = entManFact.createEntityManager();
		EntityTransaction transaction = entMan.getTransaction();
		
		transaction.begin();
		entMan.persist(pizza);
		transaction.commit();
		
		entMan.close();
		return true;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		
		EntityManager entMan = entManFact.createEntityManager();
		EntityTransaction transaction = entMan.getTransaction();
		Query query = entMan.createQuery("select p from Pizza p where p.codePizza = '"+codePizza+"'");
		
		
		transaction.begin();
		
		Pizza piz = (Pizza)query.getSingleResult();
		
		piz.setCatPizz(pizza.getCatPizz());
		piz.setCodePizza(pizza.getCodePizza());
		piz.setNomPizza(pizza.getNomPizza());
		piz.setPrix(pizza.getPrix());
		/*
		for(Object piz : query.getResultList()){
			if(((Pizza)piz).getCodePizza().equals(codePizza)){
				((Pizza)piz).setCatPizz(pizza.getCatPizz());
				((Pizza)piz).setCodePizza(pizza.getCodePizza());
				((Pizza)piz).setNomPizza(pizza.getNomPizza());
				((Pizza)piz).setPrix(pizza.getPrix());
			}
		}*/
		transaction.commit();
		
		entMan.close();
		return true;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		
		EntityManager entMan = entManFact.createEntityManager();
		EntityTransaction transaction = entMan.getTransaction();
		Query query = entMan.createQuery("select p from Pizza p");
		
		transaction.begin();
		for(Object piz : query.getResultList()){
			if(((Pizza)piz).getCodePizza().equals(codePizza)){
				entMan.remove(piz);
			}
		}
		transaction.commit();
		
		return true;
	}

	
}
