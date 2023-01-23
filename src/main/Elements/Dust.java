package main.Elements;

import main.States.PowderState;
import main.Util.Applet;

public class Dust extends PowderState {
    public Dust(int x, int y) {
        super(x, y);
        setName("dust");
        setColor(Applet.color(255, 218, 166));
    }
}
