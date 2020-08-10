
import java.util.*;

public class ControleDisciplina {

    //private Vector listaDisciplina = new Vector();
    private ArrayList<Disciplina> listaDisciplina = new ArrayList<>();

    public ControleDisciplina() {
        listaDisciplina.add(new Disciplina(110, "Estrutura de Dados"));
        listaDisciplina.add(new Disciplina(120, "Sistemas Operacionais"));
        listaDisciplina.add(new Disciplina(130, "Programação OO"));
    }

    public ArrayList getListaDisciplina() {
        return listaDisciplina;
    }

    public Disciplina getDisciplina (int codDiscip){
        for (Disciplina d: listaDisciplina){
            if (d.getCodigo() == codDiscip)
                return d;
        }
        return null;
    }
    
}
