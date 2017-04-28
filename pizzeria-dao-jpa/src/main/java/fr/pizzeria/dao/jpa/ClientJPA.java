package fr.pizzeria.dao.jpa;

import javax.persistence.EntityManagerFactory;

import fr.pizzeria.dao.IClientDao;
import fr.pizzeria.model.Client;

public class ClientJPA implements IClientDao {

	
	
	
	
	
	private EntityManagerFactory entManFact;
	
	public ClientJPA(EntityManagerFactory entManFact) {
		super();
		this.entManFact = entManFact;
	}
	
	
	@Override
	public boolean saveNewClient(Client client) {
		// TODO Auto-generated method stub
		return false;
	}

}
