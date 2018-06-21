package fr.dauphine.javaavance.nourrycharles.generics;


import java.lang.reflect.Array;
import java.util.*;


public class Generics {



    public static <E extends Comparable<E>> E myMax(E e1,E... es){
        E e=e1;
        for (E element:es) {
            if(element.compareTo(e)>0){
                e=element;
            }
        }
        return e;
    }


    private static <E> void print(E... es) {
        for(E e:es)
            System.out.println(e);
    }

    private static <E extends CharSequence> void printCS(E... es){
        for (E e:es) {
            System.out.println(e.length());
        }
    }

    public static <T extends CharSequence> List<?> listLength(List<T> list) {
        List<Integer> length =new ArrayList<Integer>();
        for (T t:list) {
                length.add(((CharSequence) t).length());
        }
        /*ArrayList length=new ArrayList();
        for(int i=0;i<list.size();i++) {
            CharSequence seq=(CharSequence)list.get(i);
            length.add(seq.length());
        }*/
        return length;
    }


    public static <G,E extends G,F extends G>  List<G> fusion(List<E> l1, List<F> l2){
        if(l1.isEmpty() && l2.isEmpty()){return Collections.emptyList();}
        List<G> ret = new ArrayList<G>();
        Iterator<E> iterator=l1.iterator();
        Iterator<F> iterator1=l2.iterator();
        while(iterator.hasNext()){
            ret.add(iterator.next());
            if(iterator1.hasNext()){
                ret.add(iterator1.next());
            }
        }
        while(iterator1.hasNext()){
            ret.add(iterator1.next());
        }
       /* for (int i = 0; i < l1.size(); i++) {
            ret.add(l1.get(i));
            ret.add(l2.get(i));
        }*/
        return ret;
    }

    public static <E> void swap(List<E> l, int index1, int index2){
        if(index1>l.size() || index2>l.size()){
            return;
        }
        E tmp=l.get(index1);
        l.set(index1,l.get(index2));
        l.set(index2,tmp);
    }

    public static void swap(Object[] tab, int index1, int index2){
        if(index1>tab.length || index2>tab.length){
            return;
        }
        Object tmp=tab[index1];
        tab[index1]=tab[index2];
        tab[index2]=tmp;
    }

    public static <E> void shuffle(List<E> list){
        Random random=new Random();
        /*for (E e:list) {
            swap(list,random.nextInt(list.size()),random.nextInt(list.size()));
        }
        Collections.shuffle(list);*/

        int size=list.size();
        if(!(list instanceof RandomAccess)){
            Object[]tab=list.toArray();
            for(int i=size;i>1;--i){
                swap(tab,i-1,random.nextInt(size));
            }
            ListIterator listIterator=list.listIterator();
            for(int i=0;i<tab.length;++i){
                listIterator.next();
                listIterator.set(tab[i]);
            }
        } else {
            for(int i=size;i>1;--i){
                swap(list,i-1,random.nextInt(size));
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(myMax(42,1664)); //1664
        System.out.println(myMax(2014,86,13)); //2014

        System.out.println(myMax(8.6,16.64)); //16.64
        System.out.println(myMax("baa", "aba")); //baa
        //System.out.println(myMax(8.6, "aba")); / super E / ko !

        List<String> list= Arrays.asList("foo", "toto");
        List<Integer> list2= Arrays.asList(5, 6);
        print(list);
        print(list2);
        print(1,2,3,4);
        printCS("a", "al","allo");

        List l=Arrays.asList("colonel", "reyel");
        System.out.println(listLength(l));

        List<String> l1= Arrays.asList("C", "rc");
        List<StringBuilder> l2= Arrays.asList(new StringBuilder("a ma"), new StringBuilder("he!"));
        List<? extends CharSequence> r1=fusion(l1,l2);
        List<?> r2=fusion(l1,l2);
        System.out.println("r1 = "+ r1);
        System.out.println("r2 = "+ r2);
        List<Integer> l3 = Arrays.asList(1,2);
        List<Integer> l4 = Arrays.asList(10,20);
        List<Integer> r3 = fusion(l3,l4);
        List<?> r4 = fusion(l1,l3);
        System.out.println("r3 = "+ r3);
        System.out.println("r4 = " + r4);

        List<Integer> listint= Arrays.asList(0,1,2,3,4,5,6,7,8,9);
        LinkedList<Integer> linkedList=new LinkedList<Integer>();
        for (int i = 0; i < 10000; i++) {
            linkedList.add(i);
        }
        System.out.println("LinkedList " + linkedList);
        shuffle(linkedList);
        System.out.println("LinkedList shuffled" + linkedList);

    }
}
