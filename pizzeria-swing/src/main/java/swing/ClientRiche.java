package swing;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.pizzeria.dao.PizzaDaoImplFichier;
import fr.pizzeria.dao.PizzaDaoImplMemoire;
import fr.pizzeria.dao.Stockage;
import fr.pizzeria.dao.jdbc.JDBC;
import fr.pizzeria.model.Pizza;

public class ClientRiche extends JFrame {

	private static final long serialVersionUID = 5431342407963141716L;

	private JPanel container = new JPanel();

	// Liste des boutons du menu
	JButton listerPizzas = new JButton("Lister les pizzas");
	JButton ajouterPizza = new JButton("Ajouter une pizza");
	JButton modifierPizza = new JButton("Modifier une pizza");
	JButton supprimerPizza = new JButton("Supprimer une pizza");
	JButton quitter = new JButton("Quitter");
	
	JTextArea area = new JTextArea();

	// Fen�tre secondaire permettant d'ajouter une pizza
	AjouterPizzaFrame pizzaFrame = new AjouterPizzaFrame();
	UpdatePizzaFrame updatePizzaFrame = new UpdatePizzaFrame();
	DeletePizzaFrame deletePizzaFrame = new DeletePizzaFrame();

	public ClientRiche() {
		this.setSize(310, 540);
		this.setTitle("Pizza manager");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// On initialise le conteneur avec tous les composants
		initComposant();
		// On ajoute le conteneur
		this.setContentPane(container);
		this.setVisible(true);
	}

	private void initComposant() {
		// On d�finit la police d'�criture � utiliser
		Font police = new Font("Arial", Font.BOLD, 16);
		
		// On parcourt le tableau initialis�
		// afin de cr�er nos boutons
		//Stockage dao = new PizzaDaoImplMemoire();
		//Stockage dao = new PizzaDaoImplFichier("src/main/resources/data");
		Stockage dao = new JDBC();
		
		pizzaFrame.setDao(dao);
		updatePizzaFrame.setDao(dao);
		deletePizzaFrame.setDao(dao);
		
		Dimension dimButton = new Dimension(250, 40);

		listerPizzas.addActionListener(e -> listerPizzas(dao));
		listerPizzas.setPreferredSize(dimButton);
		listerPizzas.setFont(police);
		listerPizzas.setMnemonic('l');
		
		ajouterPizza.addActionListener(e -> ajouterPizzas(dao));
		ajouterPizza.setPreferredSize(dimButton);
		ajouterPizza.setFont(police);
		
		modifierPizza.addActionListener(e -> modifierPizza(dao));
		modifierPizza.setPreferredSize(dimButton);
		modifierPizza.setFont(police);
		
		supprimerPizza.addActionListener(e -> supprimerPizza(dao));
		supprimerPizza.setPreferredSize(dimButton);
		supprimerPizza.setFont(police);
		
		quitter.addActionListener(e -> System.exit(0));
		quitter.setPreferredSize(dimButton);
		quitter.setFont(police);
		
		area.setPreferredSize(new Dimension(250, 250));

		container.add(listerPizzas);
		container.add(ajouterPizza);
		container.add(modifierPizza);
		container.add(supprimerPizza);
		container.add(quitter);
		container.add(area);
		
	}

	private void supprimerPizza(Stockage dao) {
		deletePizzaFrame.setDao(dao);
		deletePizzaFrame.setVisible(true);
	}

	private void modifierPizza(Stockage dao) {

		updatePizzaFrame.setDao(dao);
		updatePizzaFrame.setVisible(true);
	}

	private void ajouterPizzas(Stockage dao) {
		pizzaFrame.setDao(dao);
		pizzaFrame.setVisible(true);
	}

	private void listerPizzas(Stockage dao) {
		area.setText("");
		List<Pizza> pizzas = dao.findAllPizzas();
		for (Pizza pizza: pizzas){
			area.append(pizza.toString()+"\n");
		}
	}

}