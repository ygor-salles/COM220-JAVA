
package Funcionario;

/**
 *
 * @author Jean
 */
public class PontoFuncionario {
    private int mes;
    private int ano;
    private int nFaltas;
    private int nAtrasos;

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int getNFaltas() {
        return nFaltas;
    }

    public int getNAtrasos() {
        return nAtrasos;
    }
    
    public PontoFuncionario(int pMes, int pAno) {
        mes = mes;
        ano = ano;
    }
    
    public PontoFuncionario(int pMes, int pAno, int pNFaltas, int pNAtrasos) {
        mes = mes;
        ano = ano;
        nFaltas = nFaltas;
        nAtrasos = nAtrasos;
    }
    
    public void lancaFaltas(int pNFaltas){
        nFaltas = pNFaltas;
    }
    
    public void lancaAtrasos(int pNAtrasos){
        nAtrasos = pNAtrasos;
    } 
}
