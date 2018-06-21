
package fr.dauphine.javaavance.nourrycharles.threads;
import java.util.ArrayList;
import java.util.Random;

public class MySafeList {

    private ArrayList<Double> arrayList;
    private static final Object monitor=new Object();

    public MySafeList(){
        arrayList=new ArrayList<Double>();
        //monitor=new Object();
    }
    public synchronized int size(){
        return arrayList.size();
    }

    public Double get(int i){
        return arrayList.get(i);
    }

    public synchronized void add(Double d){
        arrayList.add(d);
    }

    public static boolean stressTest(int n, final int m) throws InterruptedException{
        final MySafeList mySafeList=new MySafeList();
        Thread[] threads=new Thread[n];

        for (int i = 0; i < n; i++) {
            Thread thread=new Thread(new Runnable() {
                public void run() {
                    for (int j = 0; j < m; j++) {
                        synchronized (monitor) {
                            mySafeList.add(0.0);
                        }
                    }
                }

            });
            threads[i]=thread;
            threads[i].start();
        }

        for (int i = 0; i < n; i++) {
            threads[i].join();
        }
        if (mySafeList.size() == n * m) {
            return true;
        }
            return false;
        }

        public static double scalar(MySafeList v1, MySafeList v2, int begin, int end){
            //long starttime = System.nanoTime();
            double res=0.0;
            if (v1.size()!=v2.size()){
                throw new IllegalArgumentException();
            }
            else {

                for (int i = 0; i < v1.size(); i++) {
                    if((i>=begin)&&(i<end)) {
                        res += v1.get(i) * v2.get(i);
                    }
                }
            }
            //System.out.println("basic scalar :"+ (System.nanoTime()-starttime));
            return res;
        }

        public static boolean scalartest(int size){
            MySafeList mySafeList1 = new MySafeList();
            MySafeList mySafeList2 = new MySafeList();
            double result=0.0;
            Random random=new Random();
            for (int i = 0; i < size; i++) {
                Double tmp=random.nextInt(size)*1.0;
                mySafeList1.add(tmp);
                Double tmp2=random.nextInt(size)*1.0;
                mySafeList2.add(tmp2);
                result+=tmp*tmp2;
            }
            return (result==scalar(mySafeList1,mySafeList2,0,size));

        }

        public static double parallelScalar(MySafeList v1, MySafeList v2, int n) throws InterruptedException{
            //long starttime = System.nanoTime();
            ScalarThread[] threads=new ScalarThread[n];
            double ret=0;
            if(v1.size()!=v2.size()){
                throw new IllegalArgumentException();
            }
            if(n>v1.size()){
                //throw new IllegalArgumentException("cannot divise list by argument n");
                n=v1.size();
            }

            for (int i = 0; i < n; i++) {
                threads[i]=new ScalarThread(v1,v2,i/n*v1.size(),(i+1)/n*v1.size());
                threads[i].run();
            }
            for (int i = 0; i < n; i++) {
                threads[i].join();
                //System.out.println(i+" eme scalarthread : "+threads[i].getResult());
                ret+=threads[i].getResult();
            }
            //System.out.println("time for scalarthreads:"+ (System.nanoTime()-starttime));
            return ret;
        }

}
