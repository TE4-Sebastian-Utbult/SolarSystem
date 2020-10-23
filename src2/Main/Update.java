package src2.Main;

import src2.GUI.Object.BodyHandler;
import src2.GUI.Object.CelestialBody;

public class Update {

    public static void update(){
        Camera.update();
        updateCelestials();
    }

    public static void updateCelestials(){
        for (CelestialBody b1 : Display.Body) {
            for (CelestialBody b2 : Display.Body) {
                BodyHandler.getForce(b1, b2);
                BodyHandler.applyForce(b1);
            }
        }
    }

}
