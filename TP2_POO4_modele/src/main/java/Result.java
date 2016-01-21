package main.java;

/**
 * Created by 1494778 on 2016-01-21.
 */
public class Result {
    private int num;
    private String tempX;
    private int delta;
    private int stock;
    private int ruptureStock;
    private int quantityRuptureStock;
    private int costPenality;
    private int averageStock;

    Result(int  num, String tempX, int delta, int stock, int ruptureStock, int quantityRuptureStock, int costPenality,int averageStock){
        this.num=num;
        this.tempX=tempX;
        this.delta=delta;
        this.stock=stock;
        this.ruptureStock=ruptureStock;
        this.quantityRuptureStock=quantityRuptureStock;
        this.costPenality=costPenality;
        this.averageStock=averageStock;

    }


    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getTempX() {
        return tempX;
    }

    public void setTempX(String tempX) {
        this.tempX = tempX;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getRuptureStock() {
        return ruptureStock;
    }

    public void setRuptureStock(int ruptureStock) {
        this.ruptureStock = ruptureStock;
    }

    public int getCostPenality() {
        return costPenality;
    }

    public void setCostPenality(int costPenality) {
        this.costPenality = costPenality;
    }

    public int getQuantityRuptureStock() {
        return quantityRuptureStock;
    }

    public void setQuantityRuptureStock(int quantityRuptureStock) {
        this.quantityRuptureStock = quantityRuptureStock;
    }

    public int getAverageStock() {
        return averageStock;
    }

    public void setAverageStock(int averageStock) {
        this.averageStock = averageStock;
    }
}
