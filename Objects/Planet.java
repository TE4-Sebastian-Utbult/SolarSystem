package Objects;

import Main.*;

import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

public class Planet {

    public int distance;
	//Planet Appearence
    public double d  = 0;
    double m  = 0;
    double a  = 0;
    public boolean visible = true;
    
    //Outher Appearance
    double G = 0.01;
    String name = "";
    String color = "#FFFFFF";
    
    //Position
    public double px = 0;
    public double py = 0;
    public double ax = 0;
    public double ay = 0;
    
    double fx = 0;
    double fy = 0;
    public double vx = 0;
    double vy = 0;
    public boolean Focused = false; 
    public double sf;
    
    public double dx=0;
    public double dy=0;
    public double dd = 0;


    public Planet(String name, Double G, double x, double y, double d, double m, double ax, double ay, String color, Double sf){

        this.px = x;
        this.py = y;
        this.d  = d;
        this.m  = m;
        
        this.ax = ax;
        this.ay = ay;
        
        this.name = name;
        this.color = color;
        this.visible = true;
        this.G = G;

        this.sf = sf;

        this.a  = 0;
        this.fx = 0;
        this.fy = 0;
        this.vx = 0;
        this.vy = 0;

        this.dx = 0;
        this.dy = 0;



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
        this.px += (this.ax + this.vx*Display.dt);
        this.py += (this.ay + this.vy*Display.dt);
    }

    //GRAPHICS

    public void display(Graphics2D g2d) {
        if(visible){  
            g2d.setColor(Color.decode(this.color));
            g2d.fillOval((int)((this.px - this.d/2)*Display.WorldZoom) - Display.WorldX, (int)((this.py  - this.d/2)*Display.WorldZoom) - Display.WorldY, (int)(this.d*Display.WorldZoom), (int)(this.d*Display.WorldZoom));

            this.dx = (this.px*Display.WorldZoom) - Display.WorldX;
            this.dy = (this.py*Display.WorldZoom) - Display.WorldY;
            this.dd = (this.d*Display.WorldZoom);
        }
    }

    public void displayDistance(Graphics2D g2d, Planet outher){

        int Distance = (int)distance(outher.px, outher.py, this.px, this.py);
        if(visible){
            g2d.setColor(Color.DARK_GRAY);
            g2d.drawString(this.name + " - " + Distance,(int)((this.px - this.d/2)*Display.WorldZoom) - Display.WorldX, (int)((this.py  - this.d/2)*Display.WorldZoom) - Display.WorldY);
        }
    }
    
    public void displayOrbitpath(Graphics2D g2d, Planet outher){

    }

    public boolean pointInCircle(int x, int y) {
        var distancesquared = (x - this.dx) * (x - this.dx) + (y - this.dy) * (y - this.dy);
        return distancesquared <= (this.d)+100 * (this.d)+100;
    }

    public double distance(double x1, double y1, double x2, double y2){
        return Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
    }

}
