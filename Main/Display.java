package Main;

import javax.swing.JFrame;
import java.awt.Toolkit;

import Objects.*;
import Listeners.*;

import java.awt.Dimension;

public class Display {

    public static boolean Play_State = true;

    public static int TimeSpeed = 1;
    public static double dt = 3;
    public static boolean running = true;

    public static double WorldZoom = 0.0005;
    public static double WorldXspeed = 10;
    public static double WorldYspeed = 10;
    public static double zoomSpeed = 0.5;
    public static double SelectedZoom = 0.1;
    public static boolean FocusManMade = false;

    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int WorldY = 0;
    public static int WorldX = 0;

    public static JFrame frame;
    static Render r = new Render();
    static Pause p = new Pause();

    // public static Planet[] Body;
    public static Planet[] Body = {

        new Planet("Sun",     0.00001, 0.0, 0.0, 400.0, 1600, 0.0, 0.0, "#FFD151", .1),
        // new Planet("BLACK HOLE", 0.001, -4000, -2000, 100, 1600, 0.0, 0.0, "#000000", 0.1),

        new Planet("Charleé", 0.00001, 0.0, -500.0, 8.0, 0.02, 0.0090, 0.0, "#656176", 0.4),
        new Planet("Sebbe",   0.00001, 0.0, 1200.0, 10.0, 0.2, 0.0050, 0.0, "#F1856A", 0.4),
        new Planet("Wilda",   0.00001, 1800, 0.0, 40.0, 10., 0.0, 0.0046, "#64B6AC", 0.4),
        new Planet("Henrik",  0.00001, -4000, 0.0, 50, 30.0, 0.0, 0.0028, "#4F7CAC", 10.0),
        // new Planet("Alex", 0.00001, 3000, 0.0, 30, 10.0, 0.0, 0.001, "#A657AE", 0.25),

    };

    public static PopulatedVessel[] Vessel = {

    };

    public static double Xspawn = 0;
    public static double Yspawn = 0;

    public static Button[] Button = {

            new Button(30, 0, 20, 20, "#FFFFFF"),
            new Button(0, 0, 20, 20, "#FFFFFF"),

    };

    public static Player player = new Player(-4026, 0,0.0,0);

    public static void main(String[] args) {

        /** Skapar ett fönster */
        // Dimension DisplaySize = new Dimension(2000, 1000);
        System.out.println(screenSize.getHeight() + " | " + screenSize.getWidth());
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenSize);
        frame.setVisible(true);
        frame.add(p);
        frame.add(r);
        frame.addMouseListener(new Mouse());

        /**
         * Startar Gameloop: - Fixa en redig gameloop - Fps mätare
         */

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
        while (1 == 1) {

            try {
                Thread.sleep(TimeSpeed);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

            if(running){
                if(Play_State){
                    r.setVisible(true);
                    p.setVisible(false);
                    Collision.Planets();
                    Update.runRenderUpdate();
                    Update.runViewUpdate();
                }else{
                    r.setVisible(false);
                    p.setVisible(true);
                }
            }

        }
    }
    
}