package main.Element;

import main.Util.Applet;
import main.Util.World;

public class Element {
    private int x;
    private int y;
    private int color;
    private int life;
    private String ctype;
    private String name;
    private String desc;
    private boolean dead = false;
    public Element(int x, int y){
        this.x = x;
        this.y = y;
        color = Applet.color(255,255,255);
        life = 100;
        ctype="none";
    }

    public void update(){
        render();
        stateUpdate();
        elementUpdate();
    }

    void render(){
        Applet.get().fill(color);
        Applet.get().noStroke();
        Applet.get().rect(x*World.PIXEL_SIZE,y*World.PIXEL_SIZE, World.PIXEL_SIZE,World.PIXEL_SIZE);
    }

    public void stateUpdate(){

    }
    public void elementUpdate(){

    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getCtype() {
        return ctype;
    }

    public void setCtype(String ctype) {
        this.ctype = ctype;
    }

    public void changeY(int y) {
        this.y += y;
    }
    public void changeX(int x) {
        this.x += x;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public boolean isDead() {
        return dead;
    }

    public void kill() {
        this.dead = true;
    }
}
