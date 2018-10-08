package viewutil;
import javafx.scene.control.TableCell;
import pojo.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.util.List;
public class Tableview<T>{
    private ObservableList<TableColumn> observableList;
    private TableView ID;
    private ObservableList<Object> People = FXCollections.observableArrayList();
    private String[] Columns;
    public void show(){
        observableList=this.ID.getColumns();
        for (int i = 0; i < observableList.size(); i++) {
            observableList.get(i).setCellValueFactory(new PropertyValueFactory(Columns[i]));
        }


        ID.setItems(People);

    }

    public void setData(List<T> Data) {
        People.clear();
        People.addAll(Data);
    }
    public void UpdateData(T Data) {
        People.clear();
        People.add(Data);
    }
    public void setColumns(String[] columns) {
        Columns = columns;
    }

    public void setID(TableView ID) {
        this.ID = ID;
    }

}