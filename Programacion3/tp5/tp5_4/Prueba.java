package Programacion3.tp5.tp5_4;

import java.util.HashMap;

public class Prueba {
    public static void main(String[] args) {
        Grafo<Integer> grafo = new GrafoDirigido<>();
        Dijkstra dij = new Dijkstra<>();
        
        grafo.agregarVertice(1);
        grafo.agregarVertice(2);
        grafo.agregarVertice(3);
        grafo.agregarVertice(4);
        grafo.agregarVertice(5);
        
        grafo.agregarArco(1, 2, 10);
        grafo.agregarArco(2, 3, 50);
        grafo.agregarArco(1, 4, 30);
        grafo.agregarArco(4, 3, 20);
        grafo.agregarArco(1, 5, 100);
        grafo.agregarArco(4, 5, 60);
        grafo.agregarArco(3, 5, 10);
        HashMap<Integer, Integer> padres = dij.greedy(grafo, 1);
        for (Integer i : padres.keySet()) {
            System.out.println(padres.get(i));
        }
    }
}
