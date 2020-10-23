package src2.Main;

public class Camera {
    public static void update(){
        setXY();
    }

    public static void setXY(){
        Display.ScreenSize = Display.frame.getSize();
        Display.WorldY = (int) -Display.frame.getHeight() / 2;
        Display.WorldX = (int) -Display.frame.getWidth() / 2;
    }
}
