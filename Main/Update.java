package Main;

import Listeners.*;

public class Update {

    public static int FocusedObject = 0;
    public static int countDiv = 0;

    public static void runRenderUpdate(){
        
        for (int i = 0; i < Display.Body.length; i++) {
            for (int j = 0; j < Display.Body.length; j++) {
                Display.Body[i].update(Display.Body[j]);
                Display.Body[i].attraction();
                Display.frame.repaint();
                Collision.Planets();
            }
        }
    };

    public static void runViewUpdate(){

        Display.screenSize = Display.frame.getSize();       //Updater default x and y pos
        Display.WorldY = (int)-Display.frame.getHeight()/2;
        Display.WorldX = (int)-Display.frame.getWidth()/2;

        for (int i = 0; i < Display.Body.length; i++) {
            if(i == FocusedObject){
                Display.Body[i].Focused = true;
            }else{
                Display.Body[i].Focused = false;
            }
        }
        for (int i = 0; i < Display.Body.length; i++) {
            if(i == FocusedObject){
                Display.Body[i].Focused = true;
            }else{
                Display.Body[i].Focused = false;
            }
        }

        int count = -1;
        for (int i = 0; i < Display.Body.length; i++) {
            if(Display.Body[i].Focused){
                count += 1;
            }
        }
        if(count == Display.Body.length){
            Display.WorldZoom = 0.5;
        }

        for (int i = 0; i < Display.Body.length; i++) {     //Focus
            if(Display.Body[i].Focused){
                Display.WorldY = (int)(Display.Body[i].py*Display.WorldZoom-Display.frame.getHeight()/2);
                Display.WorldX = (int)(Display.Body[i].px*Display.WorldZoom-Display.frame.getWidth()/2);
                Display.SelectedZoom = Display.Body[i].sf;
            }
        }

        //WORLD ZOOM CHANGE

        if(Display.WorldZoom != Display.SelectedZoom){
            // if(Display.WorldZoom <= Display.SelectedZoom){
            //     Display.WorldZoom += Display.zoomSpeed;
            // }
            // if(Display.WorldZoom >= Display.SelectedZoom){
            //     Display.WorldZoom -= Display.zoomSpeed;
            // }
            Display.WorldZoom = Display.SelectedZoom;
        }
        
    }

}
