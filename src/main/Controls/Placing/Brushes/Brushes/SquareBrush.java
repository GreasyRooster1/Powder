package main.Controls.Placing.Brushes.Brushes;

import main.Registry.ElementRegistry;
import main.Util.World;

public class SquareBrush {
    public int size = 1;
    public void place(String cElement,int x,int y){
        for(int i=-size;i<=size;i++) {
            for (int j = -size; j <= size; j++) {
                World.addPart(ElementRegistry.getElementByName(cElement, x+i, y+j));
            }
        }
    }
}
