package src.Listeners;

import src.Main.*;

public class Collision {

    public static void PlanetCollide() {
        for (int i = 1; i < Display.Body.length; i++) {
            for (int j = 0; j < Display.Body.length; j++) {
                if (i != j) {
                    if (CircleOnCircle(Display.Body[i].d / 2, Display.Body[j].d / 2, distance(Display.Body[i].px, Display.Body[i].py, Display.Body[j].px, Display.Body[j].py))) {

                        Display.Body[i].visible = false;

                    }
                }
            }
        }
    }

    public static boolean Player(int i) {
        if (CircleOnCircle(Display.Body[i].d / 2, Display.player.h, Display.player.getDistanceFromPlanet(Display.Body[i]))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean CircleOnCircle(double r1, double r2, double distance) {

        if (r1 + r2 > distance) {
            return true;
        } else {
            return false;
        }

    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

}
