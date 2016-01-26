package main.java;

import java.util.Observable;

/**
 * Created by 1494778 on 2016-01-21.
 */
public class Reserve extends Observable{


    public static int PRICE_PENALITY = 20, PRICE_PER_STOCK = 5;
    private int num,delta,stock, outstock,quantitySoldOut,totalPenality,averageStock,totalStock;
    String tempX;
    public  ConnectMySQL connection = new ConnectMySQL();
    public Reserve(){
        stock = 500;
         }

    public synchronized void consommez(int quantity){

        tempX="T1";
        num ++;
        delta = quantity;
        stock -= quantity;
        if (stock<0){
            outstock++;
            quantitySoldOut = -1*stock;
            totalPenality+= PRICE_PENALITY *quantitySoldOut;
        }
        totalStock += stock;
        averageStock = totalStock/num;
        connection.addStatistic(num, tempX, delta, stock, outstock, quantitySoldOut, totalPenality, averageStock);
        setChanged();

        System.out.print(num+"consommer");
        notifyObservers(new Result(num, tempX, delta, stock, outstock, quantitySoldOut, totalPenality, averageStock));
    }

    public synchronized void produire(int quantity){

        num ++;
        stock+= quantity;
        tempX="T2";
        totalStock += stock;
        averageStock = totalStock/num;
        setChanged();
        connection.addStatistic(num,tempX, delta, stock, outstock, quantitySoldOut, totalPenality, averageStock);

        System.out.print(num+"produire");
        notifyObservers(new Result(num, tempX, delta, stock, outstock, quantitySoldOut, totalPenality, averageStock));
    }




}
