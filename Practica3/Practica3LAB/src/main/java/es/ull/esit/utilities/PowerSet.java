package es.ull.esit.utilities;

import java.util.BitSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.TreeSet;

// Sirve para calcular todos los subconjuntos de un conjunto dado
public class PowerSet<E> implements Iterable<Set<E>> {

    private E[] arr;

    @SuppressWarnings("unchecked")
    public PowerSet(Set<E> set) {
        this.arr = (E[]) set.toArray();
    }

    @Override
    public Iterator<Set<E>> iterator() {
        return new PowerSetIterator();
    }

    private class PowerSetIterator implements Iterator<Set<E>> {
        private BitSet bset;

        public PowerSetIterator() {
            this.bset = new BitSet(arr.length + 1);
        }

        @Override
        public boolean hasNext() {
            return !this.bset.get(arr.length);
        }

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

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not Supported!");
        }
    }
}