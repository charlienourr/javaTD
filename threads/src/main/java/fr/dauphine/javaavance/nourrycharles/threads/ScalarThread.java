package fr.dauphine.javaavance.nourrycharles.threads;

public class ScalarThread extends Thread {

    private MySafeList mySafeList1;
    private MySafeList mySafeList2;
    private int begin;
    private int end;
    private double result;

    public ScalarThread(MySafeList m1,MySafeList m2,int begin, int end){
        mySafeList1=m1;
        mySafeList2=m2;
        this.begin=begin;
        this.end=end;
    }

    @Override
    public void run() {
        result=MySafeList.scalar(mySafeList1,mySafeList2,begin,end);
    }

    public double getResult(){
        return result;
    }
}
