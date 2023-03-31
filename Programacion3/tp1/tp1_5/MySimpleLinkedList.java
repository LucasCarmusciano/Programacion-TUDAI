package Programacion3.tp1.tp1_5;

import java.util.Iterator;

public class MySimpleLinkedList<T> implements Iterable<T>{
	
	private Node<T> first;
	private int size;
	
	public MySimpleLinkedList() {
		this.first = null;
	}
	
	public void insertFront(T info) {
		Node<T> tmp = new Node<T>(info,null);
		tmp.setNext(this.first);
		this.first = tmp;
		this.size++;
	}
	
	public T extractFront() {		
		T info = first.getInfo();
		this.first = this.first.getNext();
		return info;
	}

	public boolean isEmpty() {
		return this.first==null;
	}
	
	public T get(int index) {
		Node<T> aux = this.first;
		for (int i = 0; i < index; i++) {
			aux = aux.getNext();
		}
		return aux.getInfo();
	}
	
	public int size() {
		return this.size;
	}
	
	@Override
	public String toString() {
		String string = "";
		Node<T> aux = this.first;
		for (int i = 0; i < size; i++) {
			aux = aux.getNext();
			string+=aux.getInfo().toString();
		}
		return string;
	}

	public int indexOf(T element){
		Node<T> aux = this.first;
		for (int i = 0; i < size; i++) {
			if (aux.getInfo().equals(element)) {
				return i;
			}
			aux = aux.getNext();
		}
		return -1;
	}

	@Override
	public Iterator<T> iterator() {
        return new Iterador<T>(this.first);
    }
}