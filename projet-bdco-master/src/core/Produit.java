package core;

import java.util.HashMap;

/**
 * Représente un produit
 */
public class Produit
{
    /**
     * L'id du produit pouvant également servir à l'identifier
     */
	private int idProduit;
    /**
     * Intitulé du produit
     */
	private String intitule;
    /**
     * Prix courant.
     * Est mis à jour à chaque nouvelle offre trouvée. (Vérification à faire)
     *  */
	private float prixCourant;
    /**
     * La description du produit
     */
	private String descP;
    /**
     * L'url pointant vers la photo.
     */
	private String URL;
    /**
     * La catégorie correspondant au produit
     */
	private Categorie cat;
    /**
     * Liste de caractérisitiques liées au produit
     */
    private HashMap<String, Caracteristique> caracteristiques;
	
	public Produit(int idProduit, String intitule, float prixCourant, String descP, String URL, Categorie cat)
	{
		this.idProduit = idProduit;
		this.intitule = intitule;
		this.prixCourant = prixCourant;
		this.descP = descP;
		this.URL = URL;
		this.cat = cat;
        caracteristiques = new HashMap<String, Caracteristique>();
	}

    public String getIntitule(){
        return intitule;
    }

    public String getData(){
        return Integer.toString(idProduit) + " : " + prixCourant + "€" + "  " + intitule;
    }

    /**
     *
     * Ajoute une caractéristique au produit
     * @param carac la {@link Caracteristique} à rajouter
     */
    public void addCaracteristique(Caracteristique carac){
        if (!caracteristiques.containsKey(carac.getNomCara()))
            caracteristiques.put(carac.getNomCara(), carac);
    }

    /**
     *
     * @param nomCara
     * @return
     * @throws ExceptionMissingCaract
     */
    public Caracteristique getCaracteristique(String nomCara) throws ExceptionMissingCaract{
        if (!caracteristiqueExist(nomCara))
            throw new ExceptionMissingCaract("Product " + intitule +
                                             " does bot contain the speficic caracteristic " + nomCara);
        return caracteristiques.get(nomCara);
    }

    /**
     * Vérifie si la caractéristique associée au nom existe
     * @param nomCara vérifie si notre objet possède une  caractéristique du nom de nomCara
     */
    public boolean caracteristiqueExist(String nomCara){
        return caracteristiques.containsKey(nomCara);
    }

    /**
     * Vérifie s'il existe une assiociation entre ce produit et la caracteristique passée en paramètre
     * @param cara La {@link Caracteristique} que l'on teste pour savoir l'appartenance au produit
     * @return true si ce dernier appartient à l'objet, false sinon
     */
    public boolean hasCaracteristique(Caracteristique cara){
        return caracteristiques.containsKey(cara.getNomCara());
    }

	/**
	 * Erreur correspondant à une catégorie mère manquante
	 */
	public static class ExceptionMissingCaract extends Exception{

		public ExceptionMissingCaract(String mesg){
			super(mesg);
		}
	}
}
