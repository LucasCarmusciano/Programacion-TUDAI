package Programacion3.tp4.tp4_1.Iteradores;

import java.util.Iterator;

import Programacion3.tp4.tp4_1.*;

public class IteradorArco<T> implements Iterator<Arco<T>>{

    private Integer verticeActual;
    private Iterator<Integer> vertices;
    private Iterator<Arco<T>> arcos;
    private Grafo<T> grafo;

    public IteradorArco(GrafoDirigido<T> grafoDirigido){
        this.grafo=grafoDirigido;
        this.vertices = grafoDirigido.obtenerVertices();
        this.verticeActual = vertices.next();
        this.arcos=grafoDirigido.obtenerArcos(verticeActual);
    }

    @Override
    public boolean hasNext() {
        if(arcos.hasNext()){
            return true;
        }
        else if(vertices.hasNext()){
            verticeActual=vertices.next();
            arcos=grafo.obtenerArcos(verticeActual);
            return this.hasNext();
        }else{
            return false;
        }
    }

    @Override
    public Arco<T> next() {
        return arcos.next();
    }
    
}