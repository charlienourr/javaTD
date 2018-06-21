package fr.dauphine.javaavance.nourrycharles.shapes.view;

import fr.dauphine.javaavance.nourrycharles.shapes.controller.MouseController;
import fr.dauphine.javaavance.nourrycharles.shapes.model.*;
import fr.dauphine.javaavance.nourrycharles.shapes.model.Point;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class MyDisplay extends JPanel implements Observer {

    private ArrayList<Drawer> drawing;
    private World world;

    public MyDisplay(World world){
        drawing=new ArrayList<Drawer>();
        this.world=world;

    }

    public void add(Drawer drawer){
        drawing.add(drawer);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        //graphics.drawLine(0, 0, this.getWidth(), this.getHeight());
        //graphics.drawLine(0, this.getHeight(), this.getWidth(), 0);
        //super.paintComponent(graphics);
        graphics.clearRect(0,0,getWidth(),getHeight());
        for (Drawer d:drawing
             ) {
            d.draw(graphics);
        }
    }

    public static void main(String []args){

        JFrame frame = new JFrame("Java Avance - Graphic Display");

        frame.setSize(new Dimension(500,500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        World world=new World();
        MyDisplay d = new MyDisplay(world);
        world.addObserver(d);

        MouseController mouseController = new MouseController(world);
        frame.addMouseMotionListener(mouseController);

        Circle c1=new Circle(new Point(frame.getWidth()/2,frame.getHeight()/2),200);
        CircleDrawer c= new CircleDrawer(c1);
        d.add(c);
        world.add(c1);

        Ring ring=new Ring(new Point(400,400),50,25);
        RingDrawer ringDrawer=new RingDrawer(ring);
        d.add(ringDrawer);
        world.add(ring);

        Point point=new Point(50,400);
        PointDrawer pointDrawer=new PointDrawer(point);
        d.add(pointDrawer);
        world.add(point);

        LigneBrisee lb=new LigneBrisee();
        lb.add(new Point(10,10));
        lb.add(new Point(50,50));
        lb.add(new Point(10,200));
        lb.add(new Point(200,200));
        LigneBriseeDrawer lbd =new LigneBriseeDrawer(lb);
        d.add(lbd);
        world.add(lb);

        frame.add(d);

        //frame.add(c2);
        //frame.add(c);
        //frame.add(d);
        //frame.setVisible(true);

        //Sets the operation that will happen by default when the user initiates a "close" on this frame.
        //EXIT_ON_CLOSE (defined in JFrame): Exit the application using the System exit method. Use this only in applications.


        //frame.setSize(new Dimension(100,100));

        frame.setVisible(true);
    }

    @Override
    public void update(Observable observable, Object o) {
        repaint();
        /*for(Shapes s:world.getShapes()){
            if()
        }*/
        /*RingDrawer rd1=new RingDrawer((Ring)o);
        drawing.add(rd1);
        repaint();*/
    }
}
