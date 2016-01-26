import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import main.java.*;

import java.net.URL;
import java.util.Observable;
import java.util.Observer;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ControllerFXML implements Initializable, Observer {

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
    private TableView<Result> tableauOperation;

    @FXML
    private TableColumn<Result, Integer> tableauNum;

    @FXML
    private TableColumn<Result, Integer> tableauPenalite;

    @FXML
    private TableColumn<Result, Integer> tableauStock;

    @FXML
    private TableColumn<Result, String> tableauTx;

    @FXML
    private TableColumn<Result, Integer> tableauDelta;

    @FXML
    private TableColumn<Result, Integer> tableauRS;

    @FXML
    private TableColumn<Result, Integer> tableauQRS;

    @FXML
    private TableColumn<Result, Integer> tableauAvg;

    private ObservableList<Result> results = FXCollections.observableArrayList();

    private Reserve reserve;
    private ThrConsumme thrConsumme;
    private ThrProduction thrProduction;
    ScheduledThreadPoolExecutor thrConsummePoolExc;
    ScheduledThreadPoolExecutor productionThreadPoolExc;
    @FXML
    void doRAZ(ActionEvent event) {
        results.clear();
    }


    @FXML
    void start(ActionEvent event) {

        if (fieldTextTemp1.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Avertissement");
            alert.setHeaderText("Valeur Manquante");
            alert.setContentText("Il n'y a aucune valeur pour le temps T1");
            alert.showAndWait();
        }
        else if (fieldTextTemp2.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Avertissement");
            alert.setHeaderText("Valeur Manquante");
            alert.setContentText("Il n'y a aucune valeur pour le temps T2");
            alert.showAndWait();
        }
        else if (fieldTextDelta1.getText().isEmpty() ){

                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Avertissement");
                alert.setHeaderText("Valeur Manquante");
                alert.setContentText("Il n'y a aucune valeur pour le Delta 1");
                alert.showAndWait();
        }
        else if (fieldTextDelta2.getText().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Avertissement");
            alert.setHeaderText("Valeur Manquante");
            alert.setContentText("Il n'y a aucune valeur pour le Delta 2");
            alert.showAndWait();
        }
        else{
            reserve = new Reserve();
            reserve.addObserver(this);
            thrConsumme = new ThrConsumme(reserve,Integer.parseInt(fieldTextTemp1.getText()),Integer.parseInt(fieldTextDelta1.getText()));
            thrConsummePoolExc = new ScheduledThreadPoolExecutor(6);
            thrConsummePoolExc.scheduleWithFixedDelay(thrConsumme, 0, thrConsumme.getTemps1(), TimeUnit.MILLISECONDS);
            productionThreadPoolExc = new ScheduledThreadPoolExecutor(3);
            thrProduction = new ThrProduction(reserve,Integer.parseInt(fieldTextTemp2.getText()),Integer.parseInt(fieldTextDelta2.getText()));
            productionThreadPoolExc.scheduleWithFixedDelay(thrProduction, 0, thrProduction.getTemps2(), TimeUnit.MILLISECONDS);
            btnStart.setDisable(true);
            tnRAZ.setDisable(true);
            btnStop.setDisable(false);
        }
    }


    @FXML
    void stop(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Avertissement");
        alert.setHeaderText("Arrêter");
        alert.setContentText("Voulez-vous arrêter la simulation?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            thrConsummePoolExc.shutdown();
            productionThreadPoolExc.shutdown();
            tnRAZ.setDisable(false);
            btnStart.setDisable(false);
            btnStop.setDisable(true);
        }
    }
    public void quit(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Avertissement");
        alert.setHeaderText("Quitter");
        alert.setContentText("Voulez-vous Quitter le programme?");
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == ButtonType.OK) {
            Platform.exit();
            System.exit(0);
        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

        btnStop.setDisable(true);
        tableauOperation.setItems(results);
        tableauNum.setCellValueFactory(cellData -> cellData.getValue().numProperty().asObject());
        tableauAvg.setCellValueFactory(cellData -> cellData.getValue().averageStockProperty().asObject());
        tableauDelta.setCellValueFactory(cellData -> cellData.getValue().deltaProperty().asObject());
        tableauPenalite.setCellValueFactory(cellData -> cellData.getValue().costPenalityProperty().asObject());
        tableauQRS.setCellValueFactory(cellData -> cellData.getValue().quantityRuptureStockProperty().asObject());
        tableauRS.setCellValueFactory(cellData -> cellData.getValue().ruptureStockProperty().asObject());
        tableauStock.setCellValueFactory(cellData -> cellData.getValue().stockProperty().asObject());
        tableauTx.setCellValueFactory(cellData -> cellData.getValue().tempXProperty());
    }

    @Override
    public void update(Observable o, Object arg) {
        Result result = (Result) arg;
        results.add(result);
        textFieldQtStock.setText(String.valueOf(result.getStock()));
        textFieldCostStockAverage.setText(String.valueOf(result.getAverageStock()*Reserve.PRICE_PER_STOCK));
        textFieldRuptureStock.setText(String.valueOf(result.getRuptureStock()));
        textFieldStockAverage.setText(String.valueOf(result.getAverageStock()));
        textFieldTotalPenality.setText(String.valueOf(result.getCostPenality()));
    }
}
