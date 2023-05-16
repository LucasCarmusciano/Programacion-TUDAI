package Programacion3.tp1.tp1_6;

import java.util.Iterator;

public class Iterador<T> implements Iterator<T>{
    private Node<T> pos;
    
    public Iterador(Node<T> first){
        this.pos = first;
    }

    @Override
    public boolean hasNext() {
        return (pos!=null);
    }

    @Override
    public T next() {
        T obj = pos.getInfo();
        pos = pos.getNext();
        return obj;
    }
}