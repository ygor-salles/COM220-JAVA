package Disciplina;

import java.util.*;
import java.lang.*;

public class VetorDisciplina {

    private Vector disciplinas;

    // Construtor de Vetor disciplinas
    public VetorDisciplina() {
        disciplinas = new Vector(1, 1);
    }

    // Adiciona uma disciplina no vetor disciplinas
    public void insereDisciplina(int pCod, String pNome, int pCargaHoraria) {
        disciplinas.addElement(new Disciplina(pCod, pNome, pCargaHoraria));
    }

    // Funcao de remoção da disciplina
    public void removeDisciplina(String pNome) {
        //int i=0;
        for (int i=0; i <= disciplinas.size(); i++) {
            if (((Disciplina)disciplinas.elementAt(i)).getNome().equals(pNome)) {
                disciplinas.removeElementAt(i);
            }
       }
    }

    public String toString() {
        String str = "";
        str +="Nome\tCodigo\tCargaHoraria";
        
        for (Object d : disciplinas) {
            str += "\n"+((Disciplina) d).getNome()+
                    "\t"+((Disciplina) d).getCod()+
                    "\t"+((Disciplina) d).getCargaHoraria();
        }
        
        return str;
    }
}
