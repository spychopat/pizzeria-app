package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private int id;
	
	@Column(name = "numero_commande")
	private int numeroCommande;
	
	@Column(name = "statut")
	private String statut;
	
	@Column(name = "dateCommande")
	private String dateCommande;
	
	@Column(name = "livreur_id")
	@ManyToOne
	private Livreur livreur;
	
	@Column(name = "client_id")
	@ManyToOne
	private Client client;
	
	
	
	
	
	
}
