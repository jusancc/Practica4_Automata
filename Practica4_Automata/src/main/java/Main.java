import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Definición de las equivalencias de tokens
        Map<Integer, String> equivTokens = new HashMap<>();
        equivTokens.put(0, "cero");
        equivTokens.put(1, "uno");
        equivTokens.put(2, "dos");
        equivTokens.put(3, "tres");
        equivTokens.put(4, "cuatro");

        // Definición de la matriz de transiciones para el autómata finito
        int[][] matriz = {
                {1, -1, -1},   // Estado 0: Transiciones para a, b, c
                {-1, 2, -1},   // Estado 1: Transiciones para a, b, c
                {-1, -1, 3}    // Estado 2: Transiciones para a, b, c
        };

        // Creación del autómata finito
        AutomataFinito automata = new AutomataFinitoMatriz(3, 3, matriz, new boolean[]{false, false, true});

        // Cadena de entrada
        int[] cadena = {0, 1, 0, 1, 1, 2, 2, 0, 2, 2, 2};

        // Creación del analizador léxico
        AnalizadorLexico analizador = new AnalizadorLexico(cadena, automata, equivTokens);

        // Obtención de los tokens
        Token token;
        while ((token = analizador.nextToken()) != null) {
            System.out.println("Token: " + token.getId() + ", Lexema: " + Arrays.toString(token.getLexema()));
        }
    }
}
