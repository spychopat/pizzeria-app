package swing;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import fr.pizzeria.dao.Stockage;
import fr.pizzeria.model.Pizza;

public class DeletePizzaFrame extends JFrame {

	// Un bouton par élément à afficher
	JLabel texteCodeAncien = new JLabel("Ancien Code");
	JTextField codeAncien = new JTextField();
	JButton valider = new JButton("Valider");
	
	Stockage dao;

	public DeletePizzaFrame() {
		
		this.setTitle("Supprimer pizza");
		this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		// On initialise le conteneur avec tous les composants
		initComposant();
		// On ajoute le conteneur
		this.setSize(340, 200);
		this.setVisible(false);
	}

	private void initComposant() {
		// On définit la police d'écriture à utiliser
		Font police = new Font("Arial", Font.BOLD, 16);
		
		// On aligne les informations à droite dans le JLabel
		this.getContentPane().setLayout(null);
		this.getContentPane().add(texteCodeAncien);
		this.getContentPane().add(codeAncien);
		this.getContentPane().add(valider);

		// On parcourt le tableau initialisé
		// afin de créer nos boutons

		int posY = 50;

		texteCodeAncien.setFont(police);
		texteCodeAncien.setBounds(40, posY, 100, 40);
		
		codeAncien.setFont(police);
		codeAncien.setBounds(150, posY, 100, 40);
		posY+=50;
		
		
		valider.addActionListener(e -> valider(dao));
		valider.setBounds(100, posY, 150, 50);
		valider.setFont(police);
		
	}

	private void valider(Stockage dao2) {
		try {
			dao2.deletePizza(codeAncien.getText());
			this.codeAncien.setText("");
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