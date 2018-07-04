package org.tp.pp2.app.graficos;

import java.awt.AWTException;
import java.util.Map;

import com.google.common.collect.Maps;

import classProperties.KeyAvatarProperties;
import powers.PowerBasic;

/**
 * Hello world!wsadtyu
 *
 */
public class App 
{
    public static void main( String[] args ) throws NoSuchFieldException, IllegalAccessException, AWTException
    {
//        System.out.println( "Hello Graficos!" ); 
//        PowerBasic power = new PowerBasic(100);
//        System.out.println("Tomo el poder de tp back , fuerza " + power.atack().getDangerAtack() ); 
    
    //	KeyAvatarProperties k = new KeyAvatarProperties();
    	
    //	System.out.println(k.getElectionKeyAvatar().toString());
    	
    	Map<String, Integer> a = Maps.newHashMap();
    	a.put("si", 5);
    	Integer num = a.getOrDefault("NO EXISTE", 0);
    	Integer num2 = a.getOrDefault("si", 0);
    	System.out.println(num +"  - "+num2);
    }
}
