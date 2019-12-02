/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package min;

/**
 *
 * @author rgonzaleto
 */
public class minHeap<T extends Comparable> implements minHeapADT<T>  {
    
    T[] datos;
    int cont;

    public minHeap(T[] nuevo) {
        cont = nuevo.length + 1;
        datos = (T[]) new Object[cont];
        datos[0] = null;
        for (int i = 1; i <= nuevo.length; i++) {
            datos[i] = nuevo[i - 1];
        }
    }

    public minHeap() {
        cont = 0;
        datos = (T[]) new Object[10];
    }

    @Override
    public void inserta(T elem) {
        boolean termine = false;
        int actual;
        if (cont + 1 == datos.length) {
            expande();
        }
        datos[++cont] = elem;
        actual = cont;
        while (actual != 1 && !termine) {
            if (datos[actual].compareTo(datos[actual >> 1]) < 0) {
                T temp = datos[actual];
                datos[actual] = datos[actual >> 1];
                datos[actual >> 1] = temp;
                actual = actual >> 1;
            } else {
                termine = true;
            }
        }
    }

    @Override
    public T borraMin() {
        if (cont != 0) {
            T temp = datos[1], actual, aux;
            datos[1] = datos[cont];
            datos[cont--] = null;
            boolean termine = false;
            int i = 1;
            actual = datos[i];
            if (actual != null) {
                while (i <= cont && !termine) {
                    if (actual.compareTo(datos[i << 1]) > 0 && actual.compareTo(datos[i << 1 + 1]) < 0) {
                        aux = datos[i << 1];
                        datos[i << 1] = actual;
                        datos[i] = aux;
                        i = i << 1;
                    }
                    if (actual.compareTo(datos[i << 1]) > 0 && actual.compareTo(datos[i << 1 + 1]) < 0) {
                        aux = datos[i << 1 + 1];
                        datos[i << 1 + 1] = actual;
                        datos[i] = aux;
                        i = i << 1 + 1;
                    } else {
                        termine = true;
                    }
                }
                return temp;
            } else {
                return temp;
            }
        } else {
            throw new ElementNotFoundException();
        }
    }

    @Override
    public T buscaMin() {
        if (cont != 0) {
            return datos[1];
        } else {
            throw new ElementNotFoundException();
        }
    }

    private void expande() {
        T[] aux = (T[]) new Object[cont * 2];
        for (int i = 0; i <= cont; i++) {
            aux[i] = datos[i];
        }
        datos = aux;
    }
    
    //Falta el reordena con el merge sort
    

}
