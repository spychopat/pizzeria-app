package fr.pizzeria.dao;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.StockageException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoImplFichier implements Stockage {

	private String datapath;
	
	public PizzaDaoImplFichier(String datapath) {
		this.datapath = datapath;
	}

	@Override
	public List<Pizza> findAllPizzas() {
		List<Pizza> listPizzas = null;
		try {
			listPizzas = Files.list(Paths.get(datapath)).map(path -> {
				
				String code = path.toFile().getName().replaceAll(".txt", "");
				
				
				try {
					String[] valueTab = Files.lines(path)
							.findFirst()
							.orElseThrow(() -> new StockageException("fichier vide"))
							.split(";");
					return new Pizza(code,valueTab[0],Double.valueOf(valueTab[1]), CategoriePizza.valueOf(valueTab[2]));
				} catch (IOException e) {
					throw new StockageException("Erreur de lecture de fichier");
				}
			}).collect(Collectors.toList());
		
		
		} catch (IOException e) {
			throw new StockageException("Erreur de lecture de fichier");
		}
		
		return listPizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) throws DeletePizzaException {
		// TODO Auto-generated method stub
		return false;
	}

	
	
}
