package src2.GUI.Shapes;

import java.awt.*;

public class AABB {

    public void filled(Graphics2D g2d, String color, int x, int y, int width, int height){
        g2d.setColor(Color.decode(color));
        g2d.fillOval(x, y, width, height);
    }

    public void lined(Graphics2D g2d, String color, int x, int y, int width, int height){
        g2d.setColor(Color.decode(color));
        g2d.fillOval(x, y, width, height);
    }

}
