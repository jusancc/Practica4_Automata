public abstract class AutomataFinito {
    private int numEstados;
    private boolean[] finales;
    private int tamAlfabeto;
    private int estActual;

    // Constructores
    protected AutomataFinito(int num, int alfabeto) {
        this.numEstados = num;
        this.tamAlfabeto = alfabeto;
        this.estActual = 0;
    }

    protected AutomataFinito(int num, int alfabeto, boolean[] finales) {
        this.numEstados = num;
        this.tamAlfabeto = alfabeto;
        this.finales = finales;
        this.estActual = 0;
    }

    // Otros métodos
    public void marcarFinal(int estado) {
        this.estActual = estado;
    }

    public void setFinales(boolean[] estadosFinales) {
        this.finales = estadosFinales;
    }

    public int getNumEstados() {
        return this.numEstados;
    }

    public boolean[] getFinales() {
        return this.finales;
    }

    // Método observador para determinar si un estado es final
    public boolean esEstadoFinal(int estado) {
        return this.finales[estado];
    }

    // Método de transición
    public abstract int transicion(int estado, int letra);

    // Versión que modifica el estado actual del autómata
    public abstract void transicion(int letra);

    // Extensión de la transición a cadenas
    public abstract void cierreTransicion(int estado, int[] cadena);

    // Método que informa si una cadena pertenece al lenguaje definido por el autómata
    public abstract boolean perteneceLenguaje(String cadena);
}
