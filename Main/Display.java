package Main;

import javax.swing.JFrame;
import java.awt.Toolkit;

import Objects.*;
import Listeners.*;

import java.awt.Dimension;

public class Display {


    public static double TimeSpeed = 1;
    public static double dt = 3;
    public static boolean running = true;
    public static double WorldZoom = 0.4;
    public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    public static int WorldY = (int)-screenSize.getHeight()/2;
    public static int WorldX = (int)-screenSize.getWidth()/2;

    public static JFrame frame;
    static Render r = new Render();

    // public static Planet[] Body;
    public static Planet[] Body = {

        new Planet("Sun",0.00001, 0.0, 0.0, 300.0, 1600, 0.0, 0.0, "#FFD151"),      //SOLEN
        new Planet("P1", 0.00001, 0.0, -500.0, 8.0, 0.02, 0.01, 0.0, "#656176"),
        new Planet("P2", 0.00001, 0.0, 800.0, 20.0, 0.2, 0.01, 0.0, "#F1856A"),

    };

    
    public static int PMAKE_X = 20;
    public static int PMAKE_Y = 20;
    public static double Xspawn = 0;
    public static double Yspawn = 0;

    public static Button[] Button = {
        
        new Button(PMAKE_X + 0, PMAKE_Y + 0, 20, 20, "#FFFFFF"),
        new Button(PMAKE_X + 0, PMAKE_Y + 60, 20, 20, "#FFFFFF"),

        new Button(PMAKE_X + 30, PMAKE_Y + 0, 20, 20, "#FFFFFF"),
        new Button(PMAKE_X + 30, PMAKE_Y + 60, 20, 20, "#FFFFFF"),

        new Button(PMAKE_X + 60, PMAKE_Y + 0, 20, 20, "#FFFFFF"),
        new Button(PMAKE_X + 60, PMAKE_Y + 60, 20, 20, "#FFFFFF"),

        new Button(PMAKE_X + 90, PMAKE_Y + 0, 20, 20, "#FFFFFF"),
        new Button(PMAKE_X + 90, PMAKE_Y + 60, 20, 20, "#FFFFFF"),

        new Button(PMAKE_X + 120, PMAKE_Y + 0, 20, 20, "#FFFFFF"),
        
    };

    public static void main(String[] args) {

        /** Skapar ett fönster */
        // Dimension DisplaySize = new Dimension(2000, 1000);
        System.out.println(screenSize.getHeight() + " | " + screenSize.getWidth());
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(screenSize);
        frame.setVisible(true);
        frame.add(r);
        frame.addMouseListener(new Mouse());

        /** Startar Gameloop:
         * - Fixa en redig gameloop
         * - Fps mätare
        */

        start();
    }

    public static void start(){
        running = true;
        run();
    }

    public static void stop(){
        running = false;
    }

    public static void run(){
        while (running) { 

            try {
                Thread.sleep((int)TimeSpeed);
            } catch (InterruptedException e) {
                System.out.println("Error in Thread.sleep");
                e.printStackTrace();
            }

            Update.run();

        }
    }
    
}