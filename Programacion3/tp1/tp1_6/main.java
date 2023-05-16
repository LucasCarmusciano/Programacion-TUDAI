package Programacion3.tp1.tp1_6;

public class main {
    public static void main(String[] args) {
        MySimpleLinkedList<Integer> lista1 = new MySimpleLinkedList<>();
        MySimpleLinkedList<Integer> lista2 = new MySimpleLinkedList<>();
        MySimpleLinkedList<Integer> lista3 = new MySimpleLinkedList<>();

        lista1.insertFront(1);
        lista1.insertFront(2);
        lista1.insertFront(3);
        lista1.insertFront(4);
        lista2.insertFront(4);
        lista2.insertFront(3);
        lista2.insertFront(2);
        lista2.insertFront(3);

        for (Integer integer : lista1) {
            if (lista2.contains(integer) && !lista3.contains(integer)) {
            }
        }
    }
}
