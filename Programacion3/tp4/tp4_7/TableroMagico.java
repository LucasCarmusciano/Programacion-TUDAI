package Programacion3.tp4.tp4_7;

public class TableroMagico {
    private Integer[][] tablero;
    private int n, k, s;
    public TableroMagico(int n, int k, int s) {
        this.tablero = new Integer[n][n];
        this.k = k;
        this.s = s;
        this.n = n;
    }
    public void back(){
        Integer[] aux1 = new Integer[n];
        Integer[] aux2 = new Integer[n];

    }
    public void back(Integer[] aux1, int i){
        if()
        else{
            for(int a = 1; a < k; a++){
                if(esOptimo(aux1, a, i)){
                    aux1[i]=a;
                }
            }
            if
        }
    }
    public boolean esOptimo(Integer[] aux1, int a, int i){
        int suma=0;
        Integer[] aux2 = this.tablero[i];
        for (Integer i1 : aux1) {
            suma+=i1;
            if(i1==a || suma>this.s){
                return false;
            }
        }
        if(i==n-1 && suma!=this.s){
            return false;
        }
        suma=0;
        for (Integer i2 : aux2) {
            suma+=i2;
            if(i2==a || suma>this.s){
                return false;
            }
        }
        if(i==n-1 && suma!=this.s){
            return false;
        }
        return true;
    }
}
