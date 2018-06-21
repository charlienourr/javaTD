package fr.dauphine.javaavance.nourrycharles.iterables;

import java.util.Iterator;

public class Intervale implements Iterator<Integer>{
    private Integer inf;
    private Integer sup;


    public void remove() {

    }

    private Integer courant;


    public Intervale(Integer inf, Integer sup){
        this.inf=inf;
        this.sup=sup;
        this.courant=inf-1;
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
        return ++courant;
    }
}
