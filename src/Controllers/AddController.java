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
    @FXML private ChoiceBox Add_Perman;
    @FXML private TextField Add_Name;
    @FXML private TextField Add_Nation;
    @FXML private TextField Add_personID;
    @FXML private TextField Add_Birthday;
    @FXML private TextField Add_GroupID;
    @FXML private TextField Add_HomeGroup;
    @FXML private TextField Add_PartyTime;
    @FXML private TextField Add_TypesOfPoorHouseholds;
    @FXML private TextField Add_Works;
    @FXML private TextField Add_NumberOfPlanted;
    @FXML private TextField Add_Address;
    @FXML private TextField Add_Group;
    @FXML private TextArea Add_EnjoyThePolicy;
    @FXML private TextArea Add_Assets;
    @FXML private Button Add_People;
    @FXML public void initialize(URL url, ResourceBundle rb) {
        ChoiceBoxInit();
        TextFieldInit();
        if(People.getID()==null)
            Add_People.setText("新增村民数据");
        else
            Add_People.setText("更新村民数据");
    }
    @FXML private void ChoiceBoxInit(){
        Add_Sex.setItems(FXCollections.observableArrayList(
                "男", "女","未知"));
        Add_Political.setItems(FXCollections.observableArrayList(
                "群众", "团员","预备党员","党员","其他"));
        Add_Perman.setItems(FXCollections.observableArrayList(
                "否","是","其他"));
        Add_Sex.setValue(People.getSexy());
        if(People.getSexy()==null)
            Add_Sex.setValue("未知");
        if(People.getPolitical()==null)
            Add_Political.setValue("其他");
        if(People.getIsItPermanent()==null)
            Add_Perman.setValue("其他");
    }
    private void TextFieldInit(){
        Add_Name.setText(People.getName());
        Add_Nation.setText(People.getNation());
        Add_personID.setText(People.getPersonID());
        Add_Birthday.setText(People.getBirthday());
        Add_GroupID.setText(People.getGroupID());
        Add_HomeGroup.setText(People.getHomeGroup());
        Add_PartyTime.setText(People.getPartyTime());
        Add_TypesOfPoorHouseholds.setText(People.getTypesOfPoorHouseholds());
        Add_Works.setText(People.getWorks());
        Add_NumberOfPlanted.setText(People.getNumberOfPlanted());
        Add_Address.setText(People.getAddress());
        Add_EnjoyThePolicy.setText(People.getEnjoyThePolicy());
        Add_Assets.setText(People.getAddress());
        Add_Group.setText(People.getGroups());
    }
    public  void InsertPeople(ActionEvent event){
        People.setName(Add_Name.getText());
        People.setNation(Add_Nation.getText());
        People.setPersonID(Add_personID.getText());
        People.setBirthday(Add_Birthday.getText());
        People.setGroupID(Add_GroupID.getText());
        People.setHomeGroup(Add_HomeGroup.getText());
        People.setPartyTime(Add_PartyTime.getText());
        People.setTypesOfPoorHouseholds(Add_TypesOfPoorHouseholds.getText());
        People.setWorks(Add_Works.getText());
        People.setNumberOfPlanted(Add_NumberOfPlanted.getText());
        People.setAddress(Add_Address.getText());
        People.setEnjoyThePolicy(Add_EnjoyThePolicy.getText());
        People.setGroups(Add_Group.getText());
        People.setAssets(Add_Assets.getText());
        People.setSexy(Add_Sex.getValue().toString());
        People.setPolitical(Add_Political.getValue().toString());
        People.setIsItPermanent(Add_Perman.getValue().toString());

        try {
            //System.out.println();
            if (People.getID()==null)
                new PersonDao().insertUser(People);
            else
                new PersonDao().updatetUser(People);//更新数据
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public  void Exit(ActionEvent event){
        System.out.println("sss");
        Stage Now =(Stage) Add_PartyTime.getScene().getWindow();
        Now.close();
    }
    public static void setPeople(Person people) {
        People = people;
    }
}