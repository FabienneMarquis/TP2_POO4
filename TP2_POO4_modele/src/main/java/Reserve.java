package main.java;

/**
 * Created by 1494778 on 2016-01-21.
 */
public class Reserve {

    private int stock;
    private int outofStock=0;
    private int penality=0;

    private static int pricePenalty = 20;
    private int  num=0;
    private int ruptureStock;
    private int quantityRuptureStock;
    private int costPenality;
    private int averageStock ;
    private int totalStock;

    Reserve(){
        stock = 500;
         }

    public synchronized void consommez(int quantity){
        String tempX;
        int delta;
        this.stock= stock -quantity;
        if (this.stock<0){
            this.outofStock=+1;
            this.penality+=pricePenalty*(Math.abs(stock));
        }
        num=+1;
        tempX="T1";
        //faire l'enregistrement des stats dans la base de données (utiliser le ConnectMySQL)

    }

    public void produire(int quantity){
        stock+= quantity;
        String tempX;
        int delta;
        num=+1;
        tempX="T2";
        //faire l'enregistrement des stats dans la base de données (utiliser le ConnectMySQL)
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
