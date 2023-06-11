package Programacion3.tp4.tp4_4;

import java.util.LinkedList;
import java.util.List;

public class Conjunto {
    private List<Integer> lista;
    private int tamanioLista;
    private LinkedList<Integer> subconj1;
    private LinkedList<Integer> subconj2;
    public Conjunto(LinkedList<Integer> lista) {
        this.lista = lista;
        this.tamanioLista = suma(lista);
        this.subconj1 = new LinkedList<>();
        this.subconj2 = new LinkedList<>();
    }

    public void getSubconjuntos(){
        subconj2.addAll(lista);
        for (Integer integer : lista) {
            getSubconjuntos(tamanioLista/2);
            subconj2.add(subconj1.pop());
            subconj2.addAll(0, subconj1);
            subconj1.clear();
        }
    }

    private void getSubconjuntos(int aux){
        if(aux>0){
            subconj1.add(subconj2.pop());
            if(suma(subconj1)<suma(subconj2)){
                getSubconjuntos(aux-1);
            }else if(suma(subconj1)==suma(subconj2)){
                System.out.println("Subconjunto 1: "+subconj1.toString());
                System.out.println("Subconjunto 2: "+subconj2.toString()+"\n");
            }
        }
    }

    private int suma(LinkedList<Integer> lista){
        int suma=0;
        for (Integer integer : lista) {
            suma+=integer;
        }
        return suma;
    }
}
