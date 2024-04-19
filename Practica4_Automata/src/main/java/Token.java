public class Token {
    //En realidad l estamos llamando token a la pareja (token, lexema)
    private String idToken;
//Para el lexema se puede usar un vector de enteros, List de entero,….
    private int[] lexema;

    public Token(String id, int[] lexema) {
        this.idToken = id;
        this.lexema = lexema;
    }
    public String getId() {
        return this.idToken;
    }
    public int[] getLexema() {
        return this.lexema;
    }
}