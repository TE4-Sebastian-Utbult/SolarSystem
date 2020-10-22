package src2.GUI.Object;

import src2.Main.Display;

public class BodyHandler {

    public void delete(int index){

        for (int i = index; i < Display.Body.length - index; i++) {
            
            Display.Body[i] = Display.Body[i+1];

        }

    }
    
    public static void add(String name, String color, String type, double x, double y, double d){

        CelestialBody newarr[] = new CelestialBody[Display.Body.length + 1];
        for (int i = 0; i < Display.Body.length; i++) {
            newarr[i] = Display.Body[i];
        }

        newarr[Display.Body.length] = new CelestialBody(name, color, type, x, y, d);

        Display.Body = newarr;

    }

}