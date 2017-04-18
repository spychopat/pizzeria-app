package fr.pizzeria.ihm;

public abstract class OptionMenu {

	private String libelle;

	public OptionMenu(String libelle) {
		super();
		this.libelle = libelle;
	}

	
	public abstract boolean execute();
	
	
	
	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	
	
	
	
}
