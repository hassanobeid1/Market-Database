package core;

import java.util.Date;

/**
 * Represente le client
 */
public class Client
{
	/**
	 * email utilise representer le client
	 */
	private String email;
	/**
	 * Le mot de passe du client
	 */
	private String mdp;
	/**
	 * Le nom du client
	 */
	private String nom;
	/**
	 * Le prenom du client
	 */
	private String prenom;
	/**
	 * La date de naissance du client
	 */
	private Date dateNaissance;
	/**
	 * L'adresse postale du client
	 */
	private String addrPostale ;
	/**
	 * Constructeur
	 * @param l'adresse email du client
	 * @param le mot de passe du client
	 * @param le nom du client
	 * @param le prenom du client
	 * @param la date de naissance du client
	 * @param l'adresse postale du client
	 */
	public Client(String email, String mdp, String nom, String prenom,
				  Date dateNaissance, String addrPostale )
	{
		this.email = email;
		this.mdp = mdp;
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.addrPostale = addrPostale;
	}

	/**
	 * @return L'email du client
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @return le mot mot de passe de l'client
	 */
	public String getMdp() {
		return mdp;
	}

	/**
	 * @return le nom du client
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @return le prenom du client
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * Récupère l'adresse postale du client
	 */
	public String getAddrPostale() {
		return addrPostale;
	}

	/**
	 * Récupère la date de naissance du client
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}

}
