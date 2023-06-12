package Programacion3.tp5.tp5_1;

import java.util.LinkedList;

public class Moneda {
    private LinkedList<Integer> billetes;
    public Moneda() {
        this.billetes = new LinkedList<>();
    }
    public void cargarBilletes(int b){
        int index=0;
        while(index<billetes.size() && billetes.get(index)>b){
            index++;
        }
        billetes.add(b);
    }
    public LinkedList<Integer> greedy(int valor){
        LinkedList<Integer> solucion = new LinkedList<>();
        for (int i = 0; i < billetes.size(); i++) {
            if (valor-billetes.get(i)>=0) {
                valor-=billetes.get(i);
                solucion.add(billetes.get(i));
                i--;
            }
        }
        if (valor==0) {
            return solucion;
        }else{
            System.out.println("No hay solucion");
            return null;
        }
    }
}
