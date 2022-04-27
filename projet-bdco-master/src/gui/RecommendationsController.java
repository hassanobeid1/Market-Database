package gui;

import java.util.Set;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Control;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.EventHandler;

import javafx.fxml.FXML;

import application.Appli;


public class RecommendationsController extends Controller
{

    public RecommendationsController(Appli appli){
        super(appli);
    }

    @FXML
    private MenuItem menuCat;
    @FXML
    private ListView classPerso;
    @FXML
    private ListView classGeneral;

    public void initialize(){
      //Set the Event
      menuCat.setOnAction((new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            getAppli().getRecs().switchToCat(getAppli());
        }

      }));

      Set<String> names = getAppli().getRecs().categoriesPersoNames();
      for(String name : names){
          classPerso.getItems().add(name);
      }

      names = getAppli().getRecs().categoriesGlobalNames();
      for(String name : names){
          classGeneral.getItems().add(name);
      }

    }

}
