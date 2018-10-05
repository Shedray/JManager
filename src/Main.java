import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
<<<<<<< HEAD
        Parent root = FXMLLoader.load(getClass().getResource("./UIStatic/Main.fxml"));
=======
        Parent root = FXMLLoader.load(getClass().getResource("view/Main.fxml"));
>>>>>>> e890eff97a9df7c56b2f298cca1e456e2f9ca9bf
        primaryStage.setTitle("JManager");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
