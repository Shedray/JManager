package controllers;
import dao.PersonDao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.stage.Stage;
import pojo.Person;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class AddController implements Initializable {
    //注册控件;
    private static Person People = new Person();
    @FXML private ChoiceBox Add_Sex;
    @FXML private ChoiceBox Add_Political;
    @FXML private TextField Add_Name;
    @FXML private Button Add_People;
    @FXML public void initialize(URL url, ResourceBundle rb) {
        ChoiceBoxInit();
        Add_Name.setText(People.getName());
        if(People.getID()==null)
            Add_People.setText("新增村民数据");
        else
            Add_People.setText("更新村民数据");
    }
    @FXML private void ChoiceBoxInit(){
        Add_Sex.setItems(FXCollections.observableArrayList(
                "男", "女"));
        Add_Political.setItems(FXCollections.observableArrayList(
                "群众", "团员","预备党员","党员","其他"));
        Add_Sex.setValue(People.getSexy());
        Add_Political.setValue(People.getPolitical());
    }
    public  void InsertPeople(ActionEvent event){

    }
    public static void setPeople(Person people) {
        People = people;
    }
}