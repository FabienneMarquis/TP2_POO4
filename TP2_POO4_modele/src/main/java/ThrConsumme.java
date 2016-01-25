package main.java;

/**
 * Created by Fabienne et Gabriel on 2016-01-20.
 */
public class ThrConsumme extends Thread {
    private int temps1;
    private int deltaT1;
    private Reserve reserve;
    private boolean active;


    public ThrConsumme (Reserve reserve, int temps1, int deltaT1){
        this.temps1=temps1;
        this.deltaT1=deltaT1;
        this.reserve = reserve;
        active = false;
    }
    public void run(){
        reserve.consommez(deltaT1);

    }
    public void close(){
        this.active = false;
    }

    private void attend(int t){
        try{
            Thread.sleep(t);
        }catch (InterruptedException exc){
            exc.printStackTrace();
        }
    }

    public int getDeltaT1() {
        return deltaT1;
    }

    public int getTemps1() {
        return temps1;
    }
}
