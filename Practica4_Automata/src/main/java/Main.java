import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<Integer, String> tokens = new HashMap<>();
        tokens.put(0, "cero");
        tokens.put(1, "uno");
        tokens.put(2, "dos");
        tokens.put(3, "tres");
        tokens.put(4, "cuatro");

        // Autómata para el patrón 'a'
        AutomataFinitoMatriz automataA = new AutomataFinitoMatriz(2, 3);
        automataA.setFinales(new boolean[]{false, true});
        automataA.transicion(0, 0);
        automataA.transicion(1, 0);
        automataA.transicion(0, 0);
        automataA.transicion(1, 0);

// Autómata para el patrón 'b'
        AutomataFinitoMatriz automataB = new AutomataFinitoMatriz(2, 3);
        automataB.setFinales(new boolean[]{false, true});
        automataB.transicion(0, 1);
        automataB.transicion(1, 1);
        automataB.transicion(0, 1);
        automataB.transicion(1, 1);

// Autómata para el patrón 'aabb'
        AutomataFinitoMatriz automataAABB = new AutomataFinitoMatriz(4, 3);
        automataAABB.setFinales(new boolean[]{false, false, false, true});
        automataAABB.transicion(0, 0);
        automataAABB.transicion(1, 0);
        automataAABB.transicion(2, 0);
        automataAABB.transicion(3, 0);
        automataAABB.transicion(3, 1);
        automataAABB.transicion(0, 1);
        automataAABB.transicion(1, 1);
        automataAABB.transicion(2, 1);

// Autómata para el patrón '((a)*)((b)+)'
        AutomataFinitoMatriz automataAB = new AutomataFinitoMatriz(4, 3);
        automataAB.setFinales(new boolean[]{true, false, false, false});
        automataAB.transicion(0, 0);
        automataAB.transicion(1, 0);
        automataAB.transicion(2, 0);
        automataAB.transicion(3, 0);
        automataAB.transicion(3, 1);
        automataAB.transicion(0, 1);
        automataAB.transicion(1, 1);
        automataAB.transicion(2, 1);

// Autómata para el patrón '(c)+'
        AutomataFinitoMatriz automataC = new AutomataFinitoMatriz(2, 3);
        automataC.setFinales(new boolean[]{false, true});
        automataC.transicion(0, 2);
        automataC.transicion(1, 2);
        automataC.transicion(0, 2);
        automataC.transicion(1, 2);

        int[] cadena = {0, 1, 0, 1, 1, 2, 2, 0, 2, 2, 2};
        AnalizadorLexico analizador = new AnalizadorLexico(cadena, automataAABB, tokens);

        Token token;
        while ((token = analizador.nextToken()) != null) {
            System.out.println("Token: " + token.getId() + ", Lexema: " + Arrays.toString(token.getLexema()));
        }
    }
}
