package viewutil;

import controllers.AddController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pojo.Person;

public class NewPeople {
    public NewPeople(Person People){
        try{
            AddController test = new AddController();
            test.setPeople(People);
            Stage show = new Stage();
            Parent newwin = FXMLLoader.load(getClass().getResource("../view/Add.fxml"));
            if(People.getName()!=null)
                show.setTitle("编辑村民数据 - "+People.getName());
            else
                show.setTitle("新增村民数据");
            show.setScene(new Scene(newwin, 600, 650));
            show.show();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
