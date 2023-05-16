package Programacion3.tp1.tp1_13;

public class Fibonacci {
    public static void main(String[] args) {
        printFibonacciNumbers(32, 0, 1);
    }
    public static void printFibonacciNumbers(int num, int suma, int anterior){
        if (num>0){
            System.out.print(suma+" ");
            int aux = suma;
            suma = suma+anterior;
            anterior = aux;
            printFibonacciNumbers(num-1, suma, anterior);
        }
    }
}
