package es.ull.esit.utilities;

import java.util.BitSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

/**
 * Clase que implementa un conjunto de potencia.
 *
 * @param <E> Tipo de los elementos del conjunto.
 */
public class PowerSet<E> implements Iterable<Set<E>> {
    /**
     * Array de elementos del conjunto.
     */
    private E[] arr;

    /**
     * Constructor de la clase PowerSet.
     *
     * @param set Conjunto de elementos.
     */
    @SuppressWarnings("unchecked")
    public PowerSet(Set<E> set) {
        this.arr = (E[]) set.toArray();
    }

    /**
     * Método que devuelve un iterador sobre el conjunto de potencia.
     *
     * @return Iterador sobre el conjunto de potencia.
     */
    @Override
    public Iterator<Set<E>> iterator() {
        return new PowerSetIterator();
    }

    /**
     * Clase que implementa un iterador sobre el conjunto de potencia.
     */
    private class PowerSetIterator implements Iterator<Set<E>> {
        private BitSet bset;

        /**
         * Constructor de la clase PowerSetIterator.
         */
        public PowerSetIterator() {
            this.bset = new BitSet(arr.length + 1);
        }

        /**
         * Método que comprueba si hay más elementos en el conjunto de potencia.
         *
         * @return True si hay más elementos, false en caso contrario.
         */
        @Override
        public boolean hasNext() {
            return !this.bset.get(arr.length);
        }

        /**
         * Método que devuelve el siguiente elemento del conjunto de potencia.
         *
         * @return Siguiente elemento del conjunto de potencia.
         */
        @Override
        public Set<E> next() {
            if (!hasNext()) {
                throw new NoSuchElementException("No more elements in the PowerSet.");
            }

            Set<E> returnSet = new TreeSet<>();
            for (int i = 0; i < arr.length; i++) {
                if (this.bset.get(i)) {
                    returnSet.add(arr[i]);
                }
            }
            for (int i = 0; i < this.bset.size(); i++) {
                if (!this.bset.get(i)) {
                    this.bset.set(i);
                    break;
                } else {
                    this.bset.clear(i);
                }
            }
            return returnSet;
        }

        /**
         * Método que elimina un elemento del conjunto de potencia.
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not Supported!");
        }
    }
}