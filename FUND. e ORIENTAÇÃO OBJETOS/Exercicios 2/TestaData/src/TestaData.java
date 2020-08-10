import java.util.*;
import java.text.*;

public class TestaData {
    
    public static void main(String[] args){
        Date hoje = new Date();
        Locale brasil = new Locale("pt","BR");
        
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, brasil);
        System.out.println("Hoje no Brasil: "+ df.format(hoje));
         
        df = DateFormat.getDateInstance(DateFormat.LONG, Locale.UK);
        System.out.println("Today in United Kingdon: "+ df.format(hoje));
    }
}
