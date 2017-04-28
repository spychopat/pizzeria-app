package swing;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.pizzeria.dao.IPizzaDao;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class UpdatePizzaFrame extends JFrame {

	// Un bouton par �l�ment � afficher
	JLabel texteCodeAncien = new JLabel("Ancien Code");
	JLabel texteCode = new JLabel("Code");
	JLabel texteNom = new JLabel("Nom");
	JLabel textePrix = new JLabel("Prix");
	JTextField codeAncien = new JTextField();
	JTextField code = new JTextField();
	JTextField nom = new JTextField();
	JTextField prix = new JTextField();
	JButton valider = new JButton("Valider");
	
	IPizzaDao dao;

	public UpdatePizzaFrame() {
		
		this.setTitle("Modifier pizza");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// On initialise le conteneur avec tous les composants
		initComposant();
		// On ajoute le conteneur
		this.setSize(340, 400);
		this.setVisible(false);
	}

	private void initComposant() {
		// On d�finit la police d'�criture � utiliser
		Font police = new Font("Arial", Font.BOLD, 16);
		
		// On aligne les informations � droite dans le JLabel
		this.getContentPane().setLayout(null);
		this.getContentPane().add(texteCode);
		this.getContentPane().add(texteCodeAncien);
		this.getContentPane().add(texteNom);
		this.getContentPane().add(textePrix);
		this.getContentPane().add(codeAncien);
		this.getContentPane().add(code);
		this.getContentPane().add(nom);
		this.getContentPane().add(prix);
		this.getContentPane().add(valider);

		// On parcourt le tableau initialis�
		// afin de cr�er nos boutons

		int posY = 50;

		texteCodeAncien.setFont(police);
		texteCodeAncien.setBounds(70, posY, 50, 40);
		posY+=50;
		
		texteCode.setFont(police);
		texteCode.setBounds(70, posY, 50, 40);
		posY+=50;

		texteNom.setFont(police);
		texteNom.setBounds(70, posY, 50, 40);
		posY+=50;

		textePrix.setFont(police);
		textePrix.setBounds(70, posY, 50, 40);
		
		posY = 50;
		
		codeAncien.setFont(police);
		codeAncien.setBounds(150, posY, 100, 40);
		posY+=50;
		
		code.setFont(police);
		code.setBounds(150, posY, 100, 40);
		posY+=50;
		
		nom.setFont(police);
		nom.setBounds(150, posY, 100, 40);
		posY+=50;
		
		prix.setFont(police);
		prix.setBounds(150, posY, 100, 40);
		posY+=100;
		
		valider.addActionListener(e -> valider(dao));
		valider.setBounds(100, posY, 150, 50);
		valider.setFont(police);
		
	}

	private void valider(IPizzaDao dao2) {
		try {
			dao2.updatePizza(codeAncien.getText(),new Pizza(code.getText(), nom.getText(), Double.valueOf(prix.getText())));
			this.codeAncien.setText("");
			this.code.setText("");
			this.nom.setText("");
			this.prix.setText("");
			this.setVisible(false);
		} catch (UpdatePizzaException e){
			System.out.println("Erreur lors de la mise à jour de la pizza (saisie incorrecte ?)");
		}
	}

	public IPizzaDao getDao() {
		return dao;
	}

	public void setDao(IPizzaDao dao) {
		this.dao = dao;
	}

}