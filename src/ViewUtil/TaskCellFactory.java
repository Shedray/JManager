package ViewUtil;

import dao.PersonDao;
import javafx.concurrent.Task;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;

class TaskCellFactory implements Callback<TableColumn<Task, String>, TableCell<Task, String>> {

    PersonDao People = new PersonDao();
    @Override
    public TableCell<Task, String> call(TableColumn<Task, String> param) {
        TextFieldTableCell<Task, String> cell = new TextFieldTableCell<>();
        cell.setOnMouseClicked((MouseEvent t) -> {
            if (t.getClickCount() == 2) {
                System.out.println(t);

            }
        });
        //cell.set(taskContextMenu);
        return cell;
    }
}

