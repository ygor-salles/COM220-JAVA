
import java.util.ArrayList;


public class TestaArrayList {
    public static void main (String[] args) {
        ArrayList<String> nomes = new ArrayList<>();
        nomes.add("Flávio");
        nomes.add("Eduardo");
        System.out.println(nomes.toString());
        nomes.remove(1);
        System.out.println(nomes.toString());
        
        /* exemplo de instanceof
        
            public int getNroPassageiros() {
            int nroPassageiros = 0;
             for (int i = 0; i < viajantes.size(); i++) {
            Object v = viajantes.get(i);
            if (v instanceof Passageiro) 
                nroPassageiros++;
            }
            return nroPassageiros;
    }
        */
    }
}
