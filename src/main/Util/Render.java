package main.Util;

import main.Controls.Buttons.Button;
import main.Controls.Controls;
import main.Element.Element;
import processing.core.PApplet;

public class Render {
    public static void mainRendering(){
        partUpdating();
        buttonUpdating();
        drawFps();
    }
    static void partUpdating(){
        for(Element e : World.PARTS) {
            if(e==null){continue;}
            if (!e.isDead()) {
                if(e.getLastUpdated()!=Applet.get().frameCount) {
                    e.update();
                }
            }else{
                World.PARTS[World.worldPos(e.getX(),e.getY())] = null;
            }
        }
    }
    static void buttonUpdating(){
        for(Button b : Controls.buttons){
            b.update();
        }
    }
    static void drawFps(){
        Applet.get().fill(255);
        Applet.get().text("FPS: "+Applet.get().frameRate,10,10);
        Applet.get().text("Parts: "+World.PARTS.length,10,20);
    }
}
