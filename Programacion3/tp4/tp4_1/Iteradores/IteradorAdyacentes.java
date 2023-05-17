package Programacion3.tp4.tp4_1.Iteradores;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import Programacion3.tp4.tp4_1.*;

public class IteradorAdyacentes<T> implements Iterator<Integer>{

    private Iterator<Arco<T>> iterador;

    public IteradorAdyacentes(HashMap<Integer, List<Programacion3.tp4.tp4_1.Arco<T>>> vertices, int v){
        this.iterador=vertices.get(v).iterator();
    }

    @Override
    public boolean hasNext() {
        return iterador.hasNext();
    }

    @Override
    public Integer next() {
        return iterador.next().getVerticeDestino();
    }
    
}
