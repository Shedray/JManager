package viewutil;

import javafx.scene.control.Alert;

public class Dialog {
    public Alert ErrDialog(String Title,String Header,String Content){
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(Title);
        alert.setHeaderText(Header);
        alert.setContentText(Content);
        alert.showAndWait();
        return alert;
    }
    public Alert InfoDialog(String Title,String Header,String Content){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(Title);
        alert.setHeaderText(Header);
        alert.setContentText(Content);
        alert.showAndWait();
        return alert;
    }
}

