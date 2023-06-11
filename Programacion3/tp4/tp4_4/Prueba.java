package Programacion3.tp4.tp4_4;

import java.util.LinkedList;

public class Prueba {
    public static void main(String[]args){

        LinkedList<Integer> listaNumeros=new LinkedList<>();
        listaNumeros.add(1);
        listaNumeros.add(2);
        listaNumeros.add(3);
        listaNumeros.add(6);
        listaNumeros.add(4);
        listaNumeros.add(2);
        listaNumeros.add(3);
        listaNumeros.add(3);

        Conjunto conjunto=new Conjunto(listaNumeros);

        conjunto.getSubconjuntos();

    }
}
