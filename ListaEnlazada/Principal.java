package ListaEnlazada;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        ListasEnlazadas lista = new ListasEnlazadas();
        boolean si = true;
        int op;
        Object elemto;
        do {
            System.out.println("\u001B[46;30m.:: MENU ::.\033[31m");
            System.out.println("1.Insertar al inicio");
            System.out.println("2.Insertar al final");
            System.out.println("3.Insertar en alguna pocisión");
            System.out.println("4.Mostrar");
            System.out.println("5.Eliminar al inicio");
            System.out.println("6.Eliminar al final");
            System.out.println("7.Eliminar en alguna pocisión");
            System.out.println("8.salir del menu");
            op = leer.nextInt();
            switch (op) {
                case 1:
                    System.out.println("Ingrese elemento");
                    elemto = leer.next();
                    lista.InsertarAlInicio(elemto);
                    break;
                case 2:
                    System.out.println("Ingrese elemento");
                    elemto = leer.next();
                    lista.InsertarAlFinal(elemto);
                    break;
                case 3:
                    System.out.println("Ingrese elemento");
                    elemto = leer.next();
                    lista.InsertarPosicion(elemto);
                    break;
                case 4:
                    lista.Mostrar();
                    break;
                case 5:
                    lista.EliminarAlInicio();
                    break;
                case 6:
                    lista.EliminarAlFinal();
                    break;
                case 7:
                    System.out.println("Ingrese posición de la fila a eliminar");
                    int p=leer.nextInt();
                    lista.EliminarP(p);
                    break;
                default:
                    si=false;
                    break;
            }
        } while (si);

    }

}

