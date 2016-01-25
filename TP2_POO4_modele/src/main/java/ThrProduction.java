package main.java;

/**
 * Created by Fabienne et Gabriel on 2016-01-20.
 */
public class ThrProduction extends Thread {

    private int temps2;
    private int deltaT2;
    private Reserve reserve;
    private boolean active;


    public ThrProduction(Reserve reserve,int temps2, int deltaT2) {
        this.temps2 = temps2;
        this.deltaT2 = deltaT2;
        this.reserve = reserve;
        this.active = false;
    }

    public void run(){
        reserve.produire(deltaT2);

    }
    public void close(){
        this.active = false;
    }

    public int getTemps2() {
        return temps2;
    }
}
