package main.java;

/**
 * Created by Fabienne et Gabriel on 2016-01-20.
 */
public class ThrConsumme extends Thread {
    private int temps1;
    private int deltaT1;


    ThrConsumme (Reserve reserve, int temps1, int deltaT1){
        this.temps1=temps1;
        this.deltaT1=deltaT1;
        reserve.consommez(deltaT1);
        attend(temps1);
    }
    public void run( ){
        if(ThrConsumme.this != null){
            ThrConsumme.this.run();
        }
    }

    private void attend(int t){
        try{
            Thread.sleep(t);
        }catch (InterruptedException exc){
            exc.printStackTrace();
        }
    }
}
