package src2.Main;

public class GameLoop implements Runnable{

    private Thread thread;

    public synchronized void start(){
        Display.Running = true;
        this.thread = new Thread(this, "Display");
        this.thread.start();
    }

    public synchronized void stop(){
        Display.Running = false;
        try{
            this.thread.join();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {

        long lastTime = System.nanoTime();
        long timer = System.currentTimeMillis();
        final double ns = 1000000000.0 / 30;
        double delta = 0;
        int frames = 0;

        while(Display.Running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while (delta >= 1) {
                Update.update();
                delta--;
            }
            Display.r.update();
            frames++;

            if (System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                Display.frame.setTitle(Display.Title + " | fps: " + frames);
                frames = 0;
            }
        }

    }
}
