package main.Controls;

import main.Controls.Buttons.Button;
import main.Controls.Placing.Placing;
import main.Element.Element;
import main.Registry.ElementRegistry;
import main.Registry.RegisteredElement;
import main.States.PowderState;
import main.Util.Applet;
import main.Util.Collision;
import main.Util.World;
import processing.core.PApplet;
import processing.core.PConstants;

import static main.Util.Collision.placeFree;
import static processing.core.PApplet.*;

public class Controls {
    public static String cElement = "dust";
    public static Button[] buttons = {};
    public static void setupButtons(){
        int i=0;
        for(RegisteredElement r: ElementRegistry.registry){
            buttons = (Button[]) append(buttons,new Button(i*50,1000,r.name));
            i++;
        }
    }
    public static void main() {
        if(Applet.get().mousePressed) {
            placeParts();
        }
    }
    public static void placeParts() {
        if(placeFree(Applet.worldMouseX(),Applet.worldMouseY())) {
            if(Applet.get().mouseButton==PConstants.LEFT) {
                Placing.placeParts(cElement, Applet.worldMouseX(), Applet.worldMouseY());
                float distance = PApplet.dist(Applet.worldMouseX(),Applet.worldMouseY(),Applet.worldpMouseY(),Applet.worldpMouseY());
                for(int i=0;i<distance;i++){
                    float val = i/distance;
                    int x = (int)lerp(round(Applet.worldpMouseX()),round(Applet.worldMouseX()),val);
                    int y = (int)lerp(round(Applet.worldpMouseY()),round(Applet.worldMouseY()),val);
                    if(placeFree(x,y)){
                        Placing.placeParts(cElement,x,y);
                    }
                }
            }
        }
        if(Applet.get().mouseButton==PConstants.RIGHT) {
            World.PARTS[World.worldPos(Applet.worldMouseX(),Applet.worldMouseY())] = null;
        }
    }
    public static void toggleHeat(){
        World.HEAT_VIEW = !World.HEAT_VIEW;
    }
    public static void toggleLoop(){
        if(World.LOOP_MODE==0) {
            World.LOOP_MODE = 1;
            return;
        }
        if(World.LOOP_MODE==1) {
            World.LOOP_MODE = 0;
        }
    }
}
