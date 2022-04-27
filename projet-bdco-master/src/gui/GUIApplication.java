package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Control;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.EventHandler;
import java.io.IOException;

import javafx.fxml.FXMLLoader;

import application.Appli;

public class GUIApplication extends Application{

    private Appli appli = new Appli(this);
    private Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
      this.stage = stage;


      //Setting title to the Stage
      stage.setTitle("Application BDCO");

      FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/LoginScenery.fxml"));

      loadScene("LoginScenery.fxml", new LoginController(appli));
      //Displaying the contents of the stage
      stage.show();

    }

    public void loadScene(String name, Controller controller){
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/" + name));

      // Set it in the FXMLLoader
      loader.setController(controller);
      try{

            VBox pane = loader.load();
            Scene scene = new Scene(pane);
            //Adding scene to the stage
            stage.setScene(scene);

      }catch(IOException e){
            e.printStackTrace();
            System.exit(1);
      }

    }

}
