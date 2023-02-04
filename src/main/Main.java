package main;

import main.Controls.Controls;
import main.Registry.ElementRegistry;
import main.Util.Applet;
import main.Util.Render;
import processing.core.PApplet;

import static main.Controls.Controls.toggleLoop;

public class Main extends PApplet {
    public void setup(){
        Applet.set(this);
        ElementRegistry.startRegister();
        Controls.setupButtons();
        frameRate(60);
    }
    public void settings(){
        size(1000,1030);
    }
    public void draw(){
        background(0);
        Render.mainRendering();
        Controls.main();
    }
    public static void main(String[] args) {
        PApplet.main("main.Main");
    }
    public void keyReleased(){
        if(key=='h'){
            Controls.toggleHeat();
        }
        if(key=='l') {
            Controls.toggleLoop();
        }
    }
}