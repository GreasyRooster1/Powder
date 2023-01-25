package main.Elements;

import main.States.LiquidState;
import main.States.PowderState;
import main.Util.Applet;

public class Water extends LiquidState {
    public Water(int x, int y) {
        super(x, y);
        setName("water");
        setColor(Applet.color(0, 0, 255));
        setHeatConductivity(0.0598f);
    }
}
