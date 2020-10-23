package src2.GUI.Object;

public class CelestialBody {

    public static boolean ActiveCollision;

    public double px;
    public double py;
    public double vx;
    public double vy;
    public double fx;
    public double fy;
    public double ax;
    public double ay;

    public static String name;
    public String type;
    public String color;

    public double d;
    public double m;

    CelestialBody(String name, String type, String color, double x, double y, double ax, double ay, double d, double m){

        this.name = name;
        this.type = type;
        this.color = color;
        this.ActiveCollision = true;

        this.px = x;
        this.py = y;
        this.ax = ax;
        this.ay = ay;

        this.vx = 0;
        this.vy = 0;
        this.fx = 0;
        this.fy = 0;

        this.d = d;
        this.m = m;

    }

    CelestialBody(String name, String type, double x, double y){

        this.name = name;
        this.type = type;

        this.px = x;
        this.py = y;

        this.vx = 0;
        this.vy = 0;
        this.fx = 0;
        this.fy = 0;

    }

    public double getX(){
        return this.px;
    }

    public double getY(){
        return this.py;
    }

}
