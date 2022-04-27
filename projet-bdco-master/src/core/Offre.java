package core;

import java.util.Date;

/**
 * Represente une offre
 */
public class Offre
{
	/**
	 * L'id de l'offre utilise egalement pour identifier une offre
	 */
	private int idOffre;
	/**
	 * La date de realisation de l'offre
	 */
	private Date dateOffre;
	/**
	 * Le montant de l'offre a faire
	 */
	private float prixPropose;
	/**
	 * Le produit liee a l'offre
	 */
	private Produit produit;
	/**
	 * Le client effectuant l'offre
	 */
	private Client client;
	/**
	 * Constructeur
	 * @param l'identifiant de l'offre 
	 * @param la date de l'offre
	 * @param le prix propose dans cette offre
	 * @param le produit 
	 * @param le client qui a propose l'offre
	 */
	public Offre(int idOffre, Date dateOffre, float prixPropose, Produit produit, Client client)
	{
		this.idOffre = idOffre;
		this.dateOffre = dateOffre;
		this.prixPropose = prixPropose;
		this.produit = produit;
		this.client = client;
	}
}
