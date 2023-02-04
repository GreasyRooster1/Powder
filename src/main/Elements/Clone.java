package main.Elements;

import main.Element.Element;
import main.Registry.ElementRegistry;
import main.States.SolidState;
import main.Util.Applet;
import main.Util.Collision;
import main.Util.World;
import processing.core.PApplet;

import java.util.Objects;

public class Clone extends SolidState {
    public Clone(int x, int y) {
        super(x, y);
        setName("clone");
        setColor(Applet.color(59, 17, 186));
        setHeatConductivity(0.05f);
        setIndestructible(true);
    }
    public void elementUpdate() {
        for(Element e:getNexts()){
            if(Objects.equals(getCtype(), "none") &&e!=null){
                if(!e.isIndestructible()) {
                    setCtype(e.getName());
                }
            }
        }
        if(!Objects.equals(getCtype(), "none")){
            int px = getX()+PApplet.round(Applet.get().random(-1,1));
            int py = getY()+PApplet.round(Applet.get().random(-1,1));
            if(Collision.placeFree(px,py)){
                World.addPart(ElementRegistry.getElementByName(getCtype(),px,py));
            }
        }
    }
}
