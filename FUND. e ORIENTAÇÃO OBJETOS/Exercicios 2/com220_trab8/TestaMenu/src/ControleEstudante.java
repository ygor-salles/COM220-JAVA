
import java.util.*;

public class ControleEstudante {

    //private Vector listaEstudante = new Vector();
    private ArrayList<Estudante> listaEstudante = new ArrayList<>();

    public ControleEstudante() {
        listaEstudante.add(new Estudante(1001, "José da Silva"));
        listaEstudante.add(new Estudante(1002, "João de Souza"));
        listaEstudante.add(new Estudante(1003, "Marcelo dos Santos"));
        listaEstudante.add(new Estudante(1004, "Marcelo dos Santos"));
        listaEstudante.add(new Estudante(1005, "Douglas Costa"));
        listaEstudante.add(new Estudante(1006, "Marina Lima"));
        listaEstudante.add(new Estudante(1007, "Antonio Souza"));
        listaEstudante.add(new Estudante(1008, "Marcel Nogueira"));
    }

    public ArrayList<Estudante> getListaEstudante() {
        return listaEstudante;
    }

    public Estudante getEstudante (int nroMatric){
        for (Estudante est: listaEstudante){
            if(est.getNroMatric() == nroMatric)
                return est;
        }
        return null;
    }    
}
