package top;

/**
 * Clase que implementa una ruta del problema TOPTW.
 */
public class TOPTWRoute {
    int predecessor;
    int succesor;
    int id;

    /**
     * Constructor de la clase TOPTWRoute.
     */
    TOPTWRoute() {
        
    }

    /**
     * Constructor de la clase TOPTWRoute.
     *
     * @param pre Predecesor de la ruta.
     * @param succ Sucesor de la ruta.
     * @param id Identificador de la ruta.
     */
    TOPTWRoute(int pre, int succ, int id) {
        this.predecessor = pre;
        this.succesor = succ;
        this.id = id;
    }

    /**
     * Método que devuelve el predecesor de la ruta.
     *
     * @return Predecesor de la ruta.
     */
    public int getPredeccesor() {
        return this.predecessor;
    }

    /**
     * Método que devuelve el sucesor de la ruta.
     *
     * @return Sucesor de la ruta.
     */
    public int getSuccesor() {
        return this.succesor;
    }

    /**
     * Método que devuelve el identificador de la ruta.
     *
     * @return Identificador de la ruta.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Método que establece el predecesor de la ruta.
     *
     * @param pre Predecesor de la ruta.
     */
    public void setPredeccesor(int pre) {
        this.predecessor = pre;
    }

    /**
     * Método que establece el sucesor de la ruta.
     *
     * @param suc Sucesor de la ruta.
     */
    public void setSuccesor(int suc) {
        this.succesor = suc;
    }

    /**
     * Método que establece el identificador de la ruta.
     *
     * @param id Identificador de la ruta.
     */
    public void setId(int id) {
        this.id = id;
    }
}
