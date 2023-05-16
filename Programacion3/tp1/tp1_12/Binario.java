package Programacion3.tp1.tp1_12;

public class Binario {
    public static void main(String[] args) {
        int numero = binario(26,0,0);
        System.out.println(numero);
    }
    public static int binario(int num, int suma, int index){
        suma += ((num%2)*(int)Math.pow(10, index));
        num = num/2;
        if(num!=0){
            suma = binario(num, suma, index+1);
        }
        return suma;
    }
}
