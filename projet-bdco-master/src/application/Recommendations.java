package application;

import java.sql.*;
import java.util.Set;
import java.util.HashSet;
import core.Client;
import core.Produit;
import core.Categorie;
import core.Fabrique;


import application.CatalogueCategories;
import application.Appli;

public class Recommendations
{
    private Client user;
    private Set<Categorie> classPersonnel;
    private Set<Categorie> classGlobal;

    private Set<Produit> listeProduits;

    public Recommendations(Client user){
        this.user = user;
        classPersonnel = new HashSet<Categorie>();
        classGlobal = new HashSet<Categorie>();
        listeProduits = new HashSet<Produit>();
        initCategories();
    }

    public void initCategories(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con=DriverManager.getConnection(
                                                       "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1",
                                                       "vermeulf","vermeulf");

            PreparedStatement stmt=con.prepareStatement("SELECT produit.nomcat, COUNT(produit.nomcat)" +
"FROM offre INNER JOIN etatoffre ON offre.idproduit = etatoffre.idproduit " +
"INNER JOIN Produit ON offre.idproduit=produit.idproduit " +
"WHERE offre.email=? AND etatoffre.nboffre<5 " +
"GROUP BY produit.nomcat" );

            stmt.setString(1, user.getEmail());

            ResultSet rs=stmt.executeQuery();

            while(rs.next()){
                classPersonnel.add(Fabrique.fabriqueCategorie(rs.getString(1), rs.getInt(2)));
            }

            stmt=con.prepareStatement("SELECT produit.nomcat, COUNT(produit.nomcat) FROM offre INNER JOIN produit "+
                                      "ON produit.idproduit = offre.idproduit GROUP BY produit.nomcat" );

            rs=stmt.executeQuery();

            while(rs.next()){
                classGlobal.add(Fabrique.fabriqueCategorie(rs.getString(1), rs.getInt(2)));
            }

            con.close();

        }catch(Exception e){ System.out.println(e);}

    }

    public void switchToCat(Appli appli){
        appli.setRecs(null);
        appli.setCatalogueC(new CatalogueCategories(user));
        appli.switchScene(Appli.EnumScene.CATALOGUE);
    }

    public Set<String> categoriesPersoNames(){
        Set<String> catNames = new HashSet<String>();
        for(Categorie cat : classPersonnel){
            catNames.add(cat.getNomCat());
        }
        return catNames;
    }

    public Set<String> categoriesGlobalNames(){
        Set<String> catNames = new HashSet<String>();
        for(Categorie cat : classGlobal){
            catNames.add(cat.getNomCat());
        }
        return catNames;
    }
}
