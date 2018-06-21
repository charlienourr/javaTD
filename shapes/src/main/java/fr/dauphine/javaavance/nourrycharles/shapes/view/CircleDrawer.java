package fr.dauphine.javaavance.nourrycharles.shapes.view;

import fr.dauphine.javaavance.nourrycharles.shapes.model.Circle;

import java.awt.*;

public class CircleDrawer extends Drawer {

    private Circle circle;
    public CircleDrawer(Circle c) {
        circle=c;
    }
    public void draw(Graphics graphics){
        graphics.setColor(Color.blue);
        graphics.fillOval((int)circle.getCenter().getx()-((int)circle.getRadius()),
                (int)circle.getCenter().gety()-((int)circle.getRadius()),
                2*(int)circle.getRadius(), 2*(int)circle.getRadius());
    }
}
