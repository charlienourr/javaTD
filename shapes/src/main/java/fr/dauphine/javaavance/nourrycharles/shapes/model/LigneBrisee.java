package fr.dauphine.javaavance.nourrycharles.shapes.model;


import java.util.LinkedList;

public class LigneBrisee implements Shapes{
    //private Point[] tab;
    private LinkedList<Point> list;

    //public LigneBrisee(int taille){
    //    tab=new Point[taille];
    //}
    public LigneBrisee(){
        list=new LinkedList<Point>();
    }

    /*public void add(Point p){
        int i=0;
        while (tab[i]!=null && i<tab.length){
            i++;
        }
        if(i<tab.length){
            tab[i]=p;
        }
    }*/
    public void add(Point p){
        list.add(p);
    }

    /*public void affiche(){
        for (Point p:tab
             ) {
            System.out.println(p);
        }
    }*/

    /*public int pointCapacity(){
        return tab.length;
    }*/
    public int pointCapacity(){
        return list.size();
    }

    /*public int nbPoints(){
        int count=0;
        for (Point p:tab
             ) {
            if(p!=null){
                count++;
            }
        }
        return count;
    }*/
    public int nbPoints(){
        return list.size();
    }
    /*public boolean contains(Point p){
        for (Point pt:tab
             ) {
            if(pt!=null && pt.isSameAs(p)){
                return true;
            }
        }
        return false;
    }*/
    public boolean contains(Point p){
        for (Point pt:list
                ) {
            if(pt.isSameAs(p)){
                return true;
            }
        }
        return false;
    }

    public int listSize(){
        return list.size();
    }

    public Point get(int i){
        return list.get(i);
    }

    @Override
    public void move(int x, int y) {
        //to do
    }

    /*@Override
    public void paintComponent(Graphics graphics) {

        for(int i=0;i<list.size()-1;i++) {
            graphics.drawLine((int) list.get(i).getx(),(int) list.get(i).gety(), (int) list.get(i+1).getx(),(int) list.get(i+1).gety());
        }
    }*/
}
