package main.Controls.Buttons;

import main.Controls.Controls;
import main.Element.Element;
import main.Registry.ElementRegistry;
import main.Registry.RegisteredElement;
import main.Util.Applet;
import main.Util.Collision;
import processing.core.PConstants;

public class Button {
    private float x;
    private float y;
    private Element element;
    public Button(float x, float y, String r){
        this.x = x;
        this.y = y;
        element = ElementRegistry.getElementByName(r,0,0);
    }
    public void update(){
        render();
        checkClick();
    }
    void render(){
        Applet.get().fill(element.getColor());
        Applet.get().rect(x,y,50,30);
    }
    void checkClick(){
        if(Applet.get().mousePressed){
            if(Applet.get().mouseButton== PConstants.LEFT) {
                if (Collision.rect(Applet.get().mouseX, Applet.get().mouseY, 1, 1, x, y, 50, 30)) {
                    Controls.cElement = element.getName();
                }
            }
        }
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
}
