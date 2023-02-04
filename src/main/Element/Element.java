package main.Element;

import main.Util.Applet;
import main.Util.World;
import processing.core.PApplet;

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
    private boolean indestructible;
    private int lastUpdated;

    public Element(int x, int y) {
        this.x = x;
        this.y = y;
        color = Applet.color(255, 255, 255);
        life = 100;
        heat = 0;
        ctype = "none";
        heatConductivity = 0.05f;
        indestructible = false;
        lastUpdated = -1;
    }

    public void update() {
        render();
        stateUpdate();
        elementUpdate();
        checkSides();
        checkLife();
        updateHeat();
        updateLastUpdate();
    }

    void render() {
        Applet.get().fill(color);
        if (World.HEAT_VIEW) {
            if (heat < 30_000) {
                Applet.get().fill(Applet.get().lerpColor(Applet.color(255, 255, 0), Applet.color(255, 255, 255), (heat - 8000) / 22000));
            }
            if (heat < 8000) {
                Applet.get().fill(Applet.get().lerpColor(Applet.color(255, 0, 0), Applet.color(255, 255, 0), (heat - 1000) / 7000));
            }
            if (heat < 1000) {
                Applet.get().fill(Applet.get().lerpColor(Applet.color(0, 0, 0), Applet.color(255, 0, 0), heat / 1000));
            }
        }
        Applet.get().noStroke();
        Applet.get().rect(x * World.PIXEL_SIZE, y * World.PIXEL_SIZE, World.PIXEL_SIZE, World.PIXEL_SIZE);
    }

    void checkSides() {
        if (World.LOOP_MODE == 0) {
            if (((x * World.PIXEL_SIZE)+1) >= 1000 || ((y+2) * World.PIXEL_SIZE) >= 1000 || ((x * World.PIXEL_SIZE)-1) <= 0 || ((y * World.PIXEL_SIZE)-1) <= 0) {
                kill();
            }
        }
        if (World.LOOP_MODE == 1) {
            if (x * World.PIXEL_SIZE > 1000) {
                setX(0);
            }
            if (y * World.PIXEL_SIZE > 1000) {
                setY(0);
            }
            if (x * World.PIXEL_SIZE < 0) {
                setX((1000 / World.PIXEL_SIZE)-1);
            }
            if (y * World.PIXEL_SIZE < 0) {
                setY((1000 / World.PIXEL_SIZE)-1);
            }
        }
    }

    void checkLife() {
        if (getLife() < 1) {
            kill();
        }
    }

    void updateHeat() {
        for (Element n : getNexts()) {
            if (n != null) {
                if (n.heat > heat) {
                    heat += n.heat * heatConductivity;
                    n.heat -= n.heat * heatConductivity;
                }
            }
        }
        heat *= 0.9999;
    }

    public Element getNext(int xa, int ya) {
        if (x + xa < 0 || x + xa >= World.WORLD_WIDTH || y + ya < 0 || y + ya >= World.WORLD_HEIGHT) {
            return null;
        }
        return World.PARTS[World.worldPos(x + xa, y + ya)];
    }

    public Element[] getNexts() {
        Element[] out = {getNext(-1, -1), getNext(0, -1), getNext(1, -1), getNext(-1, 0), getNext(0, 0), getNext(1, 0), getNext(-1, 1), getNext(0, 1), getNext(1, 1)};
        return out;
    }
//    public Element[] getNexts(){
//        Element[] out = {};
//        for(Element e: World.PARTS){
//            if(PApplet.dist(x,y,e.x,e.y)<=1) {
//                for (int i = -1; i <= 1; i++) {
//                    for (int j = -1; j <= 1; j++) {
//                        if (e.x == x + i && e.y == y + j) {
//                            out = (Element[]) PApplet.append(out, e);
//                        }
//                    }
//                }
//            }
//        }
//        return out;
//    }

    private void updateLastUpdate() {
        lastUpdated = Applet.get().frameCount;
    }

    public void stateUpdate() {

    }

    public void elementUpdate() {

    }

    public int getX() {
        return x;
    }

    public void setX(int xa) {
        World.PARTS[World.worldPos(x, y)] = null;
        this.x = xa;
        World.PARTS[World.worldPos(x, y)] = this;
    }

    public int getY() {
        return y;
    }

    public void setY(int ya) {
        World.PARTS[World.worldPos(x, y)] = null;
        this.y = ya;
        World.PARTS[World.worldPos(x, y)] = this;
    }

    public void setPosition(int xa, int ya) {
        World.PARTS[World.worldPos(x, y)] = null;
        this.y = ya;
        this.x = xa;
        World.PARTS[World.worldPos(x, y)] = this;
    }

    public void move(int xa, int ya) {
       setPosition(x+xa,y+ya);
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

    public void changeY(int ya) {
        setY(y+ya);
    }
    public void changeX(int xa) {
        setX(x+xa);
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

    public boolean isIndestructible() {
        return indestructible;
    }

    public void setIndestructible(boolean indestructible) {
        this.indestructible = indestructible;
    }

    public int getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(int lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
