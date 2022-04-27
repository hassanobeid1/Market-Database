package application;

import java.util.Date;
import core.Fabrique;
import core.Client;
import java.sql.*;

import application.Appli;

/**
 * Authentificator class that deals
 * */
public class Authentificator extends Viewable
{
    private Client user = null;

    public void authenficate(String login, String password) throws NoResultException{
        try{
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection con=DriverManager.getConnection(
                                                       "jdbc:oracle:thin:@oracle1.ensimag.fr:1521:oracle1",
                                                       "vermeulf","vermeulf");

            PreparedStatement stmt=con.prepareStatement("SELECT * FROM client WHERE email= ? AND mdp= ?" );
            stmt.setString(1, login);
            stmt.setString(2, password);

            ResultSet rs=stmt.executeQuery();

            if(rs.next()){
                user = Fabrique.fabriqueClient(rs.getString(1), rs.getString(2), rs.getString(3),
                                               rs.getString(4), rs.getDate(5), rs.getString(6));
            }
            else
                throw new NoResultException("Not result found");

            con.close();

        }catch(Exception e){ System.out.println(e);}
    }

    public void leaveLoginPage(Appli app) throws CannotLoadPageException {
        if(user == null)
            throw new CannotLoadPageException("Client has not been initialized");
        app.setAuth(null); // Plus besoin de l'authentifieur
        // app.setEnchere(new Enchere(user));
        app.setCatalogueC(new CatalogueCategories(user));
        // app.setCatalogueP(new CatalogueProduits(user));
        // app.setRecs(new Recommendations(user));
        app.switchScene(Appli.EnumScene.CATALOGUE);
    }
}
