package src.Main;

import javax.swing.JFrame;
import java.awt.Toolkit;
import src.InterfaceVisuals.*;

import src.Objects.*;
import src.Listeners.*;

import java.awt.Dimension;

public class Display {

    public static boolean Play_State = true;

    public static int TimeSpeed = 100;
    public static double dt = 3;
    public static boolean running = true;
    public static double WorldZoom = 0.0005;
    public static double WorldXspeed = 10;
    public static double WorldYspeed = 10;
    public static double zoomSpeed = 0.5;
    public static double SelectedZoom = 0.1;
    public static boolean FocusManMade = false;
    public static boolean createPlanet = false;

    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int WorldY = 0;
    public static int WorldX = 0;
	public static boolean showInfo;

    public static JFrame frame;
    static Render r = new Render();

    // public static Planet[] Body;
    public static Planet[] Body = {

        new Planet("Sun", 0.0, 0.0, 700.0, 1600, 0.0, 0.0, "#FFD151", .05, false),

        new Planet("Obbion",  0.0, -500.0, 8.0, 0.02, 0.0090, 0.0, "#656176", 0.4, true),
        new Planet("Mov MY28",    0.0, 1200.0, 10.0, 0.2, 0.0050, 0.0, "#F1856A", 0.4, true),
        new Planet("Duutis",    1800, 0.0, 40.0, 10., 0.0, 0.0046, "#64B6AC", 0.4, true),
        new Planet("Pheron BM3H",   -4000, 0.0, 60, 30.0, 0.0, 0.0028, "#FFF5B2", 5.0, true),
        new Planet("Condov",   -4070, 0.0, 10, 0.01, 0.0, 0.0053, "#AA4465", 10.0, false),
        new Planet("nils",      0.0, 6000.0, 150, 20, 0.002, 0.0, "#C8E9A0", 0.3, true)

    };

    public static double Xspawn = 0;
    public static double Yspawn = 0;

    public static Button[] Button = {

            new Button(30, 0, 20, 20, "#FFFFFF"),
            new Button(0, 0, 20, 20, "#FFFFFF"),

    };

    public static Player player = new Player(-4030, 0, 0, 0, 4000.0);
    
    public static void main(String[] args) {

        System.out.println(screenSize.getHeight() + " | " + screenSize.getWidth());
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenSize);
        frame.setVisible(true);
        frame.add(r);
        frame.addMouseListener(new Mouse());
        frame.addKeyListener(new Keys());

        start();
    }

    public static void start() {
        running = true;
        run();
    }

    public static void stop() {
        running = false;
    }

    public static void run() {
        boolean run = true;
        while (run) {

            Update.runRenderUpdate();
            Update.runViewUpdate();

            try {
                Thread.sleep(TimeSpeed);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                run = false;
                e.printStackTrace();
            }

        }
    }
    
}