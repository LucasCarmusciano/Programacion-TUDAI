package Programacion3.tp1.tp1_3;

public class Pila<T> {
    private MySimpleLinkedList<T> lista;
    public Pila(){
        this.lista = new MySimpleLinkedList<>();
    }
    public void push(T o){
        this.lista.insertFront(o);
    }
    public T pop(){
        return this.lista.extractFront();
    }
    public T top(){
        return this.lista.get(0);
    }
    public void reverse(){
        MySimpleLinkedList<T> aux = new MySimpleLinkedList();
        for (int i = 0; i < this.lista.size(); i++) {
            aux.insertFront(this.lista.get(i));
        }
        this.lista = aux;
    }
}
