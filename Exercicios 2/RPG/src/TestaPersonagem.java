
import java.io.*;
import java.util.*;

public class TestaPersonagem {

    public static void main(String[] args) {

        ArrayList<Personagem> chars = new ArrayList<Personagem>();

        chars.add(new Controlavel("Slackershin", "JeanOliveira92"));
        chars.add(new NaoControlavel("Simon", "Wizard"));
        chars.add(new NaoControlavel("Megam", "Seller"));
        chars.add(new NaoControlavel("Mathew", "Healer"));
        chars.add(new NaoControlavel("Damon", "Rogue"));
        chars.add(new NaoControlavel("Lucrecia", "Dancer"));

        System.out.println("\nPlayer:");
        for (Personagem i : chars) {
            if (i instanceof Controlavel) {
                System.out.println("- "+((Controlavel) i).getNomePersonagem()+" "+((Controlavel) i).getID());
            }
        }
        
        System.out.println("\nNPCs:");
        for (Personagem i : chars) {
            if (i instanceof NaoControlavel) {
                System.out.println("- "+((NaoControlavel) i).getNomePersonagem()+" "+((NaoControlavel) i).getID());
            }
        }
    }

}
