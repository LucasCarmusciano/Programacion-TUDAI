package Programacion3.tp4.tp4_2;

import java.util.LinkedList;

public class prueba {
    public static void main(String[] args) {
        Laberinto lab = new Laberinto(3);
        LinkedList<Casilla> camino = new LinkedList<>();
        lab.cargar(0, 0, 5, false, true, false, false);
        lab.cargar(0, 1, 3, true, true, false, true);
        lab.cargar(0, 2, 2, true, false, false, true);
        lab.cargar(1, 0, 2, false, true, false, true);
        lab.cargar(1, 1, 9, true, false, true, false);
        lab.cargar(1, 2, 3, false, false, true, true);
        lab.cargar(2, 0, 8, false, true, true, false);
        lab.cargar(2, 1, 4, true, true, false, false);
        lab.cargar(2, 2, 4, true, false, true, false);
        camino = lab.getCamino(0, 0, 2, 1);
        System.out.println(camino);
    }
}
