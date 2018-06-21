package fr.dauphine.javaavance.nourrycharles.threads;

public class ThreadTest{

    static int n=0;

    public synchronized Runnable runnable(final int id){
        return new Runnable() {

            public void run() {
                while(n<10000){
                    System.out.println("je suis le thread "+id+" et j'effectue l'iteration "+n);
                    n++;
                }
            }
        };
    }

    public static void main(String[] args) throws InterruptedException{
        /*Thread t1=new Thread(new ThreadTest().runnable(1));
        Thread t2=new Thread(new ThreadTest().runnable(2));
        t1.start();
        t2.start();*/


        //System.out.println(MySafeList.stressTest(5,6));
        long start = System.nanoTime();
        MySafeList mySafeList1=new MySafeList();
        MySafeList mySafeList2=new MySafeList();
        for (int i = 0; i < 1000000; i++) {
            mySafeList1.add(i*1.0);
            mySafeList2.add(i*1.0);
        }
        System.out.println(MySafeList.scalar(mySafeList1,mySafeList2,0,1000000));
        System.out.println("time : " +(System.nanoTime()-start));
        start=System.nanoTime();
        //System.out.println(MySafeList.scalartest(10));
        System.out.println(MySafeList.parallelScalar(mySafeList1,mySafeList2,2));
        System.out.println("time : "+(System.nanoTime()-start));
    }
}
