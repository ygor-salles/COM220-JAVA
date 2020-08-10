package Control;

import View.LimProduto;
import Model.Produto;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrlProduto  implements Serializable {
    //atributos
    private LimProduto limite;
    public ArrayList<Produto> arrayProduto = new ArrayList<Produto>();
    private final String arquivo = "produtos.dat";
    
    //construtor
    public CtrlProduto(){
        try {
            desserializaProduto();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    //métodos
    public void cadastrarProduto(String codigo, String descricao, double preco_compra,
            double preco_venda, int quantidade){
        Produto p = new Produto(codigo,descricao,preco_compra,preco_venda,quantidade);
        arrayProduto.add(p);
        
        try {
            serializaProduto();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public Produto retornaProd(String codigo) {
        Produto p = new Produto();
        for(int i=0; i<arrayProduto.size(); i++){
            Object o = arrayProduto.get(i);
            
            if(((Produto) o).getCodigo().equals(codigo)){
                p = (Produto) o;
            }
        }
        return p;
    }
    
    public void tiraQuantidade(int q) {
        
    }
    public int verificaProduto(String codigo){
        int x = -1;
        
        for(int i=0; i<arrayProduto.size(); i++){
            Object o = arrayProduto.get(i);
            
            if(((Produto) o).getCodigo().equals(codigo)){
                x = arrayProduto.indexOf(o);
            }
        }
        return x;
    }
    
    public boolean verificaQuantidade(String codigo, String quantidade){
        int x = Integer.parseInt(quantidade);
        boolean maior = true;
        for(int i=0; i<arrayProduto.size(); i++){
            Object o = arrayProduto.get(i);
            
            if(((Produto) o).getCodigo().equals(codigo)){
                if(x <= arrayProduto.get(i).getQuantidade())
                    maior = false;
            }
        }
        return maior;
    }
    
    public String consultaProduto(String codigo){
        String ficha="";
        
        for(int i=0; i<arrayProduto.size(); i++){
            Object o = arrayProduto.get(i);
            
            if(((Produto) o).getCodigo().equals(codigo)){
                ficha = "Estoque: "+((Produto) o).getQuantidade()+"\nDescrição: "+((Produto) o).getDescricao()+
                        "\nPreço de venda: "+((Produto) o).getPreco_venda()+"\n";
            }
        }
        
        return ficha;
    }
    
    public void atualizaQuantidade(String z, int j) {
        int x = Integer.parseInt(z);
        arrayProduto.get(j).setQuantidade(x);
    }
    
    public String listaEstoque(){
        String estoque="";
        
        for(int i=0; i<arrayProduto.size(); i++){
            Object o = arrayProduto.get(i);
            
            estoque += "Código: "+((Produto) o).getCodigo()+"\nDescrição: "+((Produto) o).getDescricao()+
                    "\nPreço de Venda: "+((Produto) o).getPreco_venda()+"\nPreço de Compra: "+((Produto) o).getPreco_compra()+
                    "\nQuantidade: "+((Produto) o).getQuantidade()+"\n\n";
        }
        
        return estoque;
    }
    
    public void serializaProduto() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream(arquivo);
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(arrayProduto);
        objOS.flush();
        objOS.close();
    }

    public void desserializaProduto() throws Exception {
        File objFile = new File(arquivo);
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream(arquivo);
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            arrayProduto = (ArrayList<Produto>) objIS.readObject();
            objIS.close();
        }
    }
    
    public void viewProduto(int n) {
        limite = new LimProduto(this, n);
    } 
    
    /*
    public void vendeProduto(String codigo, int quantidade){
    
        if(verificaProduto(codigo)){
            for(int i<0; i<arrayProduto.sizeof(); i++){
                Object o = arrayProduto.get(i);
                
                if(((Produto) o).getCodigo().equals(codigo)){
                    if(((Produto) o).getQuantidade() >= quantidade){
                        estoque = ((Produto) o).getQuantidade();
                        ((Produto) o).setQuantidade(estoque - quantidade);
                    }else{
                        System.out.println("Não há quantidade suficiente no estoque!\n");
                    }
                }
            }      
        }else{
            System.out.println("Produto não cadastrado!\n");
        }
    }
    
    public void atualizaEstoque(String codigo, int quantidade){
        int quant;
        
        for(int i=0; i<produtos.size(); i++){
            Object o = produtos.get(i);
            
            if(((Produto) o).getCodigo().equals(codigo)){
                quant = ((Produto) o).getQuantidade();
                
                ((Produto) o).setQuantidade(quantidade + quant);
            }
        }
    }
    
    public void adicionaVetor(Produto p) throws Exception{
        produtos.add(p);
        serializaProduto();
    }
    
    public void serializaProduto() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream(arquivo);
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(produtos);
        objOS.flush();
        objOS.close();
    }

    public void desserializaProduto() throws Exception {
        File objFile = new File(arquivo);
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream(arquivo);
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            produtos = (Vector) objIS.readObject();
            objIS.close();
        }
    }
    */

}
