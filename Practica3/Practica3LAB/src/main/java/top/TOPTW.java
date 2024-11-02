package top;

import java.util.ArrayList;
import java.util.Arrays;

import es.ull.esit.utilities.ExpositoUtilities;

/**
 * Clase que implementa el problema de recogida y entrega con ventanas temporales.
 */
public class TOPTW {
    private int nodes;
    private double[] x;
    private double[] y;
    private double[] score;
    private double[] readyTime;
    private double[] dueTime;
    private double[] serviceTime;
    private int vehicles;
    private int depots;
    private double maxTimePerRoute;
    private double maxRoutes;
    private double[][] distanceMatrix;

    /**
     * Constructor de la clase TOPTW.
     *
     * @param nodes Número de nodos.
     * @param routes Número de rutas.
     */
    public TOPTW(int nodes, int routes) {
        this.nodes = nodes;
        this.depots = 0;
        this.x = new double[this.nodes + 1];
        this.y = new double[this.nodes + 1];
        this.score = new double[this.nodes + 1];
        this.readyTime = new double[this.nodes + 1];
        this.dueTime = new double[this.nodes + 1];
        this.serviceTime = new double[this.nodes + 1];
        this.distanceMatrix = new double[this.nodes + 1][this.nodes + 1];
        for (int i = 0; i < this.nodes + 1; i++) {
            for (int j = 0; j < this.nodes + 1; j++) {
                this.distanceMatrix[i][j] = 0.0;
            }
        }
        this.maxRoutes = routes;
        this.vehicles = routes;
    }

    /**
     * Método que comprueba si un nodo es un depósito.
     * @param a
     * @return True si el nodo es un depósito, false en caso contrario.
     */
    public boolean isDepot(int a) {
        if(a > this.nodes) {
            return true;
        }
        return false;
    }

    /**
     * Método que devuelve la distancia entre dos nodos.
     *
     * @param route Ruta.
     * @return Distancia entre los nodos.
     */
    public double getDistance(int[] route) {
        double distance = 0.0;
        for (int i = 0; i < route.length - 1; i++) {
            int node1 = route[i];
            int node2 = route[i + 1];
            distance += this.getDistance(node1, node2);
        }
        return distance;
    }

    /**
     * Método que devuelve la distancia entre dos nodos.
     *
     * @param route Ruta.
     * @return Distancia entre los nodos.
     */
    public double getDistance(ArrayList<Integer> route) {
        double distance = 0.0;
        for (int i = 0; i < route.size() - 1; i++) {
            int node1 = route.get(i);
            int node2 = route.get(i + 1);
            distance += this.getDistance(node1, node2);
        }
        return distance;
    }

    /**
     * Método que devuelve la distancia total de un conjunto de rutas.
     *
     * @param routes Conjunto de rutas.
     * @return Distancia total de las rutas.
     */
    public double getDistance(ArrayList<Integer>[] routes) {
        double distance = 0.0;
        for (ArrayList<Integer> route : routes) {
            distance += this.getDistance(route);
        }
        return distance;
    }

    /**
     * Método que calcula la matriz de distancias entre los nodos.
     */
    public void calculateDistanceMatrix() {
        for (int i = 0; i < this.nodes + 1; i++) {
            for (int j = 0; j < this.nodes + 1; j++) {
                if (i != j) {
                    double diffXs = this.x[i] - this.x[j];
                    double diffYs = this.y[i] - this.y[j];
                    this.distanceMatrix[i][j] = Math.sqrt(diffXs * diffXs + diffYs * diffYs);
                    this.distanceMatrix[j][i] = this.distanceMatrix[i][j];
                } else {
                    this.distanceMatrix[i][j] = 0.0;
                }
            }
        }
    }

    /**
     * Método que devuelve el mayor tiempo por ruta.
     *
     * @return Tiempo máximo por ruta.
     */
    public double getMaxTimePerRoute() {
        return maxTimePerRoute;
    }

    /**
     * Método que establece el mayor tiempo por ruta.
     *
     */
    public void setMaxTimePerRoute(double maxTimePerRoute) {
        this.maxTimePerRoute = maxTimePerRoute;
    }

    /**
     * Método que devuelve la ruta máxima.
     *
     * @return Ruta máxima.
     */
    public double getMaxRoutes() {
        return maxRoutes;
    }

    /**
     * Método que establece la ruta máxima.
     *
     */
    public void setMaxRoutes(double maxRoutes) {
        this.maxRoutes = maxRoutes;
    }

    /**
     * Método que devuleve la posición de un nodo en la matriz de distancias.
     *
     * @return Posición del nodo en la matriz de distancias.
     */
    public int getPOIs() {
        return this.nodes;
    }

    /**
     * Método que devuelve la matriz de distancias entre los nodos.
     * @return Distancias entre los nodos.
     */
    public double getDistance(int i, int j) {
        if(this.isDepot(i)) { i=0; }
        if(this.isDepot(j)) { j=0; }
        return this.distanceMatrix[i][j];
    }

