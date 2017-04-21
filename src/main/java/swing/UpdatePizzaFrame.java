package swing;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.pizzeria.dao.Stockage;
import fr.pizzeria.model.Pizza;

public class UpdatePizzaFrame extends JFrame {

	// Un bouton par élément à afficher
	JLabel texteCodeAncien = new JLabel("Ancien Code");
	JLabel texteCode = new JLabel("Code");
	JLabel texteNom = new JLabel("Nom");
	JLabel textePrix = new JLabel("Prix");
	JTextField codeAncien = new JTextField();
	JTextField code = new JTextField();
	JTextField nom = new JTextField();
	JTextField prix = new JTextField();
	JButton valider = new JButton("Valider");
	
	Stockage dao;

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
		// On définit la police d'écriture à utiliser
		Font police = new Font("Arial", Font.BOLD, 16);
		
		// On aligne les informations à droite dans le JLabel
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

		// On parcourt le tableau initialisé
		// afin de créer nos boutons

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

	private void valider(Stockage dao2) {
		try {
			dao2.updatePizza(codeAncien.getText(),new Pizza(code.getText(), nom.getText(), Double.valueOf(prix.getText())));
			this.codeAncien.setText("");
			this.code.setText("");
			this.nom.setText("");
			this.prix.setText("");
			this.setVisible(false);
		} catch (Exception e){
			System.out.println("Erreur lors de la crétion de la pizza (saisie incorrecte ?)");
		}
	}

	public Stockage getDao() {
		return dao;
	}

	public void setDao(Stockage dao) {
		this.dao = dao;
	}

}