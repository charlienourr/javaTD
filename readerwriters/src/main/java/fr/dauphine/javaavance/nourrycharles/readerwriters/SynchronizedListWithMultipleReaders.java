package fr.dauphine.javaavance.nourrycharles.readerwriters;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SynchronizedListWithMultipleReaders {

    private List<Integer> list = new LinkedList<Integer>();
    private static Object monitor = new Object();
    private static int numReaders = 0;
    private static int numWriters = 0;

    public static void beginRead() throws InterruptedException{
        synchronized (monitor){
            while (numWriters>0){
                monitor.wait();
            }
            numReaders++;
        }
    }

    public static void endRead() throws InterruptedException{
        synchronized (monitor){
            if(--numReaders == 0) monitor.notifyAll() ;
        }
    }

    public static void beginWrite() throws InterruptedException{
        synchronized (monitor){
            while (numReaders>0 || numWriters>0){
                monitor.wait();
            }
            numWriters++;
        }
    }

    public static void endWrite() throws InterruptedException {
        synchronized (monitor){
            if(--numWriters == 0) monitor.notifyAll() ;
        }
    }

    public int size() throws InterruptedException{
        synchronized (monitor) {
            Thread.sleep(10);
            return list.size();
        }
    }

    public Integer get(int a){
        synchronized(monitor) {
            return list.get(a);
        }

    }

    public void add(int a) throws InterruptedException{
        synchronized(monitor){
            Thread.sleep(50);
            list.add(a);
        }
    }


    static class Reader extends Thread{
        private SynchronizedListWithMultipleReaders list;

        Reader(SynchronizedListWithMultipleReaders list){
            this.list = list;
        }

        public void run(){
            for(;;){
                try {
                    beginRead();
                    System.out.println("Reader thread " + getId() +
                            " accessed the list (size = " + list.size() + ")");
                    endRead();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    static class Writer extends Thread{
        private SynchronizedListWithMultipleReaders list;

        Writer(SynchronizedListWithMultipleReaders list){
            this.list = list;
        }

        public void run(){
            ThreadLocalRandom rand = ThreadLocalRandom.current();
            for(;;){
                int val = rand.nextInt(100);
                try {
                    beginWrite();
                    list.add(val);
                    System.out.println("Writer thread " + getId() + " has added one value to the list.");
                    endWrite();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {

        SynchronizedListWithMultipleReaders list = new SynchronizedListWithMultipleReaders();
        int numReaders = 100;
        int numWriters = 1;

        Thread[] threads = new Thread[numReaders + numWriters];

        for(int i = 0; i < numReaders; i++){
            threads[i] = new Reader(list);
            threads[i].start();
        }
        for(int i = 0; i < numWriters; i++){
            int tid = numReaders + i;
            threads[tid] = new Writer(list);
            threads[tid].start();
        }

    }
}
