package application;

import java.sql.*;
import java.util.Set;
import java.util.HashSet;
import core.Client;
import core.Fabrique;
import core.Categorie;

import application.Appli;

public class CatalogueCategories
{
    private Client user;
    private Set<Categorie> categories;

    public CatalogueCategories(Client client){
        this.user = user;
        categories = new HashSet<Categorie>();
        initCategories();
    }

    public void initCategories(){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con=DriverManager.getConnection(
                                                       "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1",
                                                       "vermeulf","vermeulf");

            PreparedStatement stmt=con.prepareStatement("SELECT nomCat FROM CATEGORIE" );

            ResultSet rs=stmt.executeQuery();

            while(rs.next()){
                categories.add(Fabrique.fabriqueCategorie(rs.getString(1)));
            }

            con.close();

        }catch(Exception e){ System.out.println(e);}

    }

    public void switchToRecs(Appli appli){
        appli.setCatalogueP(null);
        appli.setCatalogueC(null);
        appli.setRecs(new Recommendations(user));
        appli.switchScene(Appli.EnumScene.RECS);
    }

    public Set<String> categoriesNames(){
        Set<String> catNames = new HashSet<String>();
        for(Categorie cat : categories){
            catNames.add(cat.getNomCat());
        }
        return catNames;
    }

    public void generateCatalogueP(String nomCat, Appli app){
        app.setCatalogueP(new CatalogueProduits(user));
        app.getCatalogueP().requestProducts(nomCat);
    }

}
