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
    private float heat;
    private boolean dead = false;
    private float heatConductivity;
    public Element(int x, int y){
        this.x = x;
        this.y = y;
        color = Applet.color(255,255,255);
        life = 100;
        heat = 0;
        ctype="none";
        heatConductivity = 0.05f;
    }

    public void update(){
        render();
        stateUpdate();
        elementUpdate();
        checkSides();
        checkLife();
        updateHeat();
    }

    void render(){
        Applet.get().fill(color);
        if(World.HEAT_VIEW){
            if(heat<10_000) {
                Applet.get().fill(Applet.get().lerpColor(Applet.color(255,255,0),Applet.color(255,255,255),(heat-5000)/5000));
            }
            if(heat<5000) {
                Applet.get().fill(Applet.get().lerpColor(Applet.color(255,0,0),Applet.color(255,255,0),(heat-1000)/4000));
            }
            if(heat<1000) {
                Applet.get().fill(Applet.get().lerpColor(Applet.color(0,0,0),Applet.color(255,0,0),heat/1000));
            }
        }
        Applet.get().noStroke();
        Applet.get().rect(x*World.PIXEL_SIZE,y*World.PIXEL_SIZE, World.PIXEL_SIZE,World.PIXEL_SIZE);
    }

    void checkSides(){
        if(World.LOOP_MODE==0){
            if(x*World.PIXEL_SIZE>1000&&y*World.PIXEL_SIZE>1000&&x*World.PIXEL_SIZE<0&&y*World.PIXEL_SIZE<0){
                kill();
            }
        }
        if(World.LOOP_MODE==1){
            if(x*World.PIXEL_SIZE>1000){
                x=0;
            }
            if(y*World.PIXEL_SIZE>1000){
                y=0;
            }
            if(x*World.PIXEL_SIZE<0){
                x=1000;
            }
            if(y*World.PIXEL_SIZE<0){
                y=1000;
            }
        }
    }

    void checkLife(){
        if(getLife()<1){
            kill();
        }
    }

    void updateHeat(){
        for(Element n:getNexts()){
            if(n!=null){
                if(n.heat>heat){
                    heat+=n.heat*heatConductivity;
                    n.heat-=n.heat*heatConductivity;
                }
            }
        }
        heat*=0.9999;
    }

    Element getNext(int xa,int ya){
        for(Element e:World.PARTS){
            if(e.x==x+xa&&e.y==y+ya){
                return e;
            }
        }
        return null;
    }

    Element[] getNexts(){
        Element[] out = {getNext(-1,-1),getNext(0,-1),getNext(1,-1),getNext(-1,0),getNext(0,0),getNext(1,0),getNext(-1,1),getNext(0,1),getNext(1,1)};
        return out;
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

    public float getHeat() {
        return heat;
    }

    public void setHeat(float heat) {
        this.heat = heat;
    }

    public float getHeatConductivity() {
        return heatConductivity;
    }

    public void setHeatConductivity(float heatConductivity) {
        this.heatConductivity = heatConductivity;
    }
}
