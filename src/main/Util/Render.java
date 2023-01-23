package main.Util;

import main.Controls.Buttons.Button;
import main.Controls.Controls;
import main.Element.Element;
import processing.core.PApplet;

public class Render {
    public static void mainRendering(){
        partUpdating();
        buttonUpdating();
    }
    static void partUpdating(){
        for(Element e : World.PARTS) {
            if (!e.isDead()) {
                e.update();
            }
        }
        Element[] out = {};
        for (Element e : World.PARTS) {
            if(!e.isDead()){
                out = (Element[]) PApplet.append(out,e);
            }
        }
        World.PARTS=out;
    }
    static void buttonUpdating(){
        for(Button b : Controls.buttons){
            b.update();
        }
    }
}
