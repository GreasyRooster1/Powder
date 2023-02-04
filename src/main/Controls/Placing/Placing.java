package main.Controls.Placing;

import main.Controls.Placing.Brushes.Brush;
import main.Registry.ElementRegistry;
import main.Util.World;

public class Placing {
    public static Brush currentBrush = new Brush();
    public static void placeParts(String cElement,int x,int y){
        currentBrush.place(cElement,x,y);
    }
}
