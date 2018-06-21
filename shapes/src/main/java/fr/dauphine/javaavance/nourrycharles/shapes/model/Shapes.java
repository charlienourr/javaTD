package fr.dauphine.javaavance.nourrycharles.shapes.model;


public interface Shapes {
    //public void paintComponent(Graphics graphics);
    public void move(int x,int y);
    public boolean contains(Point point);

}
