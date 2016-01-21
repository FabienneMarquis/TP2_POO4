package main.java;

/**
 * Created by 1494778 on 2016-01-21.
 */
public class Reserve {

    private int stock;
    private int outofStock=0;
    private int penality=0;

    private static int priceStockUnit = 5;
    private static int pricePenalty = 20;

    Reserve(){
        stock = 500;
         }

    public synchronized void consommez(int quantity){
        this.stock= stock -quantity;
        if (this.stock<0){
            this.outofStock=+1;
            this.penality+=pricePenalty*(Math.abs(stock));
        }


    }

    public void produire(int quantity){
        stock+= quantity;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getOutofStock() {
        return outofStock;
    }

    public void setOutofStock(int outofStock) {
        this.outofStock = outofStock;
    }

    public int getPenality() {
        return penality;
    }

    public void setPenality(int penality) {
        this.penality = penality;
    }

}
