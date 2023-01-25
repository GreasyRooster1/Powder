package main.Elements;

import main.States.GasState;
import main.States.PowderState;
import main.Util.Applet;

public class Fire extends GasState {
    public Fire(int x, int y) {
        super(x, y);
        setName("fire");
        setColor(Applet.color(255,0,0));
        setHeat(1200);
        setHeatConductivity(0.05f);
    }
    public void elementUpdate(){
        setLife((int) (getLife()-Applet.get().random(0,2)));
        setColor(Applet.get().lerpColor(Applet.color(255,0,0),Applet.color(255,255,0),getLife()/100f));
    }
}
