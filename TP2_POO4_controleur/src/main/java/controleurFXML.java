import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import java.util.ResourceBundle;

/**
 * Created by fabienne et gabriel on 2016-01-12.
 */
public class ControleurFXML implements Initializable, Observer{

        @FXML
        private TextField fieldTextTemp1;

        @FXML
        private TextField fieldTextTemp2;

        @FXML
        private TextField fieldTextDelta1;

        @FXML
        private Button boutonDemarrer;

        @FXML
        private Button boutonArreter;

        @FXML
        private Button boutonRAZ;

        @FXML
        private TextField textFieldQtéStock;

        @FXML
        private TextField textFieldRuptureStock;

        @FXML
        private TextField textFieldTotalPenalite;

        @FXML
        private TextField textFieldStockmoyen;

        @FXML
        private TextField textFieldCoutStockmoyen;

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
        void start(ActionEvent event) {

        }

        @FXML
        void quitter(ActionEvent event) {

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



