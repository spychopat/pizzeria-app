package fr.pizzeria.client;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.apache.commons.codec.digest.DigestUtils;

import fr.pizzeria.dao.IClientDao;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;


public class SinscrireFrame extends JFrame {
	
	


	private IClientDao dao;
	
	JLabel texteNom = new JLabel("Nom");
	JLabel textePrenom = new JLabel("Prénom");
	JLabel texteMail = new JLabel("e-mail");
	JLabel texteMdp = new JLabel("Mot de passe");
	
	JTextField nom = new JTextField();
	JTextField prenom = new JTextField();
	JTextField mail = new JTextField();
	JTextField mdp = new JTextField();
	
	
	JButton valider = new JButton("Valider");
	

	public SinscrireFrame() {
		
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
		
		this.getContentPane().add(texteNom);
		this.getContentPane().add(textePrenom);
		this.getContentPane().add(texteMail);
		this.getContentPane().add(texteMdp);
		
		this.getContentPane().add(prenom);
		this.getContentPane().add(nom);
		this.getContentPane().add(mail);
		this.getContentPane().add(mdp);
		
		this.getContentPane().add(valider);

		// On parcourt le tableau initialis�
		// afin de cr�er nos boutons
		
		int y = 50;
		
		texteNom.setFont(police);
		texteNom.setBounds(70, y, 100, 40);
		y+=50;
		
		textePrenom.setFont(police);
		textePrenom.setBounds(70, y, 100, 40);
		y+=50;

		texteMail.setFont(police);
		texteMail.setBounds(70, y, 100, 40);
		y+=50;
		
		texteMdp.setFont(police);
		texteMdp.setBounds(70, y, 100, 40);
		
		
		y=50;
		nom.setFont(police);
		nom.setBounds(150, y, 100, 40);
		y+=50;
		
		prenom.setFont(police);
		prenom.setBounds(150, y, 100, 40);
		y+=50;
		
		mail.setFont(police);
		mail.setBounds(150, y, 100, 40);
		y+=50;

		mdp.setFont(police);
		mdp.setBounds(150, y, 100, 40);
		y+=50;
		
		valider.addActionListener(e -> valider());
		valider.setBounds(100, y, 150, 50);
		valider.setFont(police);
		
	}

	private void valider() {
	
		//TODO crypter MDP
		try {
			dao.saveNewClient(new Client(nom.getText(),prenom.getText(),mail.getText(),mdp.getText()));
			this.nom.setText("");
			this.prenom.setText("");
			this.mail.setText("");
			this.mdp.setText("");
			this.setVisible(false);
		} catch (Exception e){
			System.out.println("Erreur lors de l'inscription du client dans la BDD (saisie incorrecte ?)");
		}
		
		
	}
	
	public void setDao(IClientDao dao) {
		this.dao = dao;
	}

}
