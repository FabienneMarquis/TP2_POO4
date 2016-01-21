import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import main.java.ConnectMySQL;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerFXML implements Initializable, Observer{

    @FXML
    private TextField fieldTextTemp1;

    @FXML
    private TextField fieldTextTemp2;

    @FXML
    private TextField fieldTextDelta1;

    @FXML
    private TextField fieldTextDelta2;

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
