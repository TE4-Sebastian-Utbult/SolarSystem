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

    public static void getForce(CelestialBody b1, CelestialBody b2) {

        double distance = distance(b2.px, b2.py, b1.px, b1.py);
        double f = 0;

        if (distance != 0) {
            f = 15 * (b2.m * b1.m) / (distance * distance);
        }

        double angle = Math.atan2(b2.py - b1.py, b2.px - b1.px);

        b1.fx = f * Math.cos(angle);
        b1.fy = f * Math.sin(angle);

    }

    public static void applyForce(CelestialBody b1) {
        b1.vx += (b1.fx / b1.m) * 3;
        b1.vy += (b1.fy / b1.m) * 3;
        b1.px += (b1.ax + b1.vx * 3);
        b1.py += (b1.ay + b1.vy * 3);
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }
}