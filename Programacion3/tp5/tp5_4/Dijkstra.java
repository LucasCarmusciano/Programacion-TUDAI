package Programacion3.tp5.tp5_4;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

import Programacion3.tp5.tp5_4.Iteradores.*;

public class Dijkstra<T> {

    public Dijkstra() {
    }
    public HashMap<Integer,Integer> greedy(Grafo<T> G, int origen){
        HashMap<Integer, Integer> dist = new HashMap<>();
        HashMap<Integer, Integer> padre = new HashMap<>();
        LinkedList<Integer> S = new LinkedList<>();
        LinkedList<Integer> Glist = new LinkedList<>();
        Iterator<Integer> it = G.obtenerVertices();
        while(it.hasNext()){
            Integer v = it.next();
            dist.put(v, Integer.MAX_VALUE);
            padre.put(v, null);
            Glist.add(v);
        }
        dist.put(origen, 0);
        Integer u, v;
        while(!Glist.isEmpty()){
            u = getMenorDist(Glist, dist);
            S.add(u);
            Iterator adyU = G.obtenerAdyacentes(u);
            while(adyU.hasNext()){
                v = (Integer) adyU.next();
                if(dist.get(u)+(Integer)G.obtenerArco(u, v).getEtiqueta()<dist.get(v)){
                    dist.put(v, dist.get(u)+(Integer)G.obtenerArco(u, v).getEtiqueta());
                    padre.put(v, u);
                }
            }
        }
        return padre;
    }

    private int getMenorDist(LinkedList<Integer> Glist, HashMap<Integer,Integer> dist){
        int menor = Integer.MAX_VALUE, index=0, indexFinal=0;
        for (Integer integer : Glist) {
            if(dist.get(integer)<menor){
                menor=integer;
                indexFinal=index;
            }
            index++;
        }
        Glist.remove(indexFinal);
        return menor;
    }
}
