import java.lang.Math;

public class Retas {

    public static void main(String args[]) {
        Ponto p1 = new Ponto(5,10);
        Ponto p2 = new Ponto(55,105);
        
        Reta r1 = new Reta(p1, p2);
        Reta r2 = new Reta(p1.getX(), p1.getY(), p2.getX(), p2.getY());
        
        System.out.println("Reta 1: "+r1.toString());
        System.out.println("Reta 2: "+r2.toString());
        
        System.out.println("\nReta 1: Tamanho de "+r1.retaTamanho()+" unidades");
        System.out.println("Reta 2: Tamanho de "+r2.retaTamanho()+" unidades");
        
        r1.setXIni(8);
        r1.setXFim(13);
        r1.setYIni(35);
        r1.setYFim(85);
        
        r2.setXYInicial(15,23);
        r2.setXYFinal(55,135);
        
        System.out.println("\nApos a alteração\nReta 1: "+r1.toString());
        System.out.println("Reta 2: "+r2.toString());
        System.out.println("\nReta 1: Tamanho de "+r1.retaTamanho()+" unidades");
        System.out.println("Reta 2: Tamanho de "+r2.retaTamanho()+" unidades");
    }
}
