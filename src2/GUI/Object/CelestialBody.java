package src2.GUI.Object;

public class CelestialBody {

    public static boolean ActiveCollision;

    public double px;
    public double py;
    public static double vx;
    public static double vy;
    public static double fx;
    public static double fy;

    public static String name;
    public static String type;
    public String color;

    public double d;

    CelestialBody(String name, String type, String color, double x, double y, double d){

        this.name = name;
        this.type = type;
        this.ActiveCollision = true;

        this.px = x;
        this.py = y;

        this.vx = 0;
        this.vy = 0;
        this.fx = 0;
        this.fy = 0;

        this.d = d;

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
