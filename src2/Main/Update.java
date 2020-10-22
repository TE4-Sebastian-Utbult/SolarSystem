package src2.Main;

import src2.GUI.Object.CelestialBody;

public class Update {

    public static void update(){

        for (CelestialBody b1 : Display.Body) {
            for (CelestialBody b2 : Display.Body) {
                getForce(b1, b2);
                applyForce(b1);
            }
        }

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
