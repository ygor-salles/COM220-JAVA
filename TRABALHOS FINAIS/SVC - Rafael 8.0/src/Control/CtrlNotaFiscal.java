package Control;

import Model.NotaFiscal;
import Model.Produto;
import Model.Venda;
import View.LimNotaFiscal;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JOptionPane;

public class CtrlNotaFiscal  implements Serializable {

    //atributos
    private ArrayList<NotaFiscal> arrayNotaFiscal = new ArrayList<NotaFiscal>();
    private LimNotaFiscal limite;
    private final String arquivo = "notas.dat";
    private NotaFiscal nf;
    private String nota = "";

    //construtor
    public CtrlNotaFiscal() {
        try {
            desserializaNotas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void serializaNotas() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream(arquivo);
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(arrayNotaFiscal);
        objOS.flush();
        objOS.close();
    }

    public void desserializaNotas() throws Exception {
        File objFile = new File(arquivo);
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream(arquivo);
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            arrayNotaFiscal = (ArrayList<NotaFiscal>) objIS.readObject();
            objIS.close();
        }
    }

    //métodos
    public void cadastrarNotaFiscal(int dia, int mes, int ano,
            int codNota, String cpf) {
        //int codigo = ThreadLocalRandom.current().nextInt(0, 100 + 1);
        NotaFiscal nota = new NotaFiscal(dia,mes,ano,codNota,cpf);
        arrayNotaFiscal.add(nota);
        
        try {
            serializaNotas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void setNota(){
        nf = new NotaFiscal();
        int q = arrayNotaFiscal.size() -1;
        Object o = arrayNotaFiscal.get(q);
        
        nota += arrayNotaFiscal.get(q).getDia()+"/"+arrayNotaFiscal.get(q).getMes()+"/"+arrayNotaFiscal.get(q).getAno();
        nota += "\nCPF: "+arrayNotaFiscal.get(q).getCpf();
        nota += "\nCódigo da nota: "+arrayNotaFiscal.get(q).getCodigonota();
    }

    public String getNota() {
        return nota;
    }
    public boolean verificaNotaFiscal(int codigo) {
        boolean achou = false;

        for (int i = 0; i < arrayNotaFiscal.size(); i++) {
            Object o = arrayNotaFiscal.get(i);

            if (((NotaFiscal) o).getCodigonota() == codigo) {
                achou = true;
            }
        }

        return achou;
    }
    
    public double faturamentoCliente(String CPF) {
        double valorVendido = 0.0;

        for (int i = 0; i < arrayNotaFiscal.size(); i++) {
            Object o = arrayNotaFiscal.get(i);

            if (o instanceof NotaFiscal) {
                if (((NotaFiscal) o).getCpf().equals(CPF)) {
                    for (int j = 0; j < ((NotaFiscal) o).getListaVendas().size(); j++) {
                        valorVendido += ((NotaFiscal) o).getListaVendas().get(j).getProd().getPreco_venda()
                                * ((NotaFiscal) o).getListaVendas().get(j).getQuantidade();
                    }
                }

            }
        }
        return valorVendido;
    }

    public double valorNota(NotaFiscal p) {
        double valortotal = 0.0;
        for (int i = 0; i < p.getListaVendas().size(); i++) {
            Object o = p.getListaVendas().get(i);
            
            if (o instanceof Venda) {
                valortotal += ((Venda) o).getProd().getPreco_venda() * ((Venda) o).getQuantidade();
            }
        }
        return valortotal;
    }
    
    public double valorPago(NotaFiscal p){
        double valorPago = 0.0;
        
        for(int i=0; i<p.getListaVendas().size(); i++){
            Object o = p.getListaVendas().get(i);
            
            if(o instanceof Venda){
                valorPago += ((Venda) o).getProd().getPreco_compra() * ((Venda) o).getQuantidade();
            }
        }
        
        return valorPago;
    }

    public String faturamentoClientaData(String CPF, int anoini, int mesini, int diaini, int anofim,
            int mesfim, int diafim) {
        double valorTotal = 0.0;
        String texto = "";

        for (int i = 0; i < arrayNotaFiscal.size(); i++) {
            Object o = arrayNotaFiscal.get(i);
            if (o instanceof NotaFiscal) {
                if (((NotaFiscal) o).getAno() > anoini && ((NotaFiscal) o).getAno() < anofim
                        && ((NotaFiscal) o).getMes() > mesini && ((NotaFiscal) o).getMes() < mesfim
                        && ((NotaFiscal) o).getDia() > diaini && ((NotaFiscal) o).getDia() < diafim
                        && ((NotaFiscal) o).getCpf().equals(CPF)) {
                    valorTotal += valorNota((NotaFiscal) o);
                    texto += "Nota Fiscal " + ((NotaFiscal) o).getCodigonota()
                            + "\t" + "Valor: " + valorNota((NotaFiscal) o) + "\n";
                }
            }
        }
        texto += "\n\n\nValor Total: " + valorTotal;
        return texto;
    }
    
    public double faturamentoPeriodo(int anoini, int mesini, int diaini, int anofim, int mesfim,
            int diafim){
        
        double faturamento = 0.0;
        
        for(int i=0; i<arrayNotaFiscal.size(); i++){
            Object o = arrayNotaFiscal.get(i);
            
            if (o instanceof NotaFiscal) {
                if (((NotaFiscal) o).getAno() > anoini && ((NotaFiscal) o).getAno() < anofim
                        && ((NotaFiscal) o).getMes() > mesini && ((NotaFiscal) o).getMes() < mesfim
                        && ((NotaFiscal) o).getDia() > diaini && ((NotaFiscal) o).getDia() < diafim) {
                    faturamento += valorNota((NotaFiscal) o);
                }
            }
        }
        
        return faturamento;
    }
    
    public double lucroLiquidoPeriodo(int anoini, int mesini, int diaini, int anofim, int mesfim,
            int diafim){
        
        double lucro = 0.0;
        
        for(int i=0; i<arrayNotaFiscal.size(); i++){
            Object o = arrayNotaFiscal.get(i);
            
            if (o instanceof NotaFiscal) {
                if (((NotaFiscal) o).getAno() > anoini && ((NotaFiscal) o).getAno() < anofim
                        && ((NotaFiscal) o).getMes() > mesini && ((NotaFiscal) o).getMes() < mesfim
                        && ((NotaFiscal) o).getDia() > diaini && ((NotaFiscal) o).getDia() < diafim) {
                    lucro += valorNota((NotaFiscal) o) - valorPago((NotaFiscal) o);
                }
            }
        }
        
        return lucro;
    }
    
    public void viewVenda(int n, CtrlNotaFiscal nf) {
        limite = new LimNotaFiscal(n);
    } 

    /*
    private LimNotaFiscal limnotafiscal = new LimNotaFiscal();
    private NotaFiscal notafiscal;
    private final String arquivo = "historico.dat";
    private ArrayList<NotaFiscal> historico = new ArrayList<NotaFiscal>();

    public CtrlNotaFiscal() throws Exception {
        desserializaNotafiscal();
    }
    
    public int consultaNota (String pCod) {
        int idx = -1;
        for (NotaFiscal notaFiscal : this.historico) {
            idx += 1;
            if (notaFiscal.equals(pCod)) {
                return idx;
            }
        }
        return idx;
    }
      public void adicionarVenda (String pCod, Venda pVenda) throws Exception {
        int idx = this.consultaNota(pCod);
        if (idx == -1) {
            throw new Exception("Não existe nota fiscal cadastrada com o código "+pCod);
        } else {
            notafiscal = this.historico.get(idx);
            ArrayList<Venda> listaVendas = notafiscal.getListaVendas();
            if (listaVendas.size() < 10) {
                listaVendas.add(pVenda);
                notafiscal.setListaVendas(listaVendas);
            } else {
                throw new Exception("Nota já possui 10 mercadorias. Não é possivel adicionar mais");
            }
        }
    }
     public void gerarNotaFiscal (String pCpf, String pNome) {
        //notafiscal = new NotaFiscal(pCpf, pNome);
        //this.historico.add(notafiscal);
    }
    public double valorNota (NotaFiscal nf) {
        double valorTotal = 0;
        for (Venda venda : nf.getListaVendas()) {
            valorTotal += venda.getQuantidade() * (venda.getProd().getPreco_venda());
        }
        return valorTotal;
    }
     public double fatCliente (String pCPF) {
        double valorTotal = 0;
        for (NotaFiscal notaFisca1 : historico) {
            if (pCPF.equals(notaFisca1.getCpf())) {
                valorTotal += valorNota(notaFisca1);
            }
        }
        return valorTotal;
    }

    private void serializaNotafiscal() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream(arquivo);
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(historico);
        objOS.flush();
        objOS.close();
    }

    private void desserializaNotafiscal() throws Exception {
        File objFile = new File(arquivo);
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream(arquivo);
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            historico = (ArrayList<NotaFiscal>) objIS.readObject();
            objIS.close();
        }
    }
 
     */
      
    
}
