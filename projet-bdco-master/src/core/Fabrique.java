package core;

import java.util.Date;
public class Fabrique{

    /**
     * À partir des informations fournies, construit un
     * objet Produit contenant les détails du produit (passés en
     * paramètre
     *
     */
    public static Produit fabriqueProduit(Integer idProduit, String intituleProduit,
            Float prixCourant, String description, String URL, Categorie categorie){
        return new Produit(idProduit, intituleProduit, prixCourant, description, URL, categorie);
    }

    public static Produit fabriqueProduit(Integer idProduit, String intituleProduit, Float prixCourant){
        return new Produit(idProduit, intituleProduit, prixCourant, null, null, null);
    }

    /**
     * Construction d'une catégorie
     *
     */
    public static Categorie fabriqueCategorie(String nomCat){
        return new Categorie(nomCat);
    }

    public static Categorie fabriqueCategorie(String nomCat, int count){
        Categorie cat = new Categorie(nomCat);
        cat.setCount(count);
        return cat;
    }

    /**
     * Construit un profil utilisateur
     */
    public static Client fabriqueClient(String email, String mdp, String nom, String prenom,
            Date dateNaissance, String adresse){
        return new Client(email, mdp, nom, prenom, dateNaissance, adresse);
    }

    
/**
     * Récupère une offre
     *
     */
    public static Offre fabriqueOffre(Integer idOffre, Date dateOffre, Float prixPropose,
            Produit produit, Client email){

        return new Offre(idOffre, dateOffre, prixPropose, produit, email);
    }
    /**
     * Représente une association champs/valeur et est possédée par un objet.
     */
    public static Caracteristique fabriqueCaracteristique(String champs, String value){
        return new Caracteristique(champs, value);
    }
}
