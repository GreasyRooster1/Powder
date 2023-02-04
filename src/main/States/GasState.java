package main.States;

import main.Element.Element;
import main.Util.Applet;
import main.Util.Collision;
import processing.core.PApplet;

public class GasState extends Element {
    public GasState(int x, int y) {
        super(x, y);
    }
    public void stateUpdate(){
        if(PApplet.round(Applet.get().random(0,3))==0) {
            if (PApplet.round(Applet.get().random(0, 1)) == 0) {
                if(Collision.placeFree(getX()-1,getY())) {
                    changeX(-1);
                }
            } else {
                if(Collision.placeFree(getX()+1,getY())) {
                    changeX(1);
                }
            }
        }
        if(Collision.placeFree(getX(),getY()-1)) {
            changeY(-1);
        }else{
            if(PApplet.round(Applet.get().random(0,1))==0) {
                if(Collision.placeFree(getX()+1,getY()-1)) {
                    move(1,-1);
                }else if(Collision.placeFree(getX()+1,getY())){
                    changeX(1);
                }
            }else{
                if(Collision.placeFree(getX()-1,getY()-1)) {
                    move(-1,-1);
                }else if(Collision.placeFree(getX()-1,getY())){
                    changeX(-1);
                }
            }
        }
    }
}
