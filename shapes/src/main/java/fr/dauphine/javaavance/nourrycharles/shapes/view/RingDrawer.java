package fr.dauphine.javaavance.nourrycharles.shapes.view;

import fr.dauphine.javaavance.nourrycharles.shapes.model.Ring;

import java.awt.*;

public class RingDrawer extends Drawer{

    private Ring ring;

    public RingDrawer(Ring ring) {
        this.ring = ring;
    }

    public void draw(Graphics graphics){

        graphics.setColor(Color.red);
        graphics.fillOval((int)ring.getCenter().getx()-(int)ring.getRadius(),
                (int)ring.getCenter().gety()-(int)ring.getRadius(),
                2*(int)ring.getRadius(), 2*(int)ring.getRadius());
        graphics.setColor(Color.lightGray);
        graphics.fillOval((int)ring.getCenter().getx()-(int)ring.getInternRadius(),
                (int)ring.getCenter().gety()-(int)ring.getInternRadius(),
                2*(int)ring.getInternRadius(), 2*(int)ring.getInternRadius());
        graphics.setColor(Color.black);
    }
}
