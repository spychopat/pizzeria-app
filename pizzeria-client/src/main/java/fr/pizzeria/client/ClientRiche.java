package fr.pizzeria.client;

import java.awt.Dimension;
import java.awt.Font;
import java.util.List;

import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import fr.pizzeria.dao.IClientDao;
import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.dao.jpa.ClientJPA;


public class ClientRiche extends JFrame {

	private static final long serialVersionUID = 5431342407963141716L;

	private JPanel container = new JPanel();

	// Liste des boutons du menu
	JButton sinscrire = new JButton("S'inscrire");
	JButton seConnecter = new JButton("Se Connecter");
	JButton quitter = new JButton("Quitter");
	
	//JTextArea area = new JTextArea();

	// Fen�tre secondaire permettant d'ajouter une pizza
	SinscrireFrame sinscrireFrame = new SinscrireFrame();
	SeConnecterFrame seConnecterFrame = new SeConnecterFrame();

	public ClientRiche() {
		this.setSize(310, 200);
		this.setTitle("Pizza Client");
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
		

		
		/*
		 *********************************************************************************************************************
		 *********************************************************************************************************************
		 *************************************  STOCKAGE *********************************************************************
		 *********************************************************************************************************************
		 *********************************************************************************************************************
		 */
		
		
		//Stockage dao = new PizzaDaoImplMemoire();
		//Stockage dao = new PizzaDaoImplFichier("src/main/resources/data");
		//Stockage dao = new JDBC();
		IClientDao dao = new ClientJPA(Persistence.createEntityManagerFactory("pizzeria-unit"));
		
		
		
		/*
		 *********************************************************************************************************************
		 *********************************************************************************************************************
		 *********************************************************************************************************************
		 *********************************************************************************************************************
		 *********************************************************************************************************************
		 */
	
		
		
		
		
		Dimension dimButton = new Dimension(250, 40);

		sinscrire.addActionListener(e -> sinscrire(dao));
		sinscrire.setPreferredSize(dimButton);
		sinscrire.setFont(police);
		sinscrire.setMnemonic('l');
		
		seConnecter.addActionListener(e -> seConnecter(dao));
		seConnecter.setPreferredSize(dimButton);
		seConnecter.setFont(police);
		
		
		quitter.addActionListener(e -> System.exit(0));
		quitter.setPreferredSize(dimButton);
		quitter.setFont(police);
		
		//area.setPreferredSize(new Dimension(250, 250));

		container.add(sinscrire);
		container.add(seConnecter);
		container.add(quitter);
		//container.add(area);
		
	}



	private void seConnecter(IClientDao dao) {
		// TODO
		seConnecterFrame.setVisible(true);
	}

	private void sinscrire(IClientDao dao) {
		sinscrireFrame.setDao(dao);
		sinscrireFrame.setVisible(true);
	}

}