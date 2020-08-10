
public class TestaFracao {

    public static void main(String arg[]) {
        int pa;

        FracaoMista F1 = new FracaoMista(0, 7, 6);
        FracaoMista F2 = new FracaoMista(0, 13, 7);
        FracaoMista F3 = new FracaoMista(0, 1, 1);

        F1 = simplifica(F1);
        F2 = simplifica(F2);

        Fracao a = new Fracao();
        Fracao b = new Fracao();

        a.numerador = F1.numerador;
        a.denominador = F1.denominador;
        b.numerador = F2.numerador;
        b.denominador = F2.denominador;

        F3.adiciona(F1.parteInteira);
        F3 = simplifica(F3);
        F3.adiciona(F2.parteInteira);
        F3 = simplifica(F3);
        F3.adiciona(a);
        F3 = simplifica(F3);
        F3.adiciona(b);
        F3 = simplifica(F3);

        if ((F3.numerador / F3.denominador) >= 1) {
            F3 = ajusteInteiro(F3);
        }
        F3 = simplifica(F3);
        System.out.println(F3.toString());

    }

    public static FracaoMista ajusteInteiro(FracaoMista f) {
        int pa;

        pa = f.numerador / f.denominador;
        f.parteInteira = pa - 1;
        f.numerador = f.numerador % f.denominador;

        return f;
    }

    public static FracaoMista simplifica(FracaoMista f) {
        int i;
        for (i = 1; i <= f.denominador; i++) {
            if (f.denominador % i == 0 && f.numerador % i == 0) {
                f.denominador /= i;
                f.numerador /= i;
            }
        }
        return f;
    }
}
