package main.Util;

import main.Element.Element;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static processing.core.PApplet.append;

public class World {
    public static int PIXEL_SIZE = 2;
    public static int LOOP_MODE = 0;
    public static boolean HEAT_VIEW = false;
    public static int WORLD_WIDTH = 1000/PIXEL_SIZE;
    public static int WORLD_HEIGHT = 1000/PIXEL_SIZE;
    public static Element[] PARTS = new Element[WORLD_WIDTH*WORLD_HEIGHT];

    public static void addPart(Element e){
        if(validPosition(e.getX(), e.getY())) {
            PARTS[worldPos(e.getX(), e.getY())] = e;
        }
    }
    public static int worldPos(int x,int y){
        return max(min((y*WORLD_WIDTH)+x,249999),0);
    }
    public static boolean validPosition(int x,int y){
        return (worldPos(x,y)<PARTS.length-1&&worldPos(x,y)>=0);
    }
}