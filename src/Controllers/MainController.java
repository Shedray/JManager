package controllers;
import viewutil.Tableview;
import dao.PersonDao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojo.Person;
import viewutil.Dialog;


import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends AddController{
    /*注册当前页面的各种元素*/
    private String ID = new String();
    @FXML private TableView Info;
    @FXML private TextField SearchText;
    @FXML private ChoiceBox SearchChoi;
    @FXML private AddController testController;
    Tableview show = new Tableview();
    PersonDao personinfo = new PersonDao();
    String SelectID = new String();
    /*
    * @param 对TableView进行初始化操作 并对每一行添加点击事件 目的是为了创建新的Win 提供更新删减接口
    * */

    public void TableViewInit(){

        try{
            String columname[]={"ID","Name","Sexy","PersonID","Nation","Birthday","groups","GroupID","HomeGroup"};
            show.setID(Info);
            show.setColumns(columname);
            show.setData(personinfo.findPerson());
            show.show();
        }catch (Exception e){
            e.printStackTrace();
        }

        Info.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Person>() {
                    public void changed(
                            ObservableValue<? extends Person> observableValue,
                            Person oldItem, Person newItem) {
                                Info.setOnMouseClicked((MouseEvent t)->{
                                    if (t.getClickCount()==1)
                                        SelectID = newItem.getID();
                                    if (t.getClickCount() == 2) {
                                        testController.Refresh(newItem,SelectID);
                                    }
                                });
                    }
                }
        );
    }
    public void SearchChoiInit(){
        SearchChoi.setItems(FXCollections.observableArrayList(
                "身份证号", "姓名"));
        Tooltip a = new Tooltip("选择查询方式");
        SearchChoi.setTooltip(a);
    }

    @FXML public void initialize(URL url, ResourceBundle rb) {
        TableViewInit();
        SearchChoiInit();
    }

    /*
    * @按键事件
    *
    * */
    @FXML public void DisplayPeople(ActionEvent event){
        try{

//            showRelation(event);
            show.setData(personinfo.findPerson());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML public void AddPeople(ActionEvent event){
        testController.Refresh(new Person(),SelectID);
    }
    @FXML public Alert DeletePeople(ActionEvent event){
        if(this.SelectID == null)
            return new Dialog().ErrDialog("删除错误","未选中有效删除项","点击继续");
        if(personinfo.findPersonByAnway("Id",this.SelectID)==null)
            return new Dialog().ErrDialog("删除错误","未选中有效删除项","点击继续");
        personinfo.deletePersonById(this.SelectID);
        show.setData(personinfo.findPerson());
        return  new Dialog().InfoDialog("删除成功","成功删除数据","点击继续");
    }
    @FXML public void SearchByName(ActionEvent event){
        String GetText = SearchText.getText();
        String ChoicText=null;
        if(SearchChoi.getValue().toString().equals("姓名"))
            ChoicText = "Name";
        else if(SearchChoi.getValue().toString().equals("身份证号"))
            ChoicText = "PersonID";
        try {
            if(GetText == null || GetText.length() <= 0)
                //弹出Dialog
                return;
            if(personinfo.findPersonByAnway(ChoicText,GetText)==null)
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("查询错误");
                alert.setHeaderText("数据库中无此信息！");
                alert.setContentText("点击继续");
                alert.showAndWait();
            }
            else
                show.UpdateData(personinfo.findPersonByAnway(ChoicText,GetText));
            SearchText.clear();
        }catch (Exception e){
            System.out.println(e);
        }
    }
    /*
     * @页面退出事件
     *
     * */
    @FXML public void exit(ActionEvent event){
        Stage now =(Stage) Info.getScene().getWindow();
        now.close();
    }
    @FXML public void SetPass(ActionEvent event){
        try {
            Stage show = new Stage();
            Parent newwin = FXMLLoader.load(getClass().getResource("../view/Pass.fxml"));
            show.setTitle("设置权限密码");
            show.setScene(new Scene(newwin, 338, 245));
            show.setResizable(false);
            show.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
