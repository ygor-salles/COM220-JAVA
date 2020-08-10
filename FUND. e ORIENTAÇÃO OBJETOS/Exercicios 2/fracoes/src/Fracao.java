public class Fracao {

    int numerador;
    int denominador;

    public Fracao() {
        numerador = 0;
        denominador = 1;
    }

    public Fracao(int num, int den) {
        numerador = num;
        denominador = den;
    }

    public void adiciona(int nro) {
        numerador += nro * denominador;
    }

    public void adiciona(Fracao frac) {
        numerador = numerador * frac.denominador + denominador * frac.numerador;
        denominador *= frac.denominador;
    }

    public String toString() {
        return (numerador + "/" + denominador);
    }
}
