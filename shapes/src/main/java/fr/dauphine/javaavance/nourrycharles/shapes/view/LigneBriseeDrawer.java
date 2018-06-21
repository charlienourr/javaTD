package fr.dauphine.javaavance.nourrycharles.shapes.view;

import fr.dauphine.javaavance.nourrycharles.shapes.model.LigneBrisee;

import java.awt.*;

public class LigneBriseeDrawer extends Drawer {

    private LigneBrisee ligneBrisee;

    public LigneBriseeDrawer(LigneBrisee ligneBrisee) {
        this.ligneBrisee = ligneBrisee;
    }

    public void draw(Graphics graphics){
        for(int i=0;i<ligneBrisee.listSize()-1;i++) {
            graphics.drawLine((int) ligneBrisee.get(i).getx(),(int) ligneBrisee.get(i).gety(),
                    (int) ligneBrisee.get(i+1).getx(),(int) ligneBrisee.get(i+1).gety());
        }
    }
}
