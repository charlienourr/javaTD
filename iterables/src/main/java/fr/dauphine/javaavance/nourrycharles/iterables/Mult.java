package fr.dauphine.javaavance.nourrycharles.iterables;

import java.util.*;

public class Mult {

    public static List<Integer> mult(final int coef, final List<Integer> list){


        if(list instanceof LinkedList){
            return new AbstractSequentialList<Integer>() {
                @Override
                public Iterator iterator() {
                    return new Iterator() {
                        Iterator<Integer> iterator = list.iterator();
                        @Override
                        public void remove() {
                        }
                        @Override
                        public boolean hasNext() {
                            return iterator.hasNext();
                        }
                        @Override
                        public Object next() {
                            if (iterator.hasNext()) {
                                return coef*iterator.next();
                            }
                            return null;
                        }
                    };
                }
                @Override
                public ListIterator<Integer> listIterator(final int i) {

                    int courant=list.size();
                    ListIterator<Integer> it =list.listIterator();
                    while(it.hasNext()){
                        it.set(it.next()*coef);
                    }
                    while(i<courant--){
                        it.previous();
                    }

                    return it;
                }
                @Override
                public int size() {
                    return list.size();
                }

            };


        }

        else {
            return new AbstractList<Integer>() {
                @Override
                public Integer get(int i) {
                    return list.get(i) * coef;
                }

                @Override
                public int size() {
                    return list.size();
                }
            };
        }
    }

}
