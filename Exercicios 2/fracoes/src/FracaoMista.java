
public class FracaoMista extends Fracao {

    int parteInteira;

    public FracaoMista() {
        super();
        parteInteira = 0;
    }

    public FracaoMista(int pa, int num, int den) {
        super(num, den);
        parteInteira = pa;
    }

    public String toString() {
        if (numerador == 0 && denominador == 0) {
            return ("" + parteInteira);
        }
        return (parteInteira + " " + numerador + "/" + denominador);
    }

}
