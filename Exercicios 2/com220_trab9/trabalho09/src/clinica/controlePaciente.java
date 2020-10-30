package clinica;

import java.util.*;

/**
 *
 * @author Jean
 */
public class controlePaciente {
    private limitePaciente limite;
    private ArrayList<paciente> pacientes;

    public controlePaciente() {
        pacientes = new ArrayList<paciente>();
        limite = new limitePaciente(this);
    }

    public void addParticular(String pNome, String pEndereco, String pCpf) {
        pacientes.add(new particular(pNome, pEndereco, pCpf));
    }

    public void addConvenio(String pNome, String pEndereco, String pNomeConvenio, String pNroCartao) {
        pacientes.add(new convenio(pNome, pEndereco, pNomeConvenio, pNroCartao));
    }

    public boolean validaRegistro(String pReg) {
        for (paciente p : pacientes) {
            if (p instanceof particular) {
                if (((particular) p).getCpf().equals(pReg)) {
                    return true;
                }
            } else if (p instanceof convenio) {
                if (((convenio) p).getNroCartao().equals(pReg)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void criarSessao(int dia, int mes, String tipo, String pReg) throws Exception {

        System.out.println(tipo);
        sessao s = new sessao(dia, mes, tipo);

        for (paciente p : pacientes) {
            if (p instanceof particular) {
                if (((particular) p).getCpf().equals(pReg)) {
                    ((particular) p).getSessoes().add(s);
                }
            } else if (p instanceof convenio) {
                if (((convenio) p).getNroCartao().equals(pReg)) {
                    ((convenio) p).getSessoes().add(s);
                }
            }
        }
    }

    public String geraFichaPaciente(String pReg) {
        String ficha = "";
        for (paciente p : pacientes) {
            if (p instanceof particular) {
                if (((particular) p).getCpf().equals(pReg)) {
                    ficha += "Nome: " + ((particular) p).getNome()
                            + "\nEndereço: " + ((particular) p).getEndereco()
                            + "\nCPF: " + ((particular) p).getCpf();

                    ArrayList<sessao> s = ((particular) p).getSessoes();
                    for (sessao o : s) {
                        ficha += "\n\nData: " + o.getDia() + "/" + o.getMes()
                                + " " + o.getTipo();
                   }
                }
            } else if (p instanceof convenio) {
                if (((convenio) p).getNroCartao().equals(pReg)) {
                    ficha += "Nome: " + ((convenio) p).getNome()
                            + "\nEndereço: " + ((convenio) p).getEndereco()
                            + "\nConvênio: " + ((convenio) p).getNomeConvenio() + " Nº:" + ((convenio) p).getNroCartao();

                    ArrayList<sessao> s = ((convenio) p).getSessoes();
                    for (sessao o : s) {
                        ficha += "\n\nData: " + o.getDia() + "/" + o.getMes()
                                + " " + o.getTipo();
                    }
                }
            }
        }
        return ficha;
    }

    public double calculoFaturamento(int mes) {
        double fa = 0.0;

        for (paciente p : pacientes) {
            if (p instanceof particular) {
                fa += ((particular) p).calculaFaturamento(mes);
            } else if (p instanceof convenio) {
                fa += ((convenio) p).calculaFaturamento(mes);
            }
        }
        return fa;
    }
    
    public void openWindow(int n){
        switch(n){
            case 1:
                new FrameAddPaciente(this);
                break;
            case 2:
                new FrameAddSessao(this);
                break;
            case 3:
                new FrameFichaPaciente(this);
                break;
            case 4:
                new FrameFaturamento(this);
                break;
        }
    }
    
    public static void main(String args[]){
        controlePaciente principal = new controlePaciente();
    }
}
