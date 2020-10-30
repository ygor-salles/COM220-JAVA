package AulaPOO;

import java.util.Vector;

public class ControleDisciplina {

    private Vector listaDisciplina = new Vector();
    private LimiteDisciplina objCLimiteDisc;

    /**
     * Construtor da classe.
     */
    public ControleDisciplina() {
        objCLimiteDisc = new LimiteDisciplina(this);
    }

    /**
     * Método responsável por fazer a inserção de uma disciplina no vetor.
     *
     * @param pCodigo código da disciplina.
     * @param pNome descrição do nome da disciplina.
     * @param pCargaHoraria carga horária da disciplina.
     */
    public void insereDisciplina(int pCodigo,
            String pNome, int pCargaHoraria) {
        Disciplina disc = new Disciplina(pCodigo, pNome,
                pCargaHoraria);
        listaDisciplina.add(disc);
    }

    /**
     * Método responsável por preparar um texto contendo todas as informações de
     * disciplinas cadadastradas para serem apresentadas ao usuário.
     *
     * @return String descrições de todas as disciplinas cadastradas.
     */
    public String imprimeDisciplinas() {
        String result = "";
        for (int intIdx = 0; intIdx < listaDisciplina.size();
                intIdx++) {
            Disciplina objLDisc
                    = (Disciplina) listaDisciplina.elementAt(intIdx);
            result += "Código: "
                    + objLDisc.getCodigo() + "  Nome: " + objLDisc.getNome()
                    + "  Documento: "
                    + objLDisc.getCargaHoraria() + "\n";
        }
        return result;
    }

    /**
     * Método responsável por preparar a apresentação das informações de uma
     * determinada disciplina.
     *
     * @param pCodigo código da disciplina para apresentação de suas respectivas
     * informações.
     * @return String descrição de todas as informações da disciplina
     */
    public String imprimeDisciplina(int pCodigo) {
        for (int intIdx = 0; intIdx < listaDisciplina.size();
                intIdx++) {
            Disciplina objLDisc
                    = (Disciplina) listaDisciplina.elementAt(intIdx);
            if (objLDisc.getCodigo() == pCodigo) {
                return "Código: " + objLDisc.getCodigo()
                        + "  Nome: " + objLDisc.getNome()
                        + "  Documento: "
                        + objLDisc.getCargaHoraria();
            }
        }
        return "";
    }

    /**
     * Método principal responsável apenas por criar um objeto da classe
     * ControleDisciplina.
     *
     * @param args[] argumentos passados por parâmetros. Nesse sistema nenhum
     * argumento é esperado.
     */
    //public static void main(String args[]) {
  //      new ControleDisciplina();
//    }
}
