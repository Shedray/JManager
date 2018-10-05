package controllers;
import viewutil.NewPeople;
import viewutil.Tableview;
import dao.PersonDao;
import dao.RelationDao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import pojo.Person;
import viewutil.Dialog;


import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    /*注册当前页面的各种元素*/
    private String ID = new String();
    @FXML private TableView Info;
    @FXML private TextField SearchText;
    @FXML private ChoiceBox SearchChoi;
    Tableview show = new Tableview();
    PersonDao personinfo = new PersonDao();
    String SelectID = new String();
    /*
    * @param 对TableView进行初始化操作 并对每一行添加点击事件 目的是为了创建新的Win 提供更新删减接口
    * */

    public void TableViewInit(){

        try{
            String columname[]={"ID","Name","PersonID","Sexy","Nation","Birthday","groups","GroupID","HomeGroup"};
            show.setID(Info);
            show.setColumns(columname);
            show.setPeople(personinfo.findPerson());
            show.show();
        }catch (Exception e){
            e.printStackTrace();
        }

        Info.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Person>() {
                    public void changed(
                            ObservableValue<? extends Person> observableValue,
                            Person oldItem, Person newItem) {
                                ;
                                Info.setOnMouseClicked((MouseEvent t)->{
                                    if (t.getClickCount()==1)
                                        SelectID = newItem.getID();
                                    if (t.getClickCount() == 2) {
                                        NewPeople AddPeple = new NewPeople(newItem);
                                    }
                                });
                                //SelectID = null;
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
            Parent newwin = FXMLLoader.load(getClass().getResource("../view/Pass.fxml"));
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
            if(personinfo.findPersonByAnway(ChoicText,GetText)==null)
                //dialog
            {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("查询错误");
                alert.setHeaderText("数据库中无此信息！");
                alert.setContentText("点击继续");
                alert.showAndWait();
            }
            else
                show.UpdatePeople(personinfo.findPersonByAnway(ChoicText,GetText));
            }catch (Exception e){
                System.out.println(e);
            }
    }
    @FXML public void DisplayPeople(ActionEvent event){
        try{
//            showRelation(event);
            show.setPeople(personinfo.findPerson());
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @FXML public void AddPeople(ActionEvent event){
        NewPeople AddPeple = new NewPeople(new Person());

    }
    @FXML public Alert DeletePeople(ActionEvent event){
        if(this.SelectID == null)
            return new Dialog().ErrDialog("删除错误","未选中有效删除项","点击继续");
        if(personinfo.findPersonByAnway("Id",this.SelectID)==null)
            return new Dialog().ErrDialog("删除错误","未选中有效删除项","点击继续");
        personinfo.deletePersonById(this.SelectID);
        show.setPeople(personinfo.findPerson());
        return  new Dialog().InfoDialog("删除成功","成功删除数据","点击继续");
    }
    @FXML public void exit(ActionEvent event){
        Stage now =(Stage) Info.getScene().getWindow();
        now.close();
    }
//     public void showRelation(ActionEvent event){
//         RelationControler.SelectID=this.SelectID;
//        try {
//            Stage show = new Stage();
//            Parent newwin = FXMLLoader.load(getClass().getResource("../view/relation.fxml"));
//            show.setTitle("查看亲属关系");
//            show.setScene(new Scene(newwin, 600, 300));
//            show.show();
//        }catch (Exception e){
//
//        }
     //}
}
