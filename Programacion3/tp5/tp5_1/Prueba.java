package Programacion3.tp5.tp5_1;

import java.util.LinkedList;

public class Prueba {
    public static void main(String[] args) {
        Moneda billetes = new Moneda();
        LinkedList<Integer> lista = new LinkedList<>();
        billetes.cargarBilletes(1000);
        billetes.cargarBilletes(500);
        billetes.cargarBilletes(200);
        billetes.cargarBilletes(100);
        billetes.cargarBilletes(50);
        billetes.cargarBilletes(20);
        billetes.cargarBilletes(10);
        lista = billetes.greedy(2340);
        System.out.println(lista);
    }
}
