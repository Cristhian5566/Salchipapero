/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Arbol;

/**
 *
 * @author wared
 */
public class ArbolBInario {

    Node raiz;
    String[] niveles;
    int altura;
    int alturad;
    int alturai;
    int contador;
    private int derecho;
    private int izquierdo;

    public ArbolBInario() {
        this.raiz = null;
    }

    public Node getRaiz() {
        return raiz;
    }

    public void setRaiz(Node raiz) {
        this.raiz = raiz;
    }

    public String[] getNiveles() {
        return niveles;
    }

    public void setNiveles(String[] niveles) {
        this.niveles = niveles;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public void agregarDatos(int dato) {
        Node nuevo = new Node(dato);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            Node auxiliar = raiz;
            Node padre;
            while (true) {
                padre = auxiliar;
                if (dato < auxiliar.dato) {
                    auxiliar = auxiliar.izquierdo;
                    if (auxiliar == null) {
                        padre.izquierdo = nuevo;
                        return;
                    }
                } else {
                    auxiliar = auxiliar.derecho;
                    if (auxiliar == null) {
                        padre.derecho = nuevo;
                        return;
                    }
                }
            }
        }
    }

    public boolean vacio() {
        return raiz == null;
    }

    public void indorden(Node r) {
        if (r != null) {
            indorden(r.izquierdo);
            System.out.println(r.dato + " ");
            indorden(r.derecho);
        }
    }

    public void preorden(Node r) {
        if (r != null) {
            System.out.println(r.dato + " ");
            preorden(r.izquierdo);
            preorden(r.derecho);
        }
    }

    public void posorden(Node r) {
        if (r != null) {
            posorden(r.izquierdo);
            posorden(r.derecho);
            System.out.println(r.dato + " ");
        }
    }

    public Node buscar(int d) {
        Node auxiliar = raiz;
        while (auxiliar.dato != d) {
            if (d < auxiliar.dato) {
                auxiliar = auxiliar.izquierdo;
            } else {
                auxiliar = auxiliar.derecho;
            }
            if (auxiliar == null) {
                return null;
            }
        }
        return auxiliar;
    }

    public int BuscarNivel(int d) {
        int contador = 0;
        Node auxiliar = raiz;
        while (auxiliar.dato != d) {
            contador++;
            if (d < auxiliar.dato) {
                auxiliar = auxiliar.izquierdo;
            } else {
                auxiliar = auxiliar.derecho;
            }
            if (auxiliar == null) {

            }
        }
        return contador;
    }

    public boolean eliminar(int d) {
        Node auxiliar = raiz;
        Node padre = raiz;
        boolean hijoIzquierdo = true;
        while (auxiliar.dato != d) {
            padre = auxiliar;
            if (d < auxiliar.dato) {
                hijoIzquierdo = true;
                auxiliar = auxiliar.izquierdo;
            } else {
                hijoIzquierdo = false;
                auxiliar = auxiliar.derecho;
            }
            if (auxiliar == null) {
                return false;
            }
        }
        if (auxiliar.izquierdo == null && auxiliar.derecho == null) {
            if (auxiliar == raiz) {
                raiz = null;
            } else if (hijoIzquierdo) {
                padre.izquierdo = null;
            } else {
                padre.derecho = null;
            }
        } else if (auxiliar.derecho == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.izquierdo;
            } else if (hijoIzquierdo) {
                padre.izquierdo = auxiliar.izquierdo;
            } else {
                padre.derecho = auxiliar.izquierdo;
            }
        } else if (auxiliar.izquierdo == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.derecho;
            } else if (hijoIzquierdo) {
                padre.izquierdo = auxiliar.derecho;
            } else {
                padre.derecho = auxiliar.derecho;
            }
        } else {
            Node remplazo = obtener(auxiliar);
            if (auxiliar == raiz) {
                raiz = remplazo;
            } else if (hijoIzquierdo) {
                padre.izquierdo = remplazo;
            } else {
                padre.derecho = remplazo;
            }
            remplazo.izquierdo = auxiliar.derecho;

        }
        return true;
    }

    public Node obtener(Node reemplazar) {
        Node rempalzoPadre = reemplazar;
        Node remplazo = reemplazar;
        Node auxiliar = reemplazar.derecho;
        while (auxiliar != null) {
            rempalzoPadre = remplazo;
            remplazo = auxiliar;
            auxiliar = auxiliar.izquierdo;
        }
        if (remplazo != reemplazar.derecho) {
            rempalzoPadre.izquierdo = remplazo.derecho;
            remplazo.derecho = reemplazar.derecho;
        }
        System.out.println("El nodo Reemplazo es : " + remplazo);
        return remplazo;
    }

    public int altura() {
        altura = 0;
        altura(raiz, 0);
        return altura;
    }

    private void altura(Node pivo, int nivel) {
        if (pivo != null) {
            altura(pivo.izquierdo, nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            altura(pivo.derecho, nivel + 1);
        }
    }

    public void imprimir() {
        niveles = new String[altura + 1];
        imprimir(raiz, 0);
        for (int i = 0; i < niveles.length; i++) {
            System.out.println(niveles[i] + "es de Nivel: " + i);
        }
    }

    private void imprimir(Node pivo, int nivel2) {
        if (pivo != null) {
            niveles[nivel2] = pivo.dato + ", " + (niveles[nivel2] != null ? niveles[nivel2] : " ");

            imprimir(pivo.derecho, nivel2 + 1);
            imprimir(pivo.izquierdo, nivel2 + 1);
        }
    }

    private void imprimirdere(Node dere, int d) {
        if (dere != null) {
            niveles[d] = dere.dato + ", " + (niveles[d] != null ? niveles[d] : " ");
            imprimir(dere.derecho, d + 1);
        }
    }

    private void imprimirizquier(Node izq, int i) {
        if (izq != null) {
            niveles[i] = izq.dato + ", " + (niveles[i] != null ? niveles[i] : " ");
            imprimir(izq.izquierdo, i + 1);
        }
    }

    public void derecha() {
        int i = 0;
        niveles = new String[altura + 1];
        imprimirdere(raiz, 0);
        for (i = 0; i < niveles.length; i++) {
            System.out.println(niveles[i] + "es de Nivel: " + (i));
        }
    }

    public void izquierda() {
        int i = 0;
        niveles = new String[altura + 1];
        imprimirizquier(raiz, 0);
        for (i = 0; i < niveles.length; i++) {

            System.out.println(niveles[i] + "es de Nivel: " + (i));
        }
    }

    public void nodeDerecho(Node dere, int d) {
        if (dere != null) {
            nodeDerecho(dere.getDerecho(), d + 1);
            if (d > alturad) {
                alturad = d;
            }
        }
    }

    public void nodeIzquierdo(Node izq, int i) {
        if (izq != null) {
            nodeIzquierdo(izq.getIzquierdo(), i + 1);
            if (i > alturai) {
                alturai = i;
            }
        }
    }

    public void niveles() {
        nodeDerecho(raiz, 1);
        nodeIzquierdo(raiz, 1);
        if (alturad == alturai) {
            contador++;
            System.out.println("Son iguales");

        } else {
            System.out.println("No son iguales");
        }
        System.out.println("Altura Izquierdo " + alturad);
        System.out.println("Altura Derecho " + alturai);
    }

    public int ContarNodo() {
        contador = 0;
        contarArbol(raiz);
        return contador;
    }

    private void contarArbol(Node aux) {
        if (aux != null) {
            contador++;
            if (contador > 0) {
                contarArbol(aux.izquierdo);
                contarArbol(aux.derecho);
            }
        }
    }
    
    private void sumarNodos(){
        
    }

}
