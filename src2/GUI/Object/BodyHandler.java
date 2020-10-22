package src2.GUI.Object;

import src2.Main.Display;

public class BodyHandler {

    public static void delete(int index){

        CelestialBody[] copy = new CelestialBody[Display.Body.length - 1];

        for (int i = 0, j = 0; i < Display.Body.length ; i++) {
            if(i != index){
                copy[j++] = Display.Body[i];
            }
        }

        Display.Body = copy;

    }
    
    public static void add(String name, String color, String type, double x, double y, double ax, double ay, double d, double m){

        CelestialBody newarr[] = new CelestialBody[Display.Body.length + 1];
        for (int i = 0; i < Display.Body.length; i++) {
            newarr[i] = Display.Body[i];
        }

        newarr[Display.Body.length] = new CelestialBody(name, color, type, x, y, ax, ay, d, m);

        Display.Body = newarr;

    }

}