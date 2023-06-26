package Programacion3.tp5.tp5_2;

public class Mochila {
    private int P;

    public Mochila(int p) {
        this.P = p;
    }
    public double[] llenarMochila(int[] p, int[] v){
        double[] S = new double[p.length];
        int pesoActual=0, index;
        for (int i = 0; i < S.length; i++) {
            S[i]=0;
        }
        while(pesoActual<P){
            index = getValioso(p,v);
            if(pesoActual+p[index]<this.P){
                S[index]=1;
                pesoActual+=p[index];
                p[index]=0;
            }else{
                S[index]=(double)(P-pesoActual)/p[index]; // siendo que p*Xi=P-pesoActual, busco la fraccion Xi
                pesoActual=P;                
            }
        }
        return S;
    }
    private int getValioso(int[] p, int[] v){
        int index=0;
        double fraccion=0, auxF=0;
        for (int i = 0; i < v.length; i++) {
            if(p[i]!=0){
                auxF = (double)v[i]/p[i];
                if(auxF>fraccion){
                    index = i;
                    fraccion = auxF;
                }
            }
        }
        return index;
    }
}
