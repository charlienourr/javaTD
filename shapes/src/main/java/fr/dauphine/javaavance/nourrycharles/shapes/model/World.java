package fr.dauphine.javaavance.nourrycharles.shapes.model;

import java.util.ArrayList;
import java.util.Observable;

public class World extends Observable{
    ArrayList<Shapes> shapes;

    public ArrayList<Shapes> getShapes() {
        return shapes;
    }

    public World(){
        shapes=new ArrayList<Shapes>();
    }
    public void add(Shapes s){
        shapes.add(s);
    }

    public void setValue(int i, int x,int y){
        if(i<this.shapes.size()){
            this.shapes.get(i).move(x,y);
            this.setChanged();
            notifyObservers(shapes);
        }
    }
}
