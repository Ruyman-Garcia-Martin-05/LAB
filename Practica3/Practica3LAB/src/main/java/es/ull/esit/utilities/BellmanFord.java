package es.ull.esit.utilities;

import java.util.ArrayList;

/**
 * Clase que implementa el algoritmo de Bellman-Ford para encontrar el camino más corto en un grafo.
 */
public class BellmanFord {

    /**
     * Valor de infinito.
     */
    private static final int INFINITY = 999999;

    /**
     * Matriz de distancias entre los nodos.
     */
    private final int[][] distanceMatrix;

    /**
     * Aristas del grafo.
     */
    private ArrayList<Integer> edges1 = null;

    /**
     * Aristas del grafo.
     */
    private ArrayList<Integer> edges2 = null;

    /**
     * Número de nodos en el grafo.
     */
    private final int nodes;

    /**
     * Lista que almacena el camino más corto encontrado.
     */
    private final ArrayList<Integer> path;

    /**
     * Distancias mínimas desde el nodo origen a cada nodo.
     */
    private int[] distances = null;

    /**
     * Valor del camino más corto encontrado.
     */
    private int value;

    /**
     * Constructor de la clase BellmanFord.
     *
     * @param distanceMatrix Matriz de distancias entre los nodos.
     * @param nodes Número de nodos en el grafo.
     * @param path Lista que almacena el camino más corto encontrado.
     */
    public BellmanFord(int[][] distanceMatrix, int nodes, ArrayList<Integer> path) {
        this.distanceMatrix = distanceMatrix;
        this.nodes = nodes;
        this.path = path;
        this.calculateEdges();
        this.value = BellmanFord.INFINITY;
    }

    /**
     * Método que calcula las aristas del grafo a partir de la matriz de distancias.
     */
    private void calculateEdges() {
        this.edges1 = new ArrayList<>();
        this.edges2 = new ArrayList<>();
        for (int i = 0; i < this.nodes; i++) {
            for (int j = 0; j < this.nodes; j++) {
                if (this.distanceMatrix[i][j] != Integer.MAX_VALUE) {
                    this.edges1.add(i);
                    this.edges2.add(j);
                }
            }
        }
    }

    /**
     * Método que devuelve las distancias mínimas desde el nodo origen a cada nodo.
     *
     * @return Array de distancias mínimas.
     */
    public int[] getDistances() {
        return this.distances;
    }

    /**
     * Método que devuelve el valor del camino más corto encontrado.
     *
     * @return Valor del camino más corto.
     */
    public int getValue() {
        return this.value;
    }

    /**
     * Método que resuelve el problema del camino más corto utilizando el algoritmo de Bellman-Ford.
     */
    public void solve() {
        int numEdges = this.edges1.size();
        int[] predecessor = new int[this.nodes];
        this.distances = new int[this.nodes];
        for (int i = 0; i < this.nodes; i++) {
            this.distances[i] = BellmanFord.INFINITY;
            predecessor[i] = -1;
        }
        this.distances[0] = 0;
        for (int i = 0; i < (this.nodes - 1); i++) {
            for (int j = 0; j < numEdges; j++) {
                int u = this.edges1.get(j);
                int v = this.edges2.get(j);
                if (this.distances[v] > this.distances[u] + this.distanceMatrix[u][v]) {
                    this.distances[v] = this.distances[u] + this.distanceMatrix[u][v];
                    predecessor[v] = u;
                }
            }
        }
        this.path.add(this.nodes - 1);
        int pred = predecessor[this.nodes - 1];
        while (pred != -1) {
            this.path.add(pred);
            pred = predecessor[pred];
        }
        this.value = -this.distances[this.nodes - 1];
    }
}
