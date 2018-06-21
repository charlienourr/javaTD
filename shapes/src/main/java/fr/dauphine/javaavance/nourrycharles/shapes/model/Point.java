package fr.dauphine.javaavance.nourrycharles.shapes.model;


/**
 * Hello world!
 *
 */
public class Point implements Shapes
{
    private double x;
    private double y;

    public Point(double xValue,double yValue){
        x=xValue;
        y=yValue;
    }

    public Point(Point p){
        x=p.x;
        y=p.y;
    }

    public double getx() {
        return x;
    }

    public double gety() {
        return y;
    }

    public  String toString(){
        return "("+x+","+y+")";
    }

    public boolean isSameAs(Point p){
        return x==p.x && y==p.y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (Double.compare(point.x, x) != 0) return false;
        return Double.compare(point.y, y) == 0;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(x);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public Point translate(double dx, double  dy){
        return new Point(x+dx,y+dy);
    }

    /*@Override
    public void paintComponent(Graphics graphics) {

        graphics.fillOval((int)x,(int)y,2,2);
    }*/

    public static void main(String[] args )
    {
        /*Point p1=new Point(1,2);
        Point p2=p1;
        Point p3=new Point(1,2);
        ArrayList<Point> list = new ArrayList<>();
        list.add(p1);
        System.out.println(list.indexOf(p2));
        System.out.println(list.indexOf(p3));

        LigneBrisee liste = new LigneBrisee();
        //System.out.println(list.tab.length);
        liste.add(new Point(1,2));
        liste.add(new Point(2,2));
        liste.add(new Point(3,2));
        //list.add(new Point(4,2));
        //list.add(new Point(5,2));
        //list.add(new Point(6,2));
        //list.affiche();
        System.out.println(liste.nbPoints());
        System.out.println(liste.pointCapacity());
        System.out.println(liste.contains(new Point(1,2)));
        System.out.println(liste.contains(new Point(5,5)));
        //System.out.println(list.contains(null));*/

        /*Point p=new Point(1,2);
        Circle c=new Circle(p,1);
        Circle c2=new Circle(p,2);
        c2.translate(1,1);
        System.out.println(c+" "+c2)*/

        //Circle c=new Circle(new Point(1,2), 1);
        //c.getCenter().translate(1,1);
        //System.out.println(c);//le centre se translate aussi, on doit rendre non mutable la methode translate de Point

        //System.out.println(c.surface());
        //System.out.println(c.contains(new Point(1,2)));
        //System.out.println(c.contains(new Point(1.5,2)));
        //System.out.println(c.contains(new Point(3,2)));
        //List<Circle> listOfCircle=new LinkedList<Circle>();
        //listOfCircle.add(c);
        //System.out.println(Circle.contains(new Point(4,2),listOfCircle));

        Ring r=new Ring(new Point(1,2),5,4);
        //System.out.println(r);
        System.out.println(r.contains(new Point(1,2)));
        System.out.println(r.contains(new Point(5,2)));
        System.out.println(r.contains(new Point(7,2)));
    }

    @Override
    public boolean contains(Point point) {
        return this.isSameAs(point);
    }

    @Override
    public void move(int dx, int dy) {
        this.x=dx;
        this.y=dy;
    }
}