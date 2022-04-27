package gui;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Control;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.geometry.Pos;
import javafx.geometry.Insets;
import javafx.event.EventHandler;

import javafx.fxml.FXML;

import application.Appli;

public class LoginController extends Controller
{

    public LoginController(Appli appli){
        super(appli);
    }

    @FXML
    private Button loginButton ;

    @FXML
    private Text errorText;

    @FXML
    private TextField loginText;

    @FXML
    private PasswordField passwdText;

    public void initialize() {
      //Set the Event
      LoginController controller = this;
      loginButton.setOnMouseClicked((new EventHandler<MouseEvent>() {
        public void handle(MouseEvent event) {
              getAppli().eventAuthentificator(loginText.getCharacters().toString(),
                                              passwdText.getCharacters().toString(),
                                              controller);
        }
      }));
    }

    public void showErrorLogin(){
        errorText.setText("Mauvais email/login");
    }

}
