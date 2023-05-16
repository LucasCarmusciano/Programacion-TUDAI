package Programacion3.tp2;

import java.util.ArrayList;
import java.util.LinkedList;

public class Tree {

	private Integer value;
	private Tree left;
	private Tree right;

	public Tree(int value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public Integer getValue() {
		return value;
	}

	public void add(Integer newValue) {
		if(this.value == null){
			this.value = newValue;
		}else{
			if (newValue < this.value) {
				if (this.left == null)
					this.left = new Tree(newValue);
				else
					this.left.add(newValue);
			} else if (newValue > this.value) {
				if (this.right == null)
					this.right = new Tree(newValue);
				else
					this.right.add(newValue);
			}
		}
	}

	public Integer getRoot(){
		return value;
	}

	public boolean hasElem(Integer i){
		if (i < this.value) {
			if (this.left == null)
				return false;
			else
				return this.left.hasElem(i);
		} else if (i > this.value) {
			if (this.right == null)
				return false;
			else
				return this.right.hasElem(i);
		}
		return true;
	}

	public boolean isEmpty(){
		return (value==null);
	}

	public Integer getMaxElem(){
		if(this.right == null)
			return this.value; 
		return this.right.getMaxElem();
	}
	public Integer getMinElem(){
		if(this.left == null)
			return this.value; 
		return this.left.getMinElem();
	}

	public int getHeight(){
		int RightSize = 0, LeftSize = 0;
		if(this.left != null){
			LeftSize = this.left.getHeight()+1;
		}
		if(this.right != null){
			RightSize = this.right.getHeight()+1;
		}
		return Math.max(RightSize, LeftSize);
	}

	public boolean isLeaf(){
		return (this.right == null && this.left == null);
	}

	public LinkedList<Integer> getLongestBranch(){
		LinkedList<Integer> listLeft = new LinkedList<>();
		LinkedList<Integer> listRight = new LinkedList<>();

		if(this.left != null){
			listLeft = this.left.getLongestBranch();
		}
		if(this.right != null){
			listRight = this.right.getLongestBranch();
		}
		if(listLeft.size() > listRight.size()){
			listLeft.addFirst(this.value);
			return listLeft;
		}else{
			listRight.addFirst(this.value);
			return listRight;
		}
	}

	public LinkedList<Integer> getBorder(){
		LinkedList<Integer> list = new LinkedList<>();
		if(this.left != null){
			list.addAll(this.left.getBorder());
		}
		if(this.right != null){
			list.addAll(this.right.getBorder());
		}
		if(isLeaf()){
			list.addFirst(this.value);
		}
		return list;
	}

	public LinkedList<Integer> getElemAtLevel(int level){
		LinkedList<Integer> list = new LinkedList<>();
		if(level == 0){
			list.add(this.value);
		}else{
			if(this.left != null)
				list.addAll(this.left.getElemAtLevel(level-1));
			if(this.right != null)
				list.addAll(this.right.getElemAtLevel(level-1));
		}
		return list;
	}

	public boolean delete(Integer elem){
		if(this.value == elem){
			if(this.right != null){
				if(this.right.left == null){
					this.value = this.right.value;
					this.right = this.right.right;
				}else{
					Tree aux = this.right.popMin();
					aux.left = this.left;
					aux.right = this.right;
					this.value = aux.value;
				}
				return true;
			} else if(this.left != null){
				if(this.left.right == null){
					this.value = this.left.value;
					this.left = this.left.left;
				}else{
					Tree aux = this.left.popMax();
					aux.left = this.left;
					aux.right = this.right;
					this.value = aux.value;
				}
				return true;
			} else {
				this.value = null;
				return true;
			}
		}
		if(this.left != null){
			if(this.left.value == elem){
				if(this.left.right == null){
					this.left = this.left.left;
				}else{
					Tree aux = this.left.right.popMin();
					aux.left = this.left.left;
					aux.right = this.left.right;
					this.left = aux;
				}
				return true;
			}
			this.left.delete(elem);
		}
		if(this.right != null){
			if (this.right.value == elem) {
				if(this.right.left == null){
					this.right = this.right.right;
				}else{
					Tree aux = this.right.left.popMax();
					aux.left = this.right.left;
					aux.right = this.right.right;
					this.right = aux;
				}
				return true;
			}
			this.right.delete(elem);
		}
		return false;
	}

	private Tree popMin(){
		if(this.left.left == null){
			Tree minTree = this.left;
			this.left = this.left.right;
			return minTree;
		}
		return this.left.popMin();
	}
	private Tree popMax(){
		if(this.right.right == null){
			Tree minTree = this.right;
			this.right = this.right.left;
			return minTree;
		}
		return this.right.popMin();
	}
	
	// Printers
	public void printPreOrder(){
		System.out.print(this.value+"  ");
		if(this.left != null){
			this.left.printPreOrder();
		}else{
			System.out.print("- ");
		}
		if(this.right != null){
			this.right.printPreOrder();
		}else{
			System.out.print("- ");
		}
	}
	public void printPosOrder(){
		if(this.left != null){
			this.left.printPosOrder();
		}
		if(this.right != null){
			this.right.printPosOrder();
		}
		System.out.print(this.value+"  ");
	}
	public void printInOrder(){
		if(this.left != null){
			this.left.printInOrder();
		}
		System.out.print(this.value+"  ");
		if(this.right != null){
			this.right.printInOrder();
		}
	}
	
	// Ejercicio 2
	public int getSumatoria(){
		if(this.left != null && this.right != null){
			return this.right.getSumatoria()+this.left.getSumatoria()+this.value;
		}else if(isLeaf()){
			return this.value;
		}else if(this.left == null){
			return this.right.getSumatoria()+this.value;
		}else{
			return this.left.getSumatoria()+this.value;
		}
	}

	//Ejercicio 3
	public LinkedList<Integer> getBorderOver(Integer K){
		LinkedList<Integer> list = new LinkedList<>();
		if(this.left != null){
			list.addAll(this.left.getBorderOver(K));
		}
		if(this.right != null){
			list.addAll(this.right.getBorderOver(K));
		}
		if(isLeaf() && this.value>K){
			list.addFirst(this.value);
		}
		return list;
	}
}