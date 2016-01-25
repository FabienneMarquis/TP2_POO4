package main.java;

import java.util.Observable;

/**
 * Created by 1494778 on 2016-01-21.
 */
public class Reserve extends Observable{


    public static int PRICE_PENALITY = 20, PRICE_PER_STOCK = 5;
    private int num,delta,stock, outstock,quantitySoldOut,totalPenality,averageStock,totalStock;
    String tempX;

    public Reserve(){
        stock = 500;
         }

    public synchronized void consommez(int quantity){
        num++;
        tempX="T1";
        delta = quantity;
        stock -= quantity;
        if (stock<0){
            outstock++;
            quantitySoldOut = -1*stock;
            totalPenality+= PRICE_PENALITY *quantitySoldOut;
        }
        totalStock += stock;
        averageStock = totalStock/num;
        setChanged();
        notifyObservers(new Result(num, tempX, delta, stock, outstock, quantitySoldOut, totalPenality, averageStock));
        //faire l'enregistrement des stats dans la base de données (utiliser le ConnectMySQL)

    }

    public synchronized void produire(int quantity){
        stock+= quantity;
        num++;
        tempX="T2";
        totalStock += stock;
        averageStock = totalStock/num;
        setChanged();
        notifyObservers(new Result(num, tempX, delta, stock, outstock, quantitySoldOut, totalPenality, averageStock));
        //faire l'enregistrement des stats dans la base de données (utiliser le ConnectMySQL)
    }




}
