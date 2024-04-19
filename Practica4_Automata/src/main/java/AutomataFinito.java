public abstract class AutomataFinito {
    private int numEstados;
    private boolean[] finales;
    private int tamAlfabeto;
    private int estActual;

    //Constructores: sin finales (luego se pueden marcar) y con finales
    protected AutomataFinito (int num, int alfabeto){
        this.numEstados = num;
        this.tamAlfabeto = alfabeto;
        this.estActual = 0;
    }
    protected AutomataFinito (int num, int alfabeto, boolean [] finales){
        this.numEstados = num;
        this.tamAlfabeto = alfabeto;
        this.finales = finales;
        this.estActual = 0;
    }
    //Otros métodos
    public void marcarFinal(int estado){
        this.estActual = estado;
    }
    public void setFinales(boolean[] estadosFinales){
        this.finales = estadosFinales;
    }
    public int getNumEstados(){
        return this.numEstados;
    }
    public boolean[] getFinales(){
        return this.finales;
    }
    //Método observador para determinar si un estado es final
    public boolean esEstadoFinal (int estado){

    }
    /*Método de transición. Se puede pensar como método que informa del estado que se alcanza partiendo de un estado y recibiendo una entrada*/
    public abstract int transicion (int estado, int letra);
    /*Otra versión, pensando que una transición produce una modificación del estado actual del autómata. Resulta mejor como orientación a objetos, pero complica un poco nuestro uso. */
    public abstract void transicion (int letra);
//La extensión de la transición a cadenas. Posible versión void si transición modifica el estado
    public cierreTransicion (int estado, int cadena []){

    }
//Método que informa si una cadena pertenece al lenguaje definido por el autómata
    public boolean perteneceLenguaje (){

    }

}