    /**
     * Método que devuelve el tiempo entre dos nodos.
     *
     * @return Tiempo entre los nodos.
     */
    public double getTime(int i, int j) {
        if(this.isDepot(i)) { i=0; }
        if(this.isDepot(j)) { j=0; }
        return this.distanceMatrix[i][j];
    }


    /**
     * Método que devuelve el número de nodos.
     *
     * @return Número de nodos.
     */
    public int getNodes() {
        return this.nodes;
    }

    /**
     * Método que establece el número de nodos.
     *
     */
    public void setNodes(int nodes) {
        this.nodes = nodes;
    }

    /**
     * Método que devuelve posición X de un nodo.
     *
     * @return Número de depósitos.
     */
    public double getX(int index) {
        if(this.isDepot(index)) { index=0; }
        return this.x[index];
    }

    /**
     * Método que establece la posición X de un nodo.
     *
     */
    public void setX(int index, double x) {
        this.x[index] = x;
    }

    /**
     * Método que devuelve la posición Y de un nodo.
     *
     * @return Posición Y de un nodo.
     */
    public double getY(int index) {
        if(this.isDepot(index)) { index=0; }
        return this.y[index];
    }

    /**
     * Método que establece la posición Y de un nodo.
     *
     */
    public void setY(int index, double y) {
        this.y[index] = y;
    }

    /**
     * Método que devuelve la puntuación de un nodo.
     *
     * @return Puntuación de un nodo.
     */
    public double getScore(int index) {
        if(this.isDepot(index)) { index=0; }
        return this.score[index];
    }

    /**
     * Método que devuelve la puntuación de un nodo.
     *
     * @return Puntuación de un nodo.
     */
    public double[] getScore() {
        return this.score;
    }

    /**
     * Método que establece la puntuación de un nodo.
     *
     */
    public void setScore(int index, double score) {
        this.score[index] = score;
    }

    /**
     * Método que devuelve el tiempo de inicio de un nodo.
     *
     * @return Tiempo de inicio de un nodo.
     */
    public double getReadyTime(int index) {
        if(this.isDepot(index)) { index=0; }
        return this.readyTime[index];
    }

    /**
     * Método que establece el tiempo de inicio de un nodo.
     *
     */
    public void setReadyTime(int index, double readyTime) {
        this.readyTime[index] = readyTime;
    }

    /**
     * Método que devuelve el tiempo de finalización de un nodo.
     *
     * @return Tiempo de finalización de un nodo.
     */
    public double getDueTime(int index) {
        if(this.isDepot(index)) { index=0; }
        return this.dueTime[index];
    }

    /**
     * Método que establece el tiempo de finalización de un nodo.
     *
     */
    public void setDueTime(int index, double dueTime) {
        this.dueTime[index] = dueTime;
    }

    /**
     * Método que devuelve el tiempo de servicio de un nodo.
     *
     * @return Tiempo de servicio de un nodo.
     */
    public double getServiceTime(int index) {
        if(this.isDepot(index)) { index=0; }
        return this.serviceTime[index];
    }

    /**
     * Método que establece el tiempo de servicio de un nodo.
     *
     */
    public void setServiceTime(int index, double serviceTime) {
        this.serviceTime[index] = serviceTime;
    }

    /**
     * Método que devuelve el número de vehículos.
     *
     * @return Número de vehículos.
     */
    public int getVehicles() {
        return this.vehicles;
    }

    /**
     * Método que devuelve el texto del problema.
     *
     * @return Texto del problema.
     */
    @Override
    public String toString() {
        final int COLUMN_WIDTH = 15;
        String text = "Nodes: " + this.nodes + "\n";
        String[] strings = new String[]{"CUST NO.", "XCOORD.", "YCOORD.", "SCORE", "READY TIME", "DUE DATE", "SERVICE TIME"};
        int[] width = new int[strings.length];
        Arrays.fill(width, COLUMN_WIDTH);
        text += ExpositoUtilities.getFormat(strings, width) + "\n";
        for (int i = 0; i < this.nodes; i++) {
            strings = new String[strings.length];
            int index = 0;
            //strings[index++] = Integer.toString("" + i);
            strings[index++] = Integer.toString(i);
            strings[index++] = "" + this.x[i];
            strings[index++] = "" + this.y[i];
            strings[index++] = "" + this.score[i];
            strings[index++] = "" + this.readyTime[i];
            strings[index++] = "" + this.dueTime[i];
            strings[index++] = "" + this.serviceTime[i];
            text += ExpositoUtilities.getFormat(strings, width);
            text += "\n";
        }
        text += "Vehicles: " + this.vehicles + "\n";
        strings = new String[]{"VEHICLE", "CAPACITY"};
        width = new int[strings.length];
        Arrays.fill(width, COLUMN_WIDTH);
        text += ExpositoUtilities.getFormat(strings, width) + "\n";
        return text;
    }

    /**
     * Método que devuelve el número de depósitos.
     *
     * @return Número de depósitos.
     */
    public int addNode() {
        this.nodes++;
        return this.nodes;
    }

    /**
     * Método que devuelve el número de depósitos.
     *
     * @return Número de depósitos.
     */
    public int addNodeDepot() {
        this.depots++;
        return this.depots;
    }
}
