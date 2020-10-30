package Control;

import Model.NotaFiscal;
import Model.Produto;
import Model.Venda;
import View.LimProduto;
import View.LimVenda;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class CtrlVenda  implements Serializable {
    //atributos
    private final String arquivo = "vendas.dat";
    private ArrayList<Venda> arrayVenda = new ArrayList<Venda>();
    private ArrayList<Venda> arrayPrevenda = new ArrayList<Venda>();
    private LimVenda limite;
    private CtrlCliente ctrlCliente;
    private NotaFiscal nf;
    
    //construtor
    public CtrlVenda(){
        try {
            desserializaVenda();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void serializaVenda() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream(arquivo);
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(arrayVenda);
        objOS.flush();
        objOS.close();
    }

    public void desserializaVenda() throws Exception {
        File objFile = new File(arquivo);
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream(arquivo);
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            arrayVenda = (ArrayList<Venda>) objIS.readObject();
            objIS.close();
        }
    }
    
    //métodos
    public void cadastraVenda(Produto prod, int quantidade){
        Venda v = new Venda(prod, quantidade);
        arrayVenda.add(v);
        
        try {
            serializaVenda();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public void preVenda(Produto prod, int quantidade){
        Venda v = new Venda(prod, quantidade);
        arrayPrevenda.add(v);
    }
   
    
    public double faturamentoProduto(String codigo){
        double valorVendido = 0.0;
        
        for(int i=0; i<arrayVenda.size(); i++){
            Object o = arrayVenda.get(i);
            
            if(((Venda) o).getProd().getCodigo().equals(codigo)){
                valorVendido += ((Venda) o).getQuantidade() * ((Venda) o).getProd().getPreco_venda();
            }
        }
        
        return valorVendido;
    }
    
//    public double faturamentoPeriodo(String inicio, String fim){
//        double valorVendido = 0.0;
//        Date DataInicio, DataFim;
//        
//        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
//        
//        try {
//            DataInicio = formatoData.parse(inicio);
//            DataFim = formatoData.parse(fim);
//            
//            for(int i=0; i<arrayVenda.size(); i++){
//                Object o = arrayVenda.get(i);
//                
//                if(DataInicio.before(((Venda) o).getData()) && DataFim.after(((Venda) o).getData())){
//                    valorVendido += ((Venda) o).getQuantidade() * ((Venda) o).getProd().getPreco_venda();
//                }
//            }
//        } catch (ParseException ex) {
//            Logger.getLogger(CtrlVenda.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return valorVendido;
//    }
//    
//    public double lucroLiquidoPeriodo(String inicio, String fim){
//        double lucro = 0.0, valorVendido = 0.0, valorComprado = 0.0;
//        Date DataInicio, DataFim;
//        
//        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
//        
//        try {
//            DataInicio = formatoData.parse(inicio);
//            DataFim = formatoData.parse(fim);
//            
//            for(int i=0; i<arrayVenda.size(); i++){
//                Object o = arrayVenda.get(i);
//                
//                if(DataInicio.before(((Venda) o).getData()) && DataFim.after(((Venda) o).getData())){
//                    valorVendido += ((Venda) o).getQuantidade() * ((Venda) o).getProd().getPreco_venda();
//                    valorComprado += ((Venda) o).getQuantidade() * ((Venda) o).getProd().getPreco_compra();
//                }
//            }
//        } catch (ParseException ex) {
//            Logger.getLogger(CtrlVenda.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        lucro = valorVendido - valorComprado;
//        
//        return lucro;
//    }
//    
//    public String produtosMaisVendidos(){
//        String maisVendidos = "";
//        
//        Collections.sort(arrayVenda);
//        
//        for(int i=0; i<arrayVenda.size(); i++){
//            Object o = arrayVenda.get(i);
//            
//            maisVendidos += "Código: "+((Produto) o).getCodigo()+"\nDescrição: "+((Produto) o).getDescricao()+
//                    "\nPreço de Venda: R$"+((Produto) o).getPreco_venda()+"\nTotal vendido: "+((Venda) o).getQuantidade()+"\n\n";
//        }
//        
//        return maisVendidos;
//    }
    
    public String produtosMaisVendidos() {
        String maisVendidos = "";
        ArrayList<Produto> listaProd = new ArrayList<>();
        ArrayList<Integer> qtd = new ArrayList<>();
        
        for (Venda venda : arrayVenda) {
            if (listaProd.size() == 0) {
                listaProd.add(venda.getProd());
                qtd.add(venda.getQuantidade());
            } else {
                int idx = 0, flag = 0;
                for (Produto prod : listaProd) {
                    if (prod.getCodigo() == venda.getProd().getCodigo()) {
                        qtd.set(idx, qtd.get(idx) + 1);
                        flag = 1;
                    }
                    idx += 1;
                }
                if (flag == 0) {
                    listaProd.add(venda.getProd());
                    qtd.add(venda.getQuantidade());
                }
            }
        }
        maisVendidos += "Top 10 Produtos";
        int idx = 0;
        while (idx < 10 && idx < qtd.size()) {
            maisVendidos += "Produto-" + idx + 1;
            maisVendidos += "\n Código:" + listaProd.get(idx).getCodigo();
            maisVendidos += "\n Descrição:" + listaProd.get(idx).getDescricao();
            maisVendidos += "\n Preço de Venda:" + listaProd.get(idx).getPreco_venda();
            maisVendidos += "\n Total vendido: " + qtd.get(idx);
            maisVendidos += "\n\n";
            idx++;
        }
        return maisVendidos;
    }
    
    public void viewVenda(int n, CtrlCliente ctrlCliente, CtrlProduto ctrlProduto, Produto p, NotaFiscal nf) {
        limite = new LimVenda(this, ctrlCliente, ctrlProduto, p, nf, n);
    } 
     
}