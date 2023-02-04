package main.Elements;

import main.States.PowderState;
import main.States.SolidState;
import main.Util.Applet;

public class Wall extends SolidState {
    public Wall(int x, int y) {
        super(x, y);
        setName("wall");
        setColor(Applet.color(127,127,127));
        setHeatConductivity(0.05f);
        setIndestructible(true);
    }

}
