
public class Ponto {

    private int x;
    private int y;

    // CONSTRUTOR COM PARAMETROS
    public Ponto(int pX, int pY) {
        x = pX;
        y = pY;
    }

    // CONSTRUTOR VAZIO
    public Ponto() {
    }

    // SETTERS
    public void setX(int pX) {
        x = pX;
    }

    public void setY(int pY) {
        y = pY;
    }

    // GETTERS
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    //Operacao toString da classe Ponto
    public String toString() {
        return "("+x+", "+y+")";
    }

}
