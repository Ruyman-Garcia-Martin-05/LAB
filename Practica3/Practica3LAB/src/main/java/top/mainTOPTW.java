package top;

/**
 * Clase que implementa una solución al problema TOPTW.
 */
public class mainTOPTW {
    /**
     * Método principal de la clase mainTOPTW.
     *
     * @param args Argumentos de la línea de comandos.
     */
    public static void main(String[] args) {
        
        String[] instances = new String[29];
        
        instances[0] = "c101.txt"; instances[3] = "c104.txt"; instances[6] = "c107.txt";
        instances[1] = "c102.txt"; instances[4] = "c105.txt"; instances[7] = "c108.txt";
        instances[2] = "c103.txt"; instances[5] = "c106.txt"; instances[8] = "c109.txt"; 

        instances[9] = "r101.txt";  instances[12] = "r104.txt"; instances[15] = "r107.txt";
        instances[10] = "r102.txt"; instances[13] = "r105.txt"; instances[16] = "r108.txt";
        instances[11] = "r103.txt"; instances[14] = "r106.txt"; instances[17] = "r109.txt";
        instances[18] = "r110.txt"; instances[19] = "r111.txt"; instances[20] = "r112.txt";
        
        instances[21] = "rc101.txt"; instances[24] = "rc104.txt"; instances[27] = "rc107.txt";
        instances[22] = "rc102.txt"; instances[25] = "rc105.txt"; instances[28] = "rc108.txt";
        instances[23] = "rc103.txt"; instances[26] = "rc106.txt"; 
        
        for(int i = 0; i < instances.length; i++) {
            String INSTANCE = "Instances/TOPTW/"+instances[i];
            TOPTW problem = TOPTWReader.readProblem(INSTANCE);
            TOPTWSolution solution = new TOPTWSolution(problem);
            TOPTWGRASP grasp = new TOPTWGRASP(solution);

            System.out.println(" --> Instance: "+instances[i]);
            grasp.GRASP(10000, 3);
            grasp.GRASP(10000, 5);
            grasp.GRASP(10000, 7);
            System.out.println("");
        }
    }
    
}
