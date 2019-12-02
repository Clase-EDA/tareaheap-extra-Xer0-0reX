/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package min;

/**
 *
 * @author rgonzaleto
 */
public interface minHeapADT<T extends Comparable> {
    public void inserta(T elem);
    public T buscaMin();
    public T borraMin();
}
