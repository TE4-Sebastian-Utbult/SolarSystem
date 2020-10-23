package src2.GUI.FX;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RadialGradientPaint;

import src2.Main.Display;

import java.awt.Point;

public class PointLight {

    private static final Color transparency = new Color(0, 0, 0, 0);

    public static void render(Graphics2D g2d, Point lightxy, int size, String c){
        double dx = (lightxy.x*Display.WorldZoom) - Display.WorldX;
        double dy = (lightxy.y*Display.WorldZoom) - Display.WorldY;
        int s = (int)(size*Display.WorldZoom);
        Point light = new Point((int)dx,(int)dy);

        float[] dist = { 0.2f, 0.8f };
        Color[] color = { Color.decode(c), transparency };
        RadialGradientPaint p = new RadialGradientPaint(light, s, dist, color);
        g2d.setPaint(p);
        g2d.fillRect(light.x - s, light.y- s , light.x*4, light.y*4);
    }
}
