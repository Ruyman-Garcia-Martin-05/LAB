package es.ull.esit.utils;
import java.util.Objects;

/**
 * Clase que implementa un par de elementos.
 *
 * @param <F> Tipo del primer elemento.
 * @param <S> Tipo del segundo elemento.
 */
public class Pair<F, S> {
    /**
     * Primer elemento del par.
     */
    public final F first;
    /**
     * Segundo elemento del par.
     */
    public final S second;

    /**
     * Constructor de la clase Pair.
     *
     * @param first Primer elemento del par.
     * @param second Segundo elemento del par.
     */
    public Pair(F first, S second) {
        this.first = first;
        this.second = second;
    }

    /**
     * Método que devuelve el primer elemento del par.
     *
     * @return Primer elemento del par.
     */
    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Pair)) {
            return false;
        }
        Pair<?, ?> p = (Pair<?, ?>) o;
        return Objects.equals(p.first, first) && Objects.equals(p.second, second);
    }

    /**
     * Método que devuelve el hash del par.
     *
     * @return Hash del par.
     */
    @Override
    public int hashCode() {
        return (first == null ? 0 : first.hashCode()) ^ (second == null ? 0 : second.hashCode());
    }

    /**
     * Método que devuelve el hash del par.
     *
     * @return Hash del par.
     */
    public static <A, B> Pair <A, B> create(A a, B b) {
        return new Pair<A, B>(a, b);
    }
}
