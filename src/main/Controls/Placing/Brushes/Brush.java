package main.Controls.Placing.Brushes;

import main.Registry.ElementRegistry;
import main.Util.World;

public class Brush {
    public int size = 1;
    public void place(String cElement,int x,int y){
        World.addPart(ElementRegistry.getElementByName(cElement,x,y));
    }
}
