package view;
import ViewUtil.Tableview;
import dao.PersonDao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.stage.Stage;
import pojo.Person;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    /*注册当前页面的各种元素*/
    @FXML private TableView Info;
    @FXML private TextField SearchText;

    @FXML private ChoiceBox SearchChoi;
    Tableview show = new Tableview();
    PersonDao personinfo = new PersonDao();
    /*
    * @param 对TableView进行初始化操作 并对每一行添加点击事件 目的是为了创建新的Win 提供更新删减接口
    * */
    public void TableViewInit(){

        try{
            String columname[]={"ID","Name","PersonID","GroupID"};
            show.setID(Info);
            show.setColumns(columname);
            show.setPeople(personinfo.findPerson());
            show.show();
        }catch (Exception e){
            e.printStackTrace();
        }
        Info.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Person>() {
                    int i=0;
                    public void changed(
                            ObservableValue<? extends Person> observableValue,
                            Person oldItem, Person newItem) {
                            i++;
                            System.out.println("i="+i);
                            try{

                            }catch (Exception e){
                                System.out.println(e);
                            }
                    }

                }
        );
    }
    public void SearchChoiInit(){
        SearchChoi.setItems(FXCollections.observableArrayList(
                "id", "Name"));
        Tooltip a = new Tooltip("选择查询方式");
        SearchChoi.setTooltip(a);
    }
    @FXML public void SetPass(ActionEvent event){
        try {
            Stage show = new Stage();
            Parent newwin = FXMLLoader.load(getClass().getResource("Info.fxml"));
            show.setTitle("设置权限密码");
            show.setScene(new Scene(newwin, 294, 183));
            show.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML public void initialize(URL url, ResourceBundle rb) {
        TableViewInit();
        SearchChoiInit();
    }
    @FXML public void SearchByName(ActionEvent event){
        String GetText = SearchText.getText();
        String ChoicText = SearchChoi.getValue().toString();
        try {
            if(GetText == null || GetText.length() <= 0)
                //弹出Dialog
                return;
                show.UpdatePeople(personinfo.findPersonByAnway(ChoicText,GetText));
            }catch (Exception e){
            System.out.println("hhh");
                System.out.println(e);
            }
    }
    @FXML public void DisplayAllPeople(ActionEvent event){
        try{
            show.setPeople(personinfo.findPerson());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML public void NewPeople(ActionEvent event){
        try{
            Stage show = new Stage();
            Parent newwin = FXMLLoader.load(getClass().getResource("new.fxml"));
            show.setTitle("新增村民数据");
            show.setScene(new Scene(newwin, 600, 600));
            show.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @FXML public void exit(ActionEvent event){
        Stage now =(Stage) Info.getScene().getWindow();
        now.close();
    }
}
