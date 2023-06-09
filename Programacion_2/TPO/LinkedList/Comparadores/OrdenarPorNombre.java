package TPO.LinkedList.Comparadores;

import java.util.Comparator;

import TPO.LinkedList.ListaVinculada.*;

public class OrdenarPorNombre implements Comparator<Object> {
	
	private Alumno alumno1,alumno2;

	@Override
	public int compare(Object o1, Object o2) {
	   	this.alumno1 = (Alumno) o1;
    	this.alumno2 = (Alumno) o2;
			return alumno1.getNombre().compareTo(alumno2.getNombre());
	}

}
