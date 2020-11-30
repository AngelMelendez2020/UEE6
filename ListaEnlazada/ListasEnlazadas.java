package ListaEnlazada;

import java.util.Scanner;


public class ListasEnlazadas {
     Nodo raiz = null;
    Nodo cima = null;
    Nodo anterior = null;
    Nodo siguiente = null;
    int tamanio = 0, pocision, contador = 1;
    boolean repetir = true;
    Scanner leer = new Scanner(System.in);

    public void InsertarAlFinal(Object insertar) {
        Nodo nodoactual = new Nodo(insertar);
        if (raiz == null) {
            raiz = nodoactual;
            cima = nodoactual;
        } else {
            cima.siguiente = nodoactual;
            cima = nodoactual;
        }
        tamanio++;
    }

    public void InsertarAlInicio(Object insertar) {
        Nodo nodoactual = new Nodo(insertar);
        if (raiz == null) {
            raiz = nodoactual;
            cima = nodoactual;
        } else {
            nodoactual.siguiente = raiz;
            raiz = nodoactual;
        }
        tamanio++;
    }

    public void InsertarPosicion(Object insertar) {
        Nodo auxiliar = raiz;
        System.out.println("Auxiliar: " + auxiliar.elemento);
        System.out.println("Raiz: " + raiz.elemento);
        System.out.println("Cima: " + cima.elemento);

        Nodo nodoactual = new Nodo(insertar);
        if (raiz == null) {
            raiz = nodoactual;
            cima = nodoactual;
        } else {
            while (repetir) {
                System.out.println("Que pocision insertar?");
                pocision = leer.nextInt();
                if (pocision > (tamanio + 1)) {
                    System.out.println("Solo puedes insertar hasta la pocision " + (tamanio + 1));
                } else {
                    repetir = false;
                }
            }
            if (pocision == 1) {
                nodoactual.siguiente = raiz;
                raiz = nodoactual;
            } else {
                for (int i = 1; i <= pocision; i++) {
                    if (i == (pocision - 1)) {
                        anterior = auxiliar;
                        siguiente = auxiliar.siguiente;
                    } else {
                        auxiliar = auxiliar.siguiente;
                    }
                }
                cima = raiz;
                for (int i = 1; i <= tamanio; i++) {
                    if (cima.elemento.equals(anterior.elemento)) {
                        cima.siguiente = nodoactual;
                        cima = nodoactual;
                        nodoactual.siguiente = siguiente;
                    } else {
                        cima = cima.siguiente;
                    }
                }
            }
        }
        tamanio++;
    }

    public void EliminarAlInicio() {
        if (raiz == null) {
            System.out.println("No existe ningún elemento a eliminar");
        } else {
            if(tamanio==1){
                raiz = null;
                cima=null;
            }else{
                raiz = raiz.siguiente;
            }
            tamanio--;
            System.out.println("Dato eliminado");
        }
    }

    public void EliminarAlFinal() {
        if (cima == null) {
            System.out.println("No existe ningún elemento a eliminar");
        } else {
            if (tamanio == 1) {
                cima = null;
                raiz = null;
            } else {
                Nodo Auxiliar = raiz;
                for (int i = 1; i < tamanio; i++) {
                    if (i == (tamanio - 1)) {
                        cima = raiz;
                        raiz.siguiente = null;
                    } else {
                        raiz = raiz.siguiente;
                    }
                }
                raiz = Auxiliar;
            }
            tamanio--;
            System.out.println("Dato eliminado");
        }
    }

    public void EliminarP(int p) {
        Nodo auxiliar = raiz;
        if (raiz == null) {
            System.out.println("No existe ningun elemento a eliminar");
        } else {
            while (repetir) {
                if (p > tamanio) {
                    System.out.println("Solo puedes eliminar hasta la pocision " + tamanio);
                    System.out.println("Ingrese nueva posición");
                    p=leer.nextInt();
                    repetir=false;
                } else {
                    repetir = false;
                }
            }
            if (p == 1) {
                raiz=raiz.siguiente;
            } else {
                for (int i = 1; i < p; i++) {
                    if (i == (p - 1)) {
                        Nodo a=raiz.siguiente;
                        Nodo b=a.siguiente;
                        raiz.siguiente=b;
                    } else {
                        raiz = raiz.siguiente;
                    }
                }
                raiz=auxiliar;
            }
            tamanio--;
            System.out.println("Dato eliminado");
        }
    }

    public void Mostrar() {
        Nodo auxiliar = raiz;
        if (auxiliar == null) {
            System.out.println("No existe ningún elemento para mostar");
        } else {
            while (auxiliar != null) {
                System.out.print(" " + auxiliar.elemento);
                auxiliar = auxiliar.siguiente;
            }
            System.out.println("");
        }
    }
}
