package main.Util;

import main.Element.Element;

import static processing.core.PApplet.append;

public class World {
    public static int PIXEL_SIZE = 5;
    public static int LOOP_MODE = 0;
    public static boolean HEAT_VIEW = true;
    public static Element[] PARTS = {};

    public static void addPart(Element e){
        PARTS = (Element[]) append(PARTS,e);
    }
}
