import java.util.List;
import java.util.Map;

public class AnalizadorLexico {
    private int[] cadena;
    private AutomataFinito automata;
    private int posActual;
    private Map<Integer, String> tokens;
    private List<Token> historico;


    /*El constructor dará valor a los atributos mediante los parámetros e inicializará el análisis léxico de la cadena,
     es decir, no hay nada en el histórico y .posActual = 0 */
    public AnalizadorLexico() {

    }

    /*Método esencial para hacer avanzar el análisis; su función es generar el siguiente token. No hay que olvidar que debe ser el más largo posible.
Hay que ser muy cuidadoso para evitar errores por final de cadena, transición a error, etc.*/
    public Token nextToken() {

    }

    public boolean hasMoreTokens(){

    }


}
