package gui;

import java.util.Set;
import javafx.application.Application;
import javafx.collections.ObservableList;
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

import java.sql.*;

import application.Appli;

public class CatalogueController extends Controller
{
    public CatalogueController(Appli appli){
        super(appli);
    }

    @FXML
    private ListView listCat;

    @FXML
    private ListView listProd;

    @FXML
    private GridPane descPane;

    @FXML
    private MenuItem menuRecs;


    public void initialize(){
      //Set the Event
      menuRecs.setOnAction((new EventHandler<ActionEvent>() {
        public void handle(ActionEvent event) {
            getAppli().getCatalogueC().switchToRecs(getAppli());
        }
      }));

      listCat.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            if(listCat.getSelectionModel().getSelectedItem() != null){
                String categorie = listCat.getSelectionModel().getSelectedItem().toString();
                getAppli().getCatalogueC().generateCatalogueP(categorie, getAppli());
                Set<String> produitNames = getAppli().getCatalogueP().produitNames();
                listProd.getItems().clear();
                for(String name : produitNames){
                  listProd.getItems().add(name);
                }
            }
        }
      });

      listProd.setOnMouseClicked(new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
        }
      });

      Set<String> names = getAppli().getCatalogueC().categoriesNames();
      for(String name : names){
          listCat.getItems().add(name);
      }
    }

}
