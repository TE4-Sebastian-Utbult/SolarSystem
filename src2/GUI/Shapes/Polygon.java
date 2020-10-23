package src2.GUI.Shapes;

import java.awt.*;

public class Polygon {

    public static void filled(Graphics2D g2d, String color, int[] xPoints, int[] yPoints, int total){
        g2d.setColor(Color.decode(color));
        g2d.fillPolygon(xPoints, yPoints, total);
    }
    public static void lined(Graphics2D g2d, String color, int[] xPoints, int[] yPoints, int total){
        g2d.setColor(Color.decode(color));
        g2d.drawPolygon(xPoints, yPoints, total);
    }

}
