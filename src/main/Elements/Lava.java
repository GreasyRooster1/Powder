package main.Elements;

import main.States.LiquidState;
import main.Util.Applet;

public class Lava extends LiquidState {
    public Lava(int x, int y) {
        super(x, y);
        setName("lava");
        setColor(Applet.color(255, 106, 0));
        setHeatConductivity(0.03f);
        setViscosity(0.3f);
        setHeat(10000);
    }
}
