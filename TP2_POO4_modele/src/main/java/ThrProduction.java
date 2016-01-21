package main.java;

/**
 * Created by Fabienne et Gabriel on 2016-01-20.
 */
public class ThrProduction extends Thread {

    private int temps2;
    private int deltaT2;


    ThrProduction(Reserve reserve, int temps2, int deltaT2){
        this.deltaT2= deltaT2;

    }
    public void run(){
        if(ThrProduction.this != null){
            ThrProduction.this.run();
        }
    }

}
