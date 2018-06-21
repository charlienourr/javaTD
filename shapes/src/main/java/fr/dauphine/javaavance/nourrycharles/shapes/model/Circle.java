package fr.dauphine.javaavance.nourrycharles.shapes.model;


import java.util.List;

public class Circle implements Shapes{

    private Point center;
    private double radius;

    public Circle(Point p, double r){
        Point pt=new Point(p);
        center=pt;
        radius=r;
    }

    public String toString(){
        return "( center: "+center.toString() + ", radius: " + radius+")";
    }

    public Point getCenter(){
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public void translate(int dx, int dy){
        center.translate(dx,dy);
    }
    public double surface(){
        return Math.PI*radius*radius;
    }

    @Override
    public void move(int x, int y) {
        center.move(x,y);
    }

    public boolean contains(Point p){
        return radius>=Math.sqrt((p.getx()-center.getx())*(p.getx()-center.getx())
                +(p.gety()-center.gety())*(p.gety()-center.gety()));
    }

    public static boolean contains(Point p, List<Circle> list){
        for (Circle c: list
                ) {
            if(c.contains(p)){
                return true;
            }
        }
        return false;
    }

    /*@Override
    public void paintComponent(Graphics graphics) {
        //graphics.drawCircle; //to do
        //System.out.println(getWidth());
        //System.out.println(getHeight());
        //graphics.setColor(Color.BLUE);
        graphics.fillOval((int)center.getx(), (int)center.gety(), (int)radius, (int)radius);
    }*/
}