package main.States;

import main.Element.Element;
import main.Util.Applet;
import main.Util.Collision;
import processing.core.PApplet;

public class LiquidState extends Element {
    public LiquidState(int x, int y) {
        super(x, y);
    }
    @Override
    public void stateUpdate(){
        if(Collision.placeFree(getX(),getY()+1)) {
            changeY(1);
        }else{
            if(PApplet.round(Applet.get().random(0,1))==0) {
                if(Collision.placeFree(getX()+1,getY()+1)) {
                    changeY(1);
                    changeX(1);
                }else if(Collision.placeFree(getX()+1,getY())){
                    changeX(1);
                }
            }else{
                if(Collision.placeFree(getX()-1,getY()+1)) {
                    changeY(1);
                    changeX(-1);
                }else if(Collision.placeFree(getX()-1,getY())){
                    changeX(-1);
                }
            }
        }
    }
}
