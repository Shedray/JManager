package Display;
import Util.CurrentClick;
import dao.PersonDao;
import dao.RelationDao;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TableView;
import javafx.stage.Stage;
import pojo.Person;
import pojo.Relation;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class RelationControler  implements Initializable {

    @FXML private TableView Info;
    @FXML private Button exitButton;
    @FXML private Button insertButton;

    //销毁当前窗口的代码
    //exitButton是第二窗口的退出按钮
    public void exitButtonOnMouseClicked() {
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }
    public void insertButtonOnMouseClicked() {
        Stage stage = (Stage)exitButton.getScene().getWindow();
        String[] info=stage.getTitle().split("-");
        System.out.println(Arrays.deepToString(info));
       //insert
    }
    //平台退出的代码
    //platformExitButton是第二窗口的退出按钮
    public void platformExitButtonOnMouseClicked() {
        Platform.exit();
    }
    @FXML public void initialize(URL url, ResourceBundle rb) {
        TableViewInit(rb);
    }

    private void TableViewInit(ResourceBundle rb) {
       int id=Integer.parseInt(CurrentClick.CLICK_ID) ;
        Display show = new Display();
        RelationDao dao=new RelationDao();
        try{
           List<Relation> list =dao.findRelationById(id);

            String columname[]={"relation_name","relation_persionId","relation_description"};
            show.showRelationTableView(Info,columname,list);
        }catch (Exception e){
            e.printStackTrace();
        }
        Info.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Relation>() {
                    int i=0;
                    public void changed(
                            ObservableValue<? extends Relation> observableValue,
                            Relation oldItem, Relation newItem) {
                        i++;
                        System.out.println("i="+i);
                        //showRelation(observableValue.getValue().getID(),observableValue.getValue().getName(),observableValue.getValue().getPersonID());
                        //第一次新建窗口
                        //第二次重载数据
                        //重复使用一个窗口目的是为了节省资源
                    }

                }
        );
    }
}
