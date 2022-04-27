package core;

/**
 * Classe representant les caracteristiques des produits
 */
public class Caracteristique
{
	/**
	 * Nom de la categorie (sert aussi a l'indentifier)
	 */
	private String nomCara;
	private String valeur;
	/**
	 * Constructeur
	 * @param le nom de la carateristique
	 * @param la valeur
	 */
	public Caracteristique(String nomCara, String valeur)
	{
		this.nomCara = nomCara;
		this.valeur = valeur;
	}

	/**
	 * Getter
	 * @return le nom du champs
	 */
	public String getNomCara(){
		return nomCara;
	}

	/**
	 * @return la valeur du champs (toujours en String)
	 */
	public String getValeur(){
		return valeur;
	}
}
