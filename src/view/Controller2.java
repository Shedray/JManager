package view;
import dao.PersonDao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pojo.Person;
import javafx.scene.control.PasswordField;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller2 implements Initializable {
    //注册控件
    @FXML TextField text =new PasswordField();
    @FXML PasswordField Pass =new PasswordField();
    @FXML Label Text =new Label();
//    @FXML
    @FXML public void initialize(URL url, ResourceBundle rb) {
        System.out.println(Text.getText());;
    }
    @FXML public void test(ActionEvent event){
        System.out.println(text.getText());
        System.out.println(Pass.getText());
    }
}