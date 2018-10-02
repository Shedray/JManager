package ViewUtil;
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
public class Tableview{
//    ObservableList<Person> list = FXCollections.observableArrayList();
//    public void TableView(TableView Id, String[] Columns, List<Person> Data) {
//        ObservableList<TableColumn> observableList = Id.getColumns();
//        for (int i = 0; i < observableList.size(); i++) {
//            observableList.get(i).setCellValueFactory(new PropertyValueFactory(Columns[i]));
//        }
//        list.addAll(Data);
//        Id.setItems(list);
//    }
    private ObservableList<TableColumn> observableList;
    private TableView ID;
    private ObservableList<Person> People = FXCollections.observableArrayList();
    private String[] Columns;
    public void show(){
        observableList=this.ID.getColumns();
        for (int i = 0; i < observableList.size(); i++) {
            observableList.get(i).setCellValueFactory(new PropertyValueFactory(Columns[i]));
        }
        ID.setItems(People);
    }

    public void setPeople(List<Person> people) {
        People.addAll(people);
    }
    public void UpdatePeople(Person people) {
        People.clear();
        People.add(people);
    }
    public void setColumns(String[] columns) {
        Columns = columns;
    }

    public void setID(TableView ID) {
        this.ID = ID;
    }

}