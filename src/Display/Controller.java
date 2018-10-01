package Display;
import dao.PersonDao;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pojo.Person;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML private TableView Info;
    @FXML private TextField SearchText;
    Display show = new Display();
    PersonDao personinfo = new PersonDao();
    /*
    * @param 对TableView进行初始化操作 并对每一行添加点击事件 目的是为了创建新的Win 提供更新删减接口
    * */
    public void TableViewInit(){
        try{
            List<Person> list =personinfo.findPerson();
            String columname[]={"ID","Name","PersonID","GroupID"};
            show.TableView(Info,columname,list);
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
                            //第一次新建窗口
                            //第二次重载数据
                            //重复使用一个窗口目的是为了节省资源
                    }

                }
        );
    }

    @FXML public void initialize(URL url, ResourceBundle rb) {
        TableViewInit();
    }
    @FXML public void SearchByName(ActionEvent event){
        try {
            show.list.clear();
            show.list.addAll(personinfo.findPersonByPersonName(SearchText.getText()));
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
