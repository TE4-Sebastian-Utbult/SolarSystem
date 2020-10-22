package src2.GUI.Shapes;

import java.awt.*;

public class Circle {

    public static void filled(Graphics2D g2d, String color, double x, double y, double width, double height){
        g2d.setColor(Color.decode(color));
        g2d.fillOval((int)(x - width/2), (int)(y - width/2), (int)width, (int)height);
    }

    public static void lined(Graphics2D g2d, String color, double x, double y, double width, double height){
        g2d.setColor(Color.decode(color));
        g2d.drawOval((int)(x - width/2), (int)(y - height/2), (int)width, (int)height);
    }

}
