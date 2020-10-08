package Objects;

import Main.*;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class Planet {

    //Planet Appearence
    double d  = 0;
    double m  = 0;
    double a  = 0;
    public boolean visible = true;
    
    //Outher Appearance
    double G = 0.01;
    String name = "";
    String color1 = "#FFFFFF";
    int tailcount = 0;
    Planet[] tail = new Planet[10];

    //Position
    public double px = 0;
    public double py = 0;
    public double ax = 0;
    public double ay = 0;
    double fx = 0;
    double fy = 0;
    public double vx = 0;
    double vy = 0;

    double dx=0;
    double dy=0;


    public Planet(String name, Double G, double x, double y, double d, double m, double ax, double ay, String color){

        this.px = x;
        this.py = y;
        this.d  = d;
        this.m  = m;
        
        this.tail = new Planet[10];
        this.tailcount = 0;
        
        this.ax = ax;
        this.ay = ay;
        
        this.name = name;
        this.color1 = color;
        this.visible = true;
        this.G = G;

        this.a  = 0;
        this.fx = 0;
        this.fy = 0;
        this.vx = 0;
        this.vy = 0;

    }
    
    public void update(Planet outher) {
        double distance = distance(outher.px, outher.py, this.px, this.py);
        double f = 0;

        if(distance != 0){
            f = outher.G*( outher.m * this.m) / (distance * distance);
        }

        this.a = Math.atan2(outher.py - this.py, outher.px - this.px);

        this.fx = f * Math.cos(this.a);
        this.fy = f * Math.sin(this.a);

    }

    public void attraction() {
        this.vx += (this.fx/this.m)*Display.dt;
        this.vy += (this.fy/this.m)*Display.dt;
        this.px += this.ax + this.vx*Display.dt;
        this.py += this.ay + this.vy*Display.dt;
    }

    //GRAPHICS

    public void display(Graphics2D g2d) {
        if(visible){  
            g2d.setColor(Color.decode(this.color1));
            g2d.fillOval((int)((this.px - this.d/2)*Display.WorldZoom) - Display.WorldX, (int)((this.py  - this.d/2)*Display.WorldZoom) - Display.WorldY, (int)(this.d*Display.WorldZoom), (int)(this.d*Display.WorldZoom));
        }
    }

    public void DistanceLine(Graphics2D g2d, Planet outher){
        double Distance = distance(outher.px, outher.py, this.px, this.py);

        if(visible && Distance > 100 && Display.WorldZoom > 10000){      //FIXA DISTANCE LINE
            g2d.setColor(new Color(255, 255, 255, 30));
            g2d.drawLine((int)Display.Body[0].px, (int)Display.Body[0].py, (int)this.px, (int)this.py);

            g2d.setColor(new Color(255, 255, 255, 40));
            g2d.setFont(new Font("TimesRoman", Font.PLAIN, 8));
            g2d.drawString((int)Distance + "M", (int)((outher.px + this.px)/2)-15, (int)((outher.py + this.py)/2)+20);
            g2d.drawString(name, (int)((outher.px + this.px)/2)-15, (int)((outher.py + this.py)/2)+5);
        }
    }
    
    public boolean pointInCircle(int x, int y) {
        var distancesquared = (x - this.px) * (x - this.px) + (y - this.py) * (y - this.py);
        return distancesquared <= (this.d)-50 * (this.d)-50;
    }

    public double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

}