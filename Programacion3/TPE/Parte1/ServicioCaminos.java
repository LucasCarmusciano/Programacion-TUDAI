package Parte1;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ServicioCaminos {
    private Grafo<?> grafo;
	private int origen;
	private int destino;
	private int lim;
    private HashMap<Integer, String> map;
	
	// Servicio caminos
	public ServicioCaminos(Grafo<?> grafo, int origen, int destino, int lim) {
		this.grafo = grafo;
		this.origen = origen;
		this.destino = destino;
		this.lim = lim;
        this.map= new HashMap<>();
	}

	public List<List<Integer>> caminos() {
		List<List<Integer>> salida = new LinkedList<>();
        List<Integer> camino = new LinkedList<>();
        camino.add(origen);
        Iterator<Integer> adj = grafo.obtenerAdyacentes(origen);
        while(adj.hasNext()){
            int actual = adj.next();
            List<Integer> copia = new LinkedList<>(camino);
            copia.add(actual);
            caminos(actual, copia, salida, this.lim);
        }
		return salida;
	}
    
    private void caminos(int v, List<Integer> camino, List<List<Integer>> salida, int cont){
        if(cont > 0){
            if(v == this.destino){
                salida.add(camino);
            }else{
                Iterator<Integer> adj = grafo.obtenerAdyacentes(v);
                while(adj.hasNext()){
                    int actual = adj.next();
                    List<Integer> copia = new LinkedList<>(camino);
                    if(!camino.contains(actual)){ // SI COMENTO, PUEDO AGREGAR [2,4,1,2,5] PERO NO AGREGA [2,5]
                        copia.add(actual);
                        caminos(actual, copia, salida, cont-1);
                    }
                }
            }
        }
    }
}
