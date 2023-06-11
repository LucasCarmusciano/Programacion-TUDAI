package Programacion3.tp4.tp4_2;

import java.util.LinkedList;
import java.util.List;

public class Laberinto {
    private Casilla[][] matriz;
    private LinkedList<Casilla> camino;
    private int sumaCamino;

    public Laberinto(int size) {
        this.matriz = new Casilla[size][size];
        this.camino = new LinkedList<>();
        this.sumaCamino=Integer.MAX_VALUE;
    }
    public void cargar(int x, int y, int valor, boolean izq, boolean der, boolean arriba, boolean abajo){
        Casilla c = new Casilla(valor, izq, der, arriba, abajo);
        this.matriz[x][y]=c;
    }
    public LinkedList<Casilla> getCamino(int origenX, int origenY, int destinoX, int destinoY){
        LinkedList<Casilla> lista = new LinkedList<>();
        getCamino(lista, origenX, origenY, destinoX, destinoY);
        return camino;
    }
    private void getCamino(LinkedList<Casilla> lista,int origenX, int origenY, int destinoX, int destinoY){
        Casilla origen = matriz[origenX][origenY];
        lista.add(origen);
        origen.visited=true;
        if(origenX==destinoX && origenY==destinoY){
            int sumaLista = getSuma(lista);
            if(sumaLista<this.sumaCamino){
                this.camino = new LinkedList<>(lista);
                this.sumaCamino = sumaLista;
            }
        }else if(!isFinal(origen)){
            if(origen.izq() && !matriz[origenX][origenY-1].visited){
                getCamino(lista, origenX, origenY-1, destinoX, destinoY);
            }
            if(origen.der() && !matriz[origenX][origenY+1].visited){
                getCamino(lista, origenX, origenY+1, destinoX, destinoY);
            }
            if(origen.arriba() && !matriz[origenX-1][origenY].visited){
                getCamino(lista, origenX-1, origenY, destinoX, destinoY);
            }
            if(origen.abajo() && !matriz[origenX+1][origenY].visited){
                getCamino(lista, origenX+1, origenY, destinoX, destinoY);
            }
        }
        lista.removeLast();
        origen.visited=false;
    }
    private int getSuma(List<Casilla> lista){
        int suma=0;
        for (int i = 0; i < lista.size(); i++) {
            suma+=lista.get(i).getValor();
        }
        return suma;
    }
    private boolean isFinal(Casilla c){
        return (c.abajo() && c.arriba() && c.izq() && c.der());
    }
}
