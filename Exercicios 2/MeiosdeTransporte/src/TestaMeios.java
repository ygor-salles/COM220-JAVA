
import java.io.*;
import java.util.*;
import java.util.Random;
import meiosdetransporte.*;

public class TestaMeios {

    public static void main(String[] args) {
        ArrayList<Transporte> iMoto = new ArrayList<Transporte>();
        ArrayList<Transporte> iCond = new ArrayList<Transporte>();

        iMoto.add(new Aviao("Boing", 4));
        iMoto.add(new Carro("Gol", "Hatch", 74));

        iCond.add(new Aviao("747", 2));
        iCond.add(new Carro("Lancer", "Sedan", 127));
        iCond.add(new Bicicleta("Caloi", "Off-Road", 28));
        
        System.out.println("\nLigando os motores dos Motorizados");
        for(Transporte t : iMoto){
            if(t instanceof Aviao)
                ((Aviao)t).ligarMotor();
            
            if(t instanceof Carro)
                ((Carro)t).ligarMotor();
        }
        
        Random gerador = new Random();
        
        
        System.out.println("\nCurvando os Conduziveis");
        for(Transporte t : iCond){
            if(t instanceof Aviao)
                ((Aviao)t).curvar(gerador.nextInt(50)*1.5);
            
            if(t instanceof Carro){
                ((Carro)t).curvar(gerador.nextInt(50)*1.5);
            }
            
            if(t instanceof Bicicleta){
                ((Bicicleta)t).curvar(gerador.nextInt(50)*1.5);
            }
        }
    }

}
