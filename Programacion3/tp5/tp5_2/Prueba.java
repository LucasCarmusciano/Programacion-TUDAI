package Programacion3.tp5.tp5_2;

public class Prueba {
    public static void main(String[] args) {
        Mochila mochila = new Mochila(20);
        int[] p = {18,15,10};
        int[] v = {25,24,15};
        double[] solucion;
        double xivi=0;
        solucion = mochila.llenarMochila(p, v);
        for (int i = 0; i < solucion.length; i++) {
            System.out.println(solucion[i]);
            xivi+=(solucion[i]*v[i]);
        }
        System.out.println("Valor almacenado: "+xivi);
    }
}
