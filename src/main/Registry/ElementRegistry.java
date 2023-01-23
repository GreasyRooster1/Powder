package main.Registry;

import main.Element.Element;
import main.Elements.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Objects;

import static processing.core.PApplet.append;

public class ElementRegistry {
    public static RegisteredElement[] registry = {};

    public static void startRegister(){
        register("dust", Dust.class);
        register("wall", Wall.class);
    }

    public static Element getElementByName(String name,int x,int y) {
        Element ret = null;
        for(RegisteredElement r:registry){
            if(Objects.equals(name, r.name)){
                // no idea how this works, but it does
                try {
                    String myClassName = r.element.getName();
                    Class<?> myClass = Class.forName(myClassName);
                    Constructor<?> ctr = myClass.getConstructor(int.class, int.class);
                    Object object = ctr.newInstance(new Object[]{x, y});
                    ret = (Element) object;
                }catch(Exception ignored){

                }
            }
        }
        if(ret!=null) {
            ret.setX(x);
            ret.setY(y);
        }
        return ret;
    }
    static void register(String name, Class c){
        registry = (RegisteredElement[]) append(registry,new RegisteredElement(name,c));
    }
}
