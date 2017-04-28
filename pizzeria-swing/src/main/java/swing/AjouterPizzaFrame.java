package swing;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.model.Pizza;

public class AjouterPizzaFrame extends JFrame {

	// Un bouton par �l�ment � afficher
	JLabel texteCode = new JLabel("Code");
	JLabel texteNom = new JLabel("Nom");
	JLabel textePrix = new JLabel("Prix");
	JTextField code = new JTextField();
	JTextField nom = new JTextField();
	JTextField prix = new JTextField();
	JButton valider = new JButton("Valider");
	
	IPizzaDao dao;

	public AjouterPizzaFrame() {
		
		this.setTitle("Ajouter pizza");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// On initialise le conteneur avec tous les composants
		initComposant();
		// On ajoute le conteneur
		this.setSize(340, 340);
		this.setVisible(false);
	}

	private void initComposant() {
		// On d�finit la police d'�criture � utiliser
		Font police = new Font("Arial", Font.BOLD, 16);
		
		// On aligne les informations � droite dans le JLabel
		this.getContentPane().setLayout(null);
		this.getContentPane().add(texteCode);
		this.getContentPane().add(texteNom);
		this.getContentPane().add(textePrix);
		this.getContentPane().add(code);
		this.getContentPane().add(nom);
		this.getContentPane().add(prix);
		this.getContentPane().add(valider);

		// On parcourt le tableau initialis�
		// afin de cr�er nos boutons

		texteCode.setFont(police);
		texteCode.setBounds(70, 50, 50, 40);

		texteNom.setFont(police);
		texteNom.setBounds(70, 100, 50, 40);

		textePrix.setFont(police);
		textePrix.setBounds(70, 150, 50, 40);
		
		code.setFont(police);
		code.setBounds(150, 50, 100, 40);
		
		nom.setFont(police);
		nom.setBounds(150, 100, 100, 40);
		
		prix.setFont(police);
		prix.setBounds(150, 150, 100, 40);
		
		valider.addActionListener(e -> valider(dao));
		valider.setBounds(100, 200, 150, 50);
		valider.setFont(police);
		
	}

	private void valider(IPizzaDao dao2) {
		try {
			dao2.saveNewPizza(new Pizza(code.getText(), nom.getText(), Double.valueOf(prix.getText())));
			this.code.setText("");
			this.nom.setText("");
			this.prix.setText("");
			this.setVisible(false);
		} catch (Exception e){
			System.out.println("Erreur lors de la crétion de la pizza (saisie incorrecte ?)");
		}
	}

	public IPizzaDao getDao() {
		return dao;
	}

	public void setDao(IPizzaDao dao) {
		this.dao = dao;
	}

}