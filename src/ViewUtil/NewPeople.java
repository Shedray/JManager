package viewutil;

import controllers.AddController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pojo.Person;

public class NewPeople {
    public NewPeople(Person People,String click){
        try{
            AddController test = new AddController();
            test.setPeople(People);
            AddController.CLICK=click;
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
