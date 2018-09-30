package sample;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Controller {

    static final String DB_URL = "jdbc:mysql://localhost:3306/java_test?useSSL=false&serverTimezone=GMT%2B8";
    // 数据库的用户名与密码，需要根据自己的设置
    static final String USER = "root";
    static final String PASS = "123456";
    @FXML private TableView Info;
    @FXML private TextField SearchText;
    @FXML void showlist(){
        JDBC Test=new JDBC();

        Test.JDBC_Connect(DB_URL,USER,PASS);
        List<Person> maps ="";
        Display jj = new Display();
        String a[]={"ID","Name","PersonID","GroupID"};
        jj.TableView(Info,a,maps);
   }

    public void test(javafx.event.ActionEvent event) {
        //System.out.print(event);
        showlist();
    }
}
