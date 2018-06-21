package fr.dauphine.javaavance.nourrycharles.shapes.model;

import java.util.List;

public class Ring implements Shapes{
    private Point center;
    private double radius;
    private double internRadius;


    public Ring(Point p, double rad, double intrzd){
        center=p;
        radius=rad;
        internRadius=intrzd;
    }

    @Override
    public boolean equals(Object o){
        if (!(o instanceof Ring)){
            return false;
        }
        Ring r=(Ring) o;
        return radius==r.radius && internRadius==r.internRadius && center.isSameAs(r.center);
    }

    public boolean contains(Point p){
        return radius>=Math.sqrt((p.getx()-center.getx())*(p.getx()-center.getx())+(p.gety()-center.gety())*
                        (p.gety()-center.gety())) && internRadius<=Math.sqrt((p.getx()-center.getx())*
                (p.getx()-center.getx())+(p.gety()-center.gety())*(p.gety()-center.gety()));
    }

    @Override
    public void move(int x, int y) {
        center.move(x,y);
    }

    public boolean contains(Point p, List<Ring> list){
        for (Ring r:list
                ) {
            if(r.contains(p)){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        return "[center: "+center.toString()+", radius: "+radius+", internRadius: "+internRadius+"]";
    }

    public Point getCenter() {
        return center;
    }

    public double getRadius() {
        return radius;
    }

    public double getInternRadius() {
        return internRadius;
    }

    /*@Override
    public void paintComponent(Graphics graphics) {
        //graphics.drawCircle; //to do
        graphics.setColor(Color.black);
        //System.out.println(getWidth());
        //System.out.println(getHeight());
        //graphics.setColor(Color.BLUE);
        graphics.fillOval((int)(this.getWidth()/2-radius/2), (int)(this.getHeight()/2-radius/2), (int)radius, (int)radius);
        graphics.setColor(Color.lightGray);
        graphics.fillOval((int)(this.getWidth()/2-internRadius/2), (int)(this.getHeight()/2-internRadius/2),
                (int)internRadius, (int)internRadius);
    }*/
}