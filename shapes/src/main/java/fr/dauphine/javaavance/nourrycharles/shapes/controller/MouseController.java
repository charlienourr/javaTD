package fr.dauphine.javaavance.nourrycharles.shapes.controller;

import fr.dauphine.javaavance.nourrycharles.shapes.model.Circle;
import fr.dauphine.javaavance.nourrycharles.shapes.model.Point;
import fr.dauphine.javaavance.nourrycharles.shapes.model.Shapes;
import fr.dauphine.javaavance.nourrycharles.shapes.model.World;
import fr.dauphine.javaavance.nourrycharles.shapes.view.MyDisplay;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;

public class MouseController extends JPanel implements java.awt.event.MouseMotionListener
{


    private int x;
    private int y;
    private World world;

    public MouseController(World world){
        init();
        this.world=world;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public void mouseDragged(MouseEvent mouseEvent) {


        //repaint();
    }

    public void init(){
        addMouseMotionListener(this);
    }

    @Override
    public void mouseMoved(MouseEvent mouseEvent) {
        setX(mouseEvent.getX());
        setY(mouseEvent.getY());

        /*for(Shapes s:world.getShapes()){
            if (s.contains(new Point(x,y))){
                s.move(10,10);
                //System.out.println(s.toString());
                //System.out.println(s.toString());
            }
        }*/
        for(int i=0;i<world.getShapes().size();i++) {
            if (world.getShapes().get(i).contains(new Point(x, y))) {
                //System.out.println(world.getShapes().get(i).toString());
                world.setValue(i, x, y);

                //if(world.hasChanged()){
                //repaint();

                //world.deleteObservers();
                //}
            }
        }

            // x = mouseEvent.getX();
       // y = mouseEvent.getY();

        //repaint();
    }

    @Override
    public void paintComponent(Graphics graphics) {
        /*graphics.clearRect(0,0,getWidth(),getHeight());
        graphics.setColor(Color.CYAN);
        graphics.fillOval(x,y,50,50);*/

    }
}
