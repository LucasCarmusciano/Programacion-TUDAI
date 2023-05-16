package Programacion3.tp1.tp1_11;

public class busqueda {
    public static void main(String[] args) {
        int[]arr = {0,1,2,2,3,4,5,6,7,8,9,10,11};
        int posicion = buscarIndice(arr, 11, 0, arr.length);
        System.out.println(posicion);
    }
    public static int buscarIndice(int[] arr, int valor, int inicial, int ultimo){
        int mitad = (ultimo+inicial)/2;
        if(inicial!=mitad){
            if (valor>arr[mitad]) {
                return buscarIndice(arr, valor, mitad, ultimo);
            }else if (valor<arr[mitad]){
                return buscarIndice(arr, valor, inicial, mitad);
            }else {
                return mitad;
            }
        }else if (valor==arr[mitad]){
            return mitad;
        }else return -1;
    }
}
