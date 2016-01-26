package main.java;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by 1494778 on 2016-01-21.
 */
public class Result {

    private StringProperty tempX;
    private IntegerProperty num, delta, stock, ruptureStock, quantityRuptureStock, costPenality, averageStock;

    Result( int num, String tempX, int delta, int stock, int ruptureStock, int quantityRuptureStock, int costPenality, int averageStock) {
        this.num = new SimpleIntegerProperty(num);
        this.tempX = new SimpleStringProperty(tempX);
        this.delta = new SimpleIntegerProperty(delta);
        this.stock = new SimpleIntegerProperty(stock);
        this.ruptureStock = new SimpleIntegerProperty(ruptureStock);
        this.quantityRuptureStock = new SimpleIntegerProperty(quantityRuptureStock);
        this.costPenality = new SimpleIntegerProperty(costPenality);
        this.averageStock = new SimpleIntegerProperty(averageStock);

    }

    public String getTempX() {
        return tempX.get();
    }

    public StringProperty tempXProperty() {
        return tempX;
    }

    public int getNum() {
        return num.get();
    }

    public IntegerProperty numProperty() {
        return num;
    }

    public int getDelta() {
        return delta.get();
    }

    public IntegerProperty deltaProperty() {
        return delta;
    }

    public int getStock() {
        return stock.get();
    }

    public IntegerProperty stockProperty() {
        return stock;
    }

    public int getRuptureStock() {
        return ruptureStock.get();
    }

    public IntegerProperty ruptureStockProperty() {
        return ruptureStock;
    }

    public int getQuantityRuptureStock() {
        return quantityRuptureStock.get();
    }

    public IntegerProperty quantityRuptureStockProperty() {
        return quantityRuptureStock;
    }

    public int getCostPenality() {
        return costPenality.get();
    }

    public IntegerProperty costPenalityProperty() {
        return costPenality;
    }

    public int getAverageStock() {
        return averageStock.get();
    }

    public IntegerProperty averageStockProperty() {
        return averageStock;
    }
}
