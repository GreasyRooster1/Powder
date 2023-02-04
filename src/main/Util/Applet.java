package main.Util;

import processing.core.PApplet;

public class Applet {
    public static PApplet applet;
    public static PApplet get(){
        return applet;
    }
    public static void set(PApplet a){
        applet = a;
    }
    public static int color(float r,float g,float b){
        return applet.color(r,g,b);
    }
    public static int worldMouseX(){
        return Applet.get().mouseX/World.PIXEL_SIZE;
    }
    public static int worldMouseY(){
        return Applet.get().mouseY/World.PIXEL_SIZE;
    }
    public static int worldpMouseX(){
        return Applet.get().pmouseX/World.PIXEL_SIZE;
    }
    public static int worldpMouseY(){
        return Applet.get().pmouseY/World.PIXEL_SIZE;
    }
}
