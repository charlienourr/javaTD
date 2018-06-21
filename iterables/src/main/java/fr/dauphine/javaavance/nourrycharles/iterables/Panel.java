package fr.dauphine.javaavance.nourrycharles.iterables;



import java.util.*;


public class Panel {


    public static Iterator<Integer> panel1(final int i,final int j){

         return new Iterator<Integer> (){
             private Integer inf=i;
             private Integer sup=j;
             private Integer courant=i-1;

             public void remove() {

             }

             public boolean hasNext() {
                 if(courant.equals(sup)) {
                     return false;
                 }
                 else{
                     return true;
                 }
             }

             public Integer next() {
                 if(hasNext()) {
                     return ++courant;
                 }
                 else{
                     return -1;
                 }

             }
         };
    }

    public static Iterable<Integer> panel2(final int i,final int j){
        return new Iterable<Integer>() {
            public Iterator<Integer> iterator() {
                return panel1(i,j);
            }
        };
    }

    public static List<Integer> panel(final int low,final int high){
        if(low>high){
            throw new IllegalArgumentException();
        }
        return new AbstractList<Integer>() {
            @Override
            public Integer get(int i) {
                return low+i;
            }

            @Override
            public int size() {
                return high-low+1;
            }
        };
    }

    public static void main(String[] args) {
        /*Iterator<Integer> it=panel1(1,5);
        for(;it.hasNext();)
        System.out.println(it.next()); // affiche 1 2 3 4 5*/

        /*for(int i:panel2(1,5))
        System.out.println(i); // affiche 1 2 3 4 5*/

        /*List<Integer> l = panel(3,6);
        for(int i:l) {
            System.out.println(i);//affiche 3 4 5 6
        }

        System.out.println("\n"+l.get(1)); //affiche 4*/

        /*List<Integer> l=new ArrayList<>();
        l.add(3);
        l.add(4);
        l.add(1);
        System.out.println(mult(5,l).get(0)+" "+mult(5,l).get(1)+" "+mult(5,l).get(2));
        System.out.println(mult(5,l).size());*/

        ArrayList<Integer> al = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            al.add(i);
        }
        long t0 = System.nanoTime();
        List<Integer> ret = Mult.mult(2, al);
        long sum=0;
        for(int val : ret) {
            sum+=val/2;
        }
        System.out.println((System.nanoTime() - t0));
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < 10000; i++) {
            ll.add(i);
        }
        t0 = System.nanoTime();
        sum=0;
        ret=Mult.mult(2,ll);
        for(int val : ret) {
            sum+=val/2;
        }
        System.out.println((System.nanoTime() - t0));
    }


}
