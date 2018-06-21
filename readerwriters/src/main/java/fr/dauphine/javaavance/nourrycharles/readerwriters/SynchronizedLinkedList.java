package fr.dauphine.javaavance.nourrycharles.readerwriters;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class SynchronizedLinkedList {
    private Object monitor = new Object();
    private List<Integer> list = new LinkedList<Integer>();

    public int size() throws InterruptedException{
        synchronized (monitor) {
            Thread.sleep(100);
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
            Thread.sleep(500);
            list.add(a);
        }
    }


    static class Reader extends Thread{
        private SynchronizedLinkedList list;

        Reader(SynchronizedLinkedList list){
            this.list = list;
        }

        public void run(){
            for(;;){
                try {
                    System.out.println("Reader thread " + getId() +
                            " accessed the list (size = " + list.size() + ")");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    static class Writer extends Thread{
        private SynchronizedLinkedList list;

        Writer(SynchronizedLinkedList list){
            this.list = list;
        }

        public void run(){
            ThreadLocalRandom rand = ThreadLocalRandom.current();
            for(;;){
                int val = rand.nextInt(100);
                try {
                    list.add(val);
                    System.out.println("Writer thread " + getId() + " has added one value to the list.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }



    public static void main(String[] args) {

        SynchronizedLinkedList list = new SynchronizedLinkedList();
        int numReaders = 3;
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