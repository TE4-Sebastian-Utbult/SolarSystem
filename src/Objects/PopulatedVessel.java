package src.Objects;

import java.awt.Graphics2D;
import java.awt.Color;

public class PopulatedVessel {

    public double px = 0;
    public double py = 0;
    public double h;
    public double w;

    String c;

    public double sf = 0;
    public boolean Focused = false;

    public PopulatedVessel(double x, double y, double height, double width, String color, double sf){

        this.px = x;
        this.py = y;
        this.h = height;
        this.w = width;

        this.c = color;

        this.sf = sf;
        this.Focused = false;

    }

    public void paintComponent(Graphics2D g2d){
        g2d.setColor(Color.decode(c));
    }
}
