package org.tp.pp2.app.graficos;

import powers.PowerBasic;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Graficos!" ); 
        PowerBasic power = new PowerBasic(100);
        System.out.println("Tomo el poder de tp back , fuerza " + power.atack().getDangerAtack() ); 
    }
}
