package core;

/**
 * Classe représentant une catégorie
 */
public class Categorie {

	/**
	 * Nom de la catégorie (sert aussi à l'indentifier)
	 */
	private String nomCat;
	/**
	 * Catégorie mère de la catégorie actuelle
	 */
	private Categorie categorieMere;
	/**
	 * Nombre de produits d'offres
	 *  */
	private int count;

	public Categorie (String nomCat)
	{
		this.nomCat = nomCat;
		this.categorieMere = null;
	}

	public int getCount(){
		return count;
	}

	public void setCount(int count){
		this.count =  count;
	}

	/**
	 * @return la {@link Categorie} mère si elle existe
	 * @throws ExceptionMissingCategorieMere dans le cas où il n'y aurait pas de catégorie Mère
	 */
	public Categorie getCategorieMere() throws ExceptionMissingCategorieMere {
		if (!hasCategorieMere())
			throw new ExceptionMissingCategorieMere("Categorie Mere is null on categorie " + nomCat);

		return categorieMere;
	}

	/**
	 * @return le nom de la catégori
	 * */
	public String getNomCat(){
		return nomCat;
	}

	/**
	 * Set la classe mère
	 * @param categorieMere la {@link Categorie} mère de l'objet
	 */
	public void setCategorieMere(Categorie categorieMere){
		this.categorieMere = categorieMere;
	}

	/**
	 * Vérifie si une catégorie mère existe
	 * @return true si elle existe, false dans le cas contraire
	 */
	public boolean hasCategorieMere(){
		return categorieMere != null;
	}

	/**
	 * Erreur correspondant à une catégorie mère manquante
	 */
	public static class ExceptionMissingCategorieMere extends Exception{

		public ExceptionMissingCategorieMere(String mesg){
			super(mesg);
		}
	}
}
