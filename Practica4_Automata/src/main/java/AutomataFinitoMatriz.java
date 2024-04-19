public class AutomataFinitoMatriz extends AutomataFinito{

    /* La transición se representa por una matriz. Las filas representan estados, las columnas letras. La entada (i, j) de la matriz será el estado alcanzado desde el estado ”i” si se recibe la letra “j”. Podemos poner un -1 para indicar error, esto es, no existe esa transición
     */
    private int [] [] matriz;

    public AutomataFinitoMatriz(int num, int alfabeto) {
        super(num, alfabeto);
    }

    public AutomataFinitoMatriz(int num, int alfabeto, boolean[] finales) {
        super(num, alfabeto, finales);
    }

    //Constructores
// Implementación de la función de transición. Devuelve la correspondiente entrada de la matriz. Habrá que ser consecuente si se usa la “versión void”. */

    @Override
    public int transicion(int estado, int letra) {
        return 0;
    }

    @Override
    public void transicion(int letra) {

    }
}
