import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by 1494778 on 2016-01-19.
 */
public class ControllerFXML implements Initializable, Observer {
    @FXML
    private TextField fieldTextTemp1;

    @FXML
    private TextField fieldTextTemp2;

    @FXML
    private TextField fieldTextDelta1;

    @FXML
    private Button btnStart;

    @FXML
    private Button btnStop;

    @FXML
    private Button tnRAZ;

    @FXML
    private Button btnQuit;

    @FXML
    private TextField textFieldQtStock;

    @FXML
    private TextField textFieldRuptureStock;

    @FXML
    private TextField textFieldTotalPenality;

    @FXML
    private TextField textFieldStockAverage;

    @FXML
    private TextField textFieldCostStockAverage;

    @FXML
    private TableView<?> tableauOperation;

    @FXML
    private TableColumn<?, ?> tableauNum;

    @FXML
    private TableColumn<?, ?> tableauTx;

    @FXML
    private TableColumn<?, ?> tableauDelta;

    @FXML
    void doRAZ(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("");
        alert.setHeaderText("?");
        alert.setContentText("");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK){

        }
    }

    @FXML
    void quit(ActionEvent event) {

    }

    @FXML
    void start(ActionEvent event) {

    }

    @FXML
    void stop(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Avertissement");
        alert.setHeaderText("Arrêter");
        alert.setContentText("Voulez-vous arrêter la simulation?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK){

        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    @Override
    public void update(Observable o, Object arg) {

    }
}
