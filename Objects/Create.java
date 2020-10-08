package Objects;

import Main.*;


public class Create {
    static int Bodyindex = 3;
    // String name, double d, double m, double ax, double ay
    public static void Planet(double x, double y){
        // Display.Body[Display.Body.length + 1] = new Planet(name, 0.00001, x, y, d, m, ax, ay, "#FFFFFF");
        Display.Body[Bodyindex] = new Planet("P" + Display.Body.length + 1, 0.00001, x, y, 20.0, 0.2, 0.01, 0.0, "#FFFFFF");
        System.out.println(Display.Body[Display.Body.length]);
        Bodyindex+=1;

    }

}
