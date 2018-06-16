package org.tp.pp2.app.graficos;

import enums.Orientation;
import object.Avatar;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Aca programo el main qeu va a levanar el modo grafico" );
        Avatar a = new Avatar(10, Orientation.DOWN);
        System.out.println(a);
    }
}
