package Display;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pojo.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;
public class Display {
    ObservableList<Person> list = FXCollections.observableArrayList();
    void TableView(TableView Id, String[] Columns, List<Person> Data) {
        ObservableList<TableColumn> observableList = Id.getColumns();
        for (int i = 0; i < observableList.size(); i++) {
            observableList.get(i).setCellValueFactory(new PropertyValueFactory(Columns[i]));
        }
        list.addAll(Data);
        Id.setItems(list);
    }

    void NewWin(String FXMLfile,String Title) {
        try {
            //一定需要使用try-catch，不然编译器不会让你过的，Trust me!
            Parent anotherRoot = FXMLLoader.load(getClass().getResource("info.fxml"));
            Stage anotherStage = new Stage();
            anotherStage.setTitle("Another Window Triggered by Clicking");
            anotherStage.setScene(new Scene(anotherRoot, 600, 329));
            anotherStage.show();
            anotherStage.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}