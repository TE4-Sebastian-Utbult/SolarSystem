package src2.GUI.Draw;

import java.awt.*;

import src2.GUI.Object.*;
import src2.GUI.Shapes.Circle;
import src2.Main.Display;

public class CelestialBodys {

    public static void render(Graphics2D g2d) {

        for (CelestialBody b : Display.Body) {

            Circle.filled(g2d, b.color, b.px, b.py, b.d, b.d);
            
        }

    }
    
}
