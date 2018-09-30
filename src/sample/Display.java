package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.List;
import java.util.Map;

public class Display {
    void TableView(TableView Id, String[] Columns, List<Person> Data){
        ObservableList<Person> list = FXCollections.observableArrayList();
        ObservableList<TableColumn> observableList = Id.getColumns();
        for (int i=0;i<observableList.size();i++)
        {
            observableList.get(i).setCellValueFactory(new PropertyValueFactory(Columns[i]));
        }
        list.addAll(Data);
        Id.setItems(list);
    }
}
