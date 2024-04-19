public class AutomataFinitoMatriz extends AutomataFinito {
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
            return -1;
        }
    }

    // Implementación de la función de transición void
    @Override
    public void transicion(int letra) {
        if (letra >= 0 && letra < matriz[0].length) {
            this.estActual = matriz[this.estActual][letra];
        } else {
            System.out.println("Se ha producido un error");
        }
    }

    @Override
    public void cierreTransicion(int estado, int[] cadena) {
        for (int letra : cadena) {
            transicion(letra);
        }
    }

    @Override
    public boolean perteneceLenguaje(String cadena) {
        int estadoActual = this.estActual;
        for (char caracter : cadena.toCharArray()) {
            int letra = caracter - 'a'; // Suponiendo que 'a' corresponde a 0, 'b' a 1, etc.
            estadoActual = transicion(estadoActual, letra);
            if (estadoActual == -1) {
                return false; // La cadena no pertenece al lenguaje
            }
        }
        return esEstadoFinal(estadoActual);
    }

}