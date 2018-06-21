package fr.dauphine.javaavance.nourrycharles.shapes.view;

import fr.dauphine.javaavance.nourrycharles.shapes.model.Point;

import java.awt.*;

public class PointDrawer extends Drawer {
    private Point point;

    public PointDrawer(Point p) {
        point=p;
    }

    public void draw(Graphics g){
        g.fillOval((int)point.getx(),(int)point.gety(),2,2);
    }

}
