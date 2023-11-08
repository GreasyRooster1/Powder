package main.Controls.Buttons;

import main.Controls.Controls;
import main.Element.Element;
import main.Registry.ElementRegistry;
import main.Util.Applet;
import main.Util.Collision;
import processing.core.PConstants;

public class ClearButton extends Button{
    private float x;
    private float y;
    private Element element;
    public ClearButton(float x, float y){
        super(x,y,"dust");
        this.x = x;
        this.y = y;
    }
    public void update(){
        render();
        checkClick();
    }
    void render(){
        Applet.get().fill(0);
        Applet.get().stroke(255);
        Applet.get().strokeWeight(5);
        Applet.get().rect(x,y,50,30);
        Applet.get().stroke(255,0,0);
        Applet.get().line(x,y,x+50,y+30);
        Applet.get().line(x,y+30,x+50,y);
        Applet.get().noStroke();
    }
    void checkClick(){
        if(Applet.get().mousePressed){
            if(Applet.get().mouseButton== PConstants.LEFT) {
                if (Collision.rect(Applet.get().mouseX, Applet.get().mouseY, 1, 1, x, y, 50, 30)) {
                    Controls.clear = true;
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
