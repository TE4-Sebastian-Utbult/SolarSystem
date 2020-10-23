package src2.GUI.Draw;

import java.awt.*;

import src2.GUI.FX.PointLight;
import src2.GUI.Object.*;
import src2.GUI.Shapes.Circle;
import src2.Main.Display;
import java.awt.Point;

public class CelestialBodys {

    public static void render(Graphics2D g2d) {

        for (CelestialBody b : Display.Body) {

            type(g2d, b);
            Circle.filled(g2d, b.color, b.px, b.py, b.d, b.d);
            
        }

    }

    public static void type(Graphics2D g2d, CelestialBody b){
        if(b.type == "Star") {
            PointLight.render(g2d, new Point((int)b.px, (int)b.py), (int) (b.d + (b.d/20)), b.color);
        }
    }
    
}
