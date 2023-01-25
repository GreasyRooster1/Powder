package main.Controls;

import main.Controls.Buttons.Button;
import main.Element.Element;
import main.Registry.ElementRegistry;
import main.Registry.RegisteredElement;
import main.States.PowderState;
import main.Util.Applet;
import main.Util.Collision;
import main.Util.World;
import processing.core.PConstants;

import static processing.core.PApplet.append;

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
        if(Collision.placeFree(Applet.worldMouseX(),Applet.worldMouseY())) {
            if(Applet.get().mouseButton==PConstants.LEFT) {
                World.addPart(ElementRegistry.getElementByName(cElement, Applet.worldMouseX(), Applet.worldMouseY()));
            }
        }
        if(Applet.get().mouseButton==PConstants.RIGHT) {
            for(Element e:World.PARTS){
                if(e.getX()==Applet.worldMouseX()&&e.getY()==Applet.worldMouseY()){
                    e.kill();
                }
            }
        }
    }
    public static void toggleHeat(){
        World.HEAT_VIEW = !World.HEAT_VIEW;
    }
}
