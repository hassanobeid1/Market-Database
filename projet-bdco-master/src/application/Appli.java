package application;

import core.Client;
import gui.*;

/**
 * Application class
 * */
public class Appli
{
    private Authentificator auth;
    private Enchere enchere;
    private CatalogueProduits catalogueP;
    private Recommendations recs;
    private CatalogueCategories catalogueC;

    private Viewable currentView;

    private GUIApplication gui;

    public Appli(GUIApplication gui){
        auth = new Authentificator();
        currentView = auth;
        this.gui = gui;
    }


    public void eventAuthentificator(String login, String passwd, LoginController controller){
        try{
            auth.authenficate(login, passwd);
            auth.leaveLoginPage(this);
        } catch(NoResultException | CannotLoadPageException e){
            controller.showErrorLogin();
        }
    }

    public void switchScene(EnumScene sceneType){
        if (sceneType == EnumScene.CATALOGUE){
            gui.loadScene("Catalogue.fxml", new CatalogueController(this));
        }
        else if (sceneType == EnumScene.RECS){
            gui.loadScene("Recommendations.fxml", new RecommendationsController(this));
        }
    }

	public Viewable getCurrentView() {
		return currentView;
	}

	public void setCurrentView(Viewable currentView) {
		this.currentView = currentView;
	}

	public Authentificator getAuth() {
		return auth;
	}

	public void setAuth(Authentificator auth) {
		this.auth = auth;
	}

	public Enchere getEnchere() {
		return enchere;
	}

	public void setEnchere(Enchere enchere) {
		this.enchere = enchere;
	}

	public CatalogueProduits getCatalogueP() {
		return catalogueP;
	}

	public void setCatalogueP(CatalogueProduits catalogueP) {
		this.catalogueP = catalogueP;
	}

	public Recommendations getRecs() {
		return recs;
	}

	public void setRecs(Recommendations recs) {
		this.recs = recs;
	}

	public CatalogueCategories getCatalogueC() {
		return catalogueC;
	}

	public void setCatalogueC(CatalogueCategories catalogueC) {
		this.catalogueC = catalogueC;
	}

    public enum EnumScene {
        LOGINPAGE, CATALOGUE, ENCHERES, RECS
    }
}
