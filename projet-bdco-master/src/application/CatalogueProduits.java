package application;

import java.sql.*;
import java.util.Set;
import java.util.HashSet;
import core.Client;
import core.Produit;
import core.Fabrique;

public class CatalogueProduits
{
    private Client client;
    private Set<Produit> produits;

    public CatalogueProduits(Client client){
        this.client = client;
        produits = new HashSet<Produit>();
    }

    public void requestProducts(String nomCat){
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con=DriverManager.getConnection(
                                                       "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1",
                                                       "vermeulf","vermeulf");

            PreparedStatement stmt=con.prepareStatement("SELECT * FROM produit INNER JOIN etatoffre " +
                                                        "ON produit.idproduit = etatoffre.idproduit WHERE etatoffre.nboffre<5 AND produit.nomcat= ?" );

            stmt.setString(1, nomCat);

            ResultSet rs=stmt.executeQuery();

            while(rs.next()){
                produits.add(Fabrique.fabriqueProduit(rs.getInt(1), rs.getString(2), rs.getFloat(3)));
            }

            con.close();

        }catch(Exception e){ System.out.println(e);}
    }

    public Set<String> produitNames(){
        Set<String> prodNames = new HashSet<String>();
        for(Produit prod : produits){
            prodNames.add(prod.getData());
        }
        return prodNames;
    }
}
