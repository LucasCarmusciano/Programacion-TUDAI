package Programacion3.tp4.tp4_2;

public class Casilla {
    private int valor;
    private boolean izq, der, arriba, abajo;
    public boolean visited;
    public Casilla(int valor, boolean izq, boolean der, boolean arriba, boolean abajo) {
        this.valor = valor;
        this.izq = izq;
        this.der = der;
        this.arriba = arriba;
        this.abajo = abajo;
        this.visited = false;
    }
    public int getValor() {
        return valor;
    }
    public boolean izq() {
        return izq;
    }
    public boolean der() {
        return der;
    }
    public boolean arriba() {
        return arriba;
    }
    public boolean abajo() {
        return abajo;
    }
    public String toString(){
        return String.valueOf(valor);
    }
}
