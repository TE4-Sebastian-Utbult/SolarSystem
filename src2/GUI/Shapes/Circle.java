package src2.GUI.Shapes;

import java.awt.*;

import src2.Main.Display;

public class Circle {

    public static void filled(Graphics2D g2d, String color, double x, double y, double width, double height){
        double dx = (x*Display.WorldZoom) - Display.WorldX;
        double dy = (y*Display.WorldZoom) - Display.WorldY;
        double dwidth = width*Display.WorldZoom;
        double dheight = height*Display.WorldZoom;

        g2d.setColor(Color.decode(color));
        g2d.fillOval((int)(dx - dwidth/2), (int)(dy - dwidth/2), (int)dwidth, (int)dheight);
    }
    public static void lined(Graphics2D g2d, String color, double x, double y, double width, double height){
        double dx = (x*Display.WorldZoom) - Display.WorldX;
        double dy = (y*Display.WorldZoom) - Display.WorldY;
        double dwidth = width*Display.WorldZoom;
        double dheight = height*Display.WorldZoom;

        g2d.setColor(Color.decode(color));
        g2d.drawOval((int)(dx - dwidth/2), (int)(dy - dheight/2), (int)dwidth, (int)dheight);
    }

}
