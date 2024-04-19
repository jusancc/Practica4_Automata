public class AutomataFinitoMatriz extends AutomataFinito {

    /* La transición se representa por una matriz. Las filas representan estados, las columnas letras.
     * La entrada (i, j) de la matriz será el estado alcanzado desde el estado ”i” si se recibe la letra “j”.
     * Podemos poner un -1 para indicar error, esto es, no existe esa transición.
     */
    private int[][] matriz;

    public AutomataFinitoMatriz(int num, int alfabeto) {
        super(num, alfabeto);
        this.matriz = new int[num][alfabeto];
    }

    public AutomataFinitoMatriz(int num, int alfabeto, boolean[] finales) {
        super(num, alfabeto, finales);
        this.matriz = new int[num][alfabeto];
    }

    // Implementación de la función de transición
    @Override
    public int transicion(int estado, int letra) {
        if (estado >= 0 && estado < matriz.length && letra >= 0 && letra < matriz[0].length) {
            return matriz[estado][letra];
        } else {
            return -1; // Por ejemplo, -1 indica error
        }
    }

    // Implementación de la función de transición void
    @Override
    public void transicion(int letra) {

    }

}
