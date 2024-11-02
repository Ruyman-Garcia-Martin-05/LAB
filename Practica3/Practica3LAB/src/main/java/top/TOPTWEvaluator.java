package top;

/**
 * Clase que implementa un evaluador de soluciones al problema TOPTW.
 */
public class TOPTWEvaluator {
    /**
     * Valor que indica que una solución no ha sido evaluada.
     */
    public static double NO_EVALUATED = -1.0;

    /**
     * Método que evalúa una solución al problema TOPTW.
     *
     * @param solution Solución a evaluar.
     */
    public void evaluate(TOPTWSolution solution) {
        /*CumulativeCVRP problem = solution.getProblem();
        double objectiveFunctionValue = 0.0;
        for (int i = 0; i < solution.getIndexDepot().size(); i++) {
            double cumulative = 0;
            int depot = solution.getAnIndexDepot(i);
            int actual = depot;
            actual = solution.getSuccessor(actual);
            cumulative += problem.getDistanceMatrix(0, actual);
            objectiveFunctionValue += problem.getDistanceMatrix(0, actual);
            System.out.println("Desde " + 0 + " a " + actual + " = " + cumulative);
            while (actual != depot) {
                int ant = actual;
                actual = solution.getSuccessor(actual);
                if (actual != depot) {
                    cumulative += problem.getDistanceMatrix(ant, actual);
                    objectiveFunctionValue += cumulative;
                    System.out.println("Desde " + ant + " a " + actual + " = " + cumulative);
                } else {
                    cumulative += problem.getDistanceMatrix(ant, 0);
                    objectiveFunctionValue += cumulative;
                    System.out.println("Desde " + ant + " a " + 0 + " = " + cumulative);
                }
            }
            System.out.println("");
        }
        solution.setObjectiveFunctionValue(objectiveFunctionValue);*/
    }
}
