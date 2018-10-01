package Display;
import dao.PersonDao;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import pojo.Person;

import java.util.List;

public class Controller {
    @FXML private TableView Info;
    @FXML private TextField SearchText;
    @FXML void showlist(){
        Display jj = new Display();
        PersonDao d = new PersonDao();
        try {
            List<Person> list =d.findPerson();
            String a[]={"ID","Name","PersonID","GroupID"};
            jj.TableView(Info,a,list);
        }catch (Exception e)
        {
            e.printStackTrace();
        }


   }

    public void test(javafx.event.ActionEvent event) {
        //System.out.print(event);
        showlist();
    }
}
