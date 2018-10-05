package controllers;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import pojo.Person;
import pojo.Relation;
import service.RelationService;
import service.serviceImpl.RelationServiceImpl;

import java.net.URL;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
/**
 * 展示亲属关系界面controller
 * 2018年10月5日16:26:48
 * @author dj
 * */
public class RelationControler implements Initializable {

    @FXML private TableView Info;
    @FXML private Button exitButton;
    @FXML private Button insertButton;
    public static String SelectID="";

    //exitButton是第二窗口的退出按钮
    public void exitButtonOnMouseClicked() {
        Stage stage = (Stage)exitButton.getScene().getWindow();
        stage.close();
    }
    public void insertButtonOnMouseClicked() {
        Stage stage = (Stage)exitButton.getScene().getWindow();

       //insert
    }

    @FXML public void initialize(URL url, ResourceBundle rb) {
        TableViewInit();
    }

    private void TableViewInit() {
        //显示关系
        RelationService relationService=new RelationServiceImpl();
        try {
            List<Relation> relations=relationService.getDefaultParentsAndMarried(Integer.parseInt(SelectID));
            ObservableList<TableColumn> observableList=Info.getColumns();
            String[] Columns={"relation_name","relation_persionId","relation_description"};
            ObservableList<Relation> relation = FXCollections.observableArrayList();
            relation.clear();
            relation.addAll(relations);
            for (int i = 0; i < observableList.size(); i++) {
                observableList.get(i).setCellValueFactory(new PropertyValueFactory(Columns[i]));
            }
            Info.setItems(relation);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
