import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by 1494778 on 2016-01-19.
 */
public class Controller extends Application implements Initializable{

    @FXML
    private GridPane root;

    @FXML
    private Scene scene;

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage primaryStage) throws Exception {
        String path = "./main/resources/vue_tp2_2.fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(path));
        root = fxmlLoader.load();
        scene = new Scene(root);


        primaryStage.setTitle("TP2 - Threads et MVC");
        primaryStage.setScene(scene);
        primaryStage.show();

        primaryStage.setOnCloseRequest((WindowEvent event)->
            ((ControllerFXML)fxmlLoader.getController()).quit()
        );
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
