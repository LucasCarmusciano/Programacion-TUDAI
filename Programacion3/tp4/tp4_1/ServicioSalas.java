package Programacion3.tp4.tp4_1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioSalas {
    private Grafo<?> grafo;
	private int entrada;
	private int salida;
    private HashMap<Arco<?>, String> map;
    private List<Integer> camino;
	
	public ServicioSalas(Grafo<?> grafo, int entrada, int salida) {
		this.grafo = grafo;
		this.entrada = entrada;
		this.salida = salida;
        this.map = new HashMap<>();
        this.camino = new LinkedList<>();
	}

	public List<Integer> camino() {
        Iterator<?> arcos = grafo.obtenerArcos();
        List<Integer> aux = new LinkedList<>();
        while(arcos.hasNext()){
            map.put((Arco<?>) arcos.next(), "NO_VISITED");
        }

        camino(entrada, null, aux);
		return this.camino;
	}

    private void camino(Integer v, Arco<?> arcoActual, List<Integer> aux){
        aux.add(v);
        if(arcoActual!=null)
            map.put(arcoActual, "VISITED");
        if(v==this.salida && aux.size()>camino.size()){
            this.camino.clear();
            this.camino.addAll(aux);
        }else{
            Iterator<Integer> vertices = grafo.obtenerAdyacentes(v);
            while(vertices.hasNext()){
                int vertice = vertices.next();
                Arco<?>arco = grafo.obtenerArco(v, vertice);
                if(map.get(arco)=="NO_VISITED") 
                    camino(vertice, arco, aux); 
            }
        }
        if(arcoActual!=null)
            map.put(arcoActual, "NO_VISITED");
        aux.remove(aux.size()-1);
    } 
}
