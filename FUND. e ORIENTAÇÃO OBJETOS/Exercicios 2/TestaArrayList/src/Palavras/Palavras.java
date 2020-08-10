
import java.io.*;
import java.util.*;

public class Palavras {

    ArrayList<String> palavras = new ArrayList<String>();

    public void leArq() {
        try {
            Scanner input = new Scanner(new File("texto.txt"));
            while (input.hasNext()) {
                String pal = input.next();
                palavras.add(pal);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public void paraMaiuscula() {
        String temp = null;
        for (int i = 0; i < palavras.size(); i++) {
            if (palavras.get(i).endsWith("s") || palavras.get(i).endsWith("s.") || palavras.get(i).endsWith("s,s")) {
                temp = palavras.get(i).toUpperCase();
                palavras.set(i, temp);

            }
        }
    }

//public String imprimeTexto() {
    // return palavras.toString();
    //}
    public String imprimeTexto1() {
        String texto = "";
        for (int i = 0; i < palavras.size(); i++) {
            texto += palavras.get(i) + " ";
        }
        return texto;
    }

    public String imprimeTexto2() {
        String texto = "";
        for (String palavra : palavras) {
            texto += palavra + " ";
        }
        return texto;
    }

    public String imprimeInverso() {
        String inverso = "";
        for (int i = palavras.size() - 1; i >= 0; i--) {
            inverso += palavras.get(i) + " ";
        }
        return inverso;
    }

    public static void main(String args[]) {
        Palavras pal = new Palavras();
        pal.leArq();
        System.out.println(pal.imprimeTexto1());
        pal.paraMaiuscula();
        System.out.println(pal.imprimeTexto2());
        System.out.println(pal.imprimeInverso());
    }
}
