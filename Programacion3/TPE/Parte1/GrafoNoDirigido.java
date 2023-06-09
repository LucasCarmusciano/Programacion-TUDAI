package Parte1;

public class GrafoNoDirigido<T> extends GrafoDirigido<T>{
    
    @Override
    public void agregarArco(int vertice1, int vertice2, T etiqueta){
        super.agregarArco(vertice1, vertice2, etiqueta);
        super.agregarArco(vertice2, vertice1, etiqueta);
    }

    @Override
    public void borrarArco(int vertice1, int vertice2){
        super.borrarArco(vertice1, vertice2);
        super.borrarArco(vertice2, vertice1);
    }

    @Override
	public int cantidadArcos() {
		return super.cantidadArcos() / 2;
	}
}