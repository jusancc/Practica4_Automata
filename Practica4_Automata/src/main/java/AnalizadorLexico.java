import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class AnalizadorLexico {
    private int[] cadena;
    private AutomataFinito automata;
    private int posActual;
    private Map<Integer, String> tokens;
    private List<Token> historico;

    /* El constructor dará valor a los atributos mediante los parámetros e inicializará el análisis léxico de la cadena,
     * es decir, no hay nada en el histórico y posActual = 0 */
    public AnalizadorLexico(int[] cadena, AutomataFinito automata, Map<Integer,String> tokens) {
        this.cadena = cadena;
        this.automata = automata;
        this.tokens = tokens;
        this.posActual = 0;
        this.historico = new ArrayList<>();
    }

    /* Método esencial para hacer avanzar el análisis; su función es generar el siguiente token.
     * No hay que olvidar que debe ser el más largo posible.
     * Hay que ser muy cuidadoso para evitar errores por final de cadena, transición a error, etc.*/
    public Token nextToken() {
        int estadoActual = 0;
        int inicioToken = posActual;

        while (posActual < cadena.length) {
            int siguienteEstado = automata.transicion(estadoActual, cadena[posActual]);
            if (siguienteEstado != -1) {
                estadoActual = siguienteEstado;
                posActual++;
            } else {
                break;
            }
        }

        if (posActual > inicioToken) {
            String tipoToken = tokens.getOrDefault(estadoActual, "ERROR");
            Token token = new Token(tipoToken, Arrays.copyOfRange(cadena, inicioToken, posActual));
            historico.add(token);
            return token;
        } else {
            return null;
        }
    }

    public boolean hasMoreTokens() {
        return posActual < cadena.length;
    }
}
