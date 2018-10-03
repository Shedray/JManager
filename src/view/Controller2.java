package view;
import dao.PersonDao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
    //注册控件;
    @FXML PasswordField Password1;
    @FXML PasswordField Password2;
    @FXML PasswordField Password3;
//    @FXML
    @FXML public void initialize(URL url, ResourceBundle rb) {
    }
    @FXML public void clear(ActionEvent event){
        Password1.clear();
        Password2.clear();
        Password3.clear();
        Stage Now =(Stage) Password1.getScene().getWindow();
        Now.close();
    }
    @FXML public void confirm(ActionEvent event){
        String pass1= Password1.getText();
        String pass2= Password2.getText();
        String pass3= Password3.getText();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Warning Dialog");
        alert.setHeaderText("Look, a Warning Dialog");
        alert.setContentText("Careful with the next step!");
        alert.showAndWait();
        System.out.println(pass1+pass2+pass3);
    }
}