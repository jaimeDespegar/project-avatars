package adapters;

import turn.Timer;

public class test {

    public static void main(String[] args) {

        long init = System.currentTimeMillis();
        Timer timer = new Timer(2);
        timer.initTime();

        while(!timer.isFinish()) {
           System.out.println("Hola");
        }

        long finish = System.currentTimeMillis();
        System.out.println("Paso el tiempo : " + ((finish-init)/1000));

    }
}