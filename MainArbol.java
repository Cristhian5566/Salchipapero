/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

import java.awt.image.RasterOp;
import java.util.Scanner;

/**
 *
 * @author wared
 */
public class MainArbol {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion;
        int elemento = 0;
        ArbolBInario arbol = new ArbolBInario();
        do {
            System.out.println("\n\n");
            System.out.println(" |                             MENÚ                           |");
            System.out.println(" |-------------------------------|----------------------------|");
            System.out.println(" | 1. Ingresar datos:            | 2. Recorriendo inorden:    |");
            System.out.println(" | 3. Recorriendo preorden:      | 4. Recorriendo Postorden:  |");
            System.out.println(" | 5. Buscar Nodo:               | 6. Eliminar                |");
            System.out.println(" | 7. Niveles                    | 8. Izquierdo               |");
            System.out.println(" | 9. Derecho                    | 10.Igualar                 |");
            System.out.println(" | 11. Contar                    | 12.Buscar Nodo y su nivel  |");
            System.out.println(" |-------------------------------|----------------------------|");
            System.out.print(" Elija una Opción: ");
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("Ingrese los Datos que desee: ");
                    arbol.agregarDatos(sc.nextInt());
                    break;
                case 2:
                    System.out.println("Recorrer el Arbol Inorden: ");
                    if (!arbol.vacio()) {
                        arbol.indorden(arbol.raiz);
                    } else {
                        System.out.println("el Arbol Esta Vacio ");
                    }
                    break;
                case 3:
                    System.out.println("recorre el Arbol Preorden: ");
                    if (!arbol.vacio()) {
                        arbol.preorden(arbol.raiz);
                    } else {
                        System.out.println("el Arbol esta vacio");
                    }
                    break;
                case 4:
                    System.out.println("recorrer el arbol Postorden");
                    arbol.posorden(arbol.raiz);
                    break;
                case 5:
                    if (!arbol.vacio()) {
                        System.out.println("Buscar el numero que desees Buscar: : ");
                        elemento = sc.nextInt();
                        arbol.buscar(elemento);
                        if (arbol.buscar(elemento) == null) {
                            System.out.println("No se encuentra el nodo: ");
                        } else {
                            System.out.println("Nodo Encontrado");
                        }
                    } else {
                        System.out.println("el Arbol esta vacio");
                    }
                    break;
                case 6:
                    System.out.println("Eliminar del Arbol: ");
                    System.out.println("Ingrese el numero del Nodo Eliminar: ");
                    elemento = sc.nextInt();
                    if (!arbol.vacio()) {
                        arbol.eliminar(elemento);
                        System.out.println("Nodo Eliminado");
                        System.out.println("el arbol seria lo siguiente: ");
                        arbol.preorden(arbol.raiz);
                    } else {
                        System.out.println("numero no encontrado");
                    }
                    break;
                case 7:
                    System.out.println("Los niveles Serian: ");
                    arbol.altura();
                    arbol.imprimir();

                    break;
                case 8:
                    System.out.println("Arbol Izquierdo");
                    arbol.izquierda();
                    break;
                case 9:
                    System.out.println("Arbolo derecho");
                    arbol.derecha();
                    break;
                case 10:
                    System.out.println("ver si los niveles son iguales o no: ");
                    arbol.niveles();
                    break;
                case 11:
                    System.out.println("contar Nodos: " + arbol.ContarNodo());
                    arbol.ContarNodo();

                    break;
                case 12:
                    if (!arbol.vacio()) {
                        System.out.println("Buscar el numero que desees Buscar: : ");
                        elemento = sc.nextInt();
                        arbol.BuscarNivel(elemento);
                        if (arbol.buscar(elemento) == null) {
                            System.out.println("");
                            System.out.println("No se encuentra el nodo: ");
                        } else {

                            System.out.println("el nivel es: " + arbol.BuscarNivel(elemento));
                            System.out.println("Nodo Encontrado");
                        }
                    } else {
                        System.out.println("el Arbol esta vacio");
                    }
                    break;
                case 13:
                    System.out.println("Suma de lados Nodos");
                    break;

                default:

            }

        } while (opcion != 20);
    }
}
