package src.Main;

import src.Listeners.*;

public class Update {

    public static int FocusedObject = 4;
    public static int countDiv = 0;

    public static void runRenderUpdate() {

        for (int i = 0; i < Display.Body.length; i++) {

            for (int j = 0; j < Display.Body.length; j++) {
                Display.Body[i].update(Display.Body[j]);
                Display.Body[i].attraction();
            }

            Display.player.update(Display.Body[i]);
            Display.player.attraction();

        }

        Display.r.repaint();
        Collision.PlanetCollide();

        // System.out.println();
        // System.out.println("Henrik X - " + Display.Body[4].dx);
        // System.out.println("Henrik Y - " + Display.Body[4].dy);

    }

    ;

    public static void runViewUpdate() {

        Display.screenSize = Display.frame.getSize();       //Updater default x and y pos
        Display.WorldY = (int) -Display.frame.getHeight() / 2;
        Display.WorldX = (int) -Display.frame.getWidth() / 2;

        setFocusedPlanet();
        setWorldXY();

        setWorldZoomToSelected();

    }

    private static void setWorldZoomToSelected() {
        if (Display.WorldZoom != Display.SelectedZoom) {
            Display.WorldZoom = Display.SelectedZoom;
        }
    }

    private static void setWorldXY() {
        for (int i = 0; i < Display.Body.length; i++) {
            if (Display.Body[i].Focused) {
                Display.WorldY = (int) (Display.Body[i].py * Display.WorldZoom - Display.frame.getHeight() / 2);
                Display.WorldX = (int) (Display.Body[i].px * Display.WorldZoom - Display.frame.getWidth() / 2);
                Display.SelectedZoom = Display.Body[i].sf;
            }
        }

        if (Display.player.Focused) {
            Display.WorldY = (int) (Display.player.py * Display.WorldZoom - Display.frame.getHeight() / 2);
            Display.WorldX = (int) (Display.player.px * Display.WorldZoom - Display.frame.getWidth() / 2);
            Display.SelectedZoom = Display.player.sf;
        }
    }

    private static void setFocusedPlanet() {
        for (int i = 0; i < Display.Body.length; i++) {
            if (i == FocusedObject) {
                Display.Body[i].Focused = true;
            } else {
                Display.Body[i].Focused = false;
            }
        }
    }

    public static double distance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

    public static boolean CircleOnCircle(double r1, double r2, double distance) {

        if (r1 + r2 > distance) {
            return true;
        } else {
            return false;
        }

    }

}
