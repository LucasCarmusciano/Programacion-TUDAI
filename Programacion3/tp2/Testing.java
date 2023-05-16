package Programacion3.tp2;

public class Testing {
    public static void main(String[] args) {
        Tree arbol = new Tree(6);
        arbol.add(3);
        arbol.add(7);
        arbol.add(12);
        arbol.add(1);
        arbol.add(10);
        arbol.add(8);
        arbol.add(9);

        arbol.add(11);

        arbol.add(33);



        System.out.println(arbol.isEmpty());
        System.out.println(arbol.getRoot());
        System.out.println(arbol.hasElem(3));
        System.out.println(arbol.getMaxElem());
        System.out.println(arbol.getMinElem());

        System.out.println("------------------------");
        arbol.printInOrder();
        System.out.println();
        arbol.printPreOrder();
        System.out.println();
        arbol.printPosOrder();
        System.out.println("\n-----------HEIGHT-------------");
        System.out.print(arbol.getHeight());
        System.out.println("\n-----------LONGEST BRANCH-------------");
        for (Integer integer : arbol.getLongestBranch()) {
            System.out.print(integer+" ");
        }
        System.out.println("\n-----------BORDER-------------");
        for (Integer integer : arbol.getBorder()) {
            System.out.print(integer+" ");
        }
        System.out.println("\n-----------ELEMENT AT LEVEL-------------");
        for (Integer integer : arbol.getElemAtLevel(3)) {
            System.out.print(integer+" ");
        }
        System.out.println("\n-----------DELETED-------------");
        arbol.delete(6);
        arbol.printPreOrder();
        System.out.println("\n-----------SUMATORIA-------------");
        System.out.println("La sumatoria es: "+arbol.getSumatoria());
        System.out.println("\n-----------BORDER OVER-------------");
        for (Integer integer : arbol.getBorderOver(10)) {
            System.out.print(integer+" ");
        }
    }
}
