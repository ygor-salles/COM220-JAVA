package Control;

import View.LimCliente;
import Model.Cliente;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class CtrlCliente implements Serializable {
    
    //atributos
    private final String arquivo = "clientes.dat";
    public ArrayList<Cliente> arrayCliente = new ArrayList<Cliente>();
    private LimCliente limite;
    
    //construtor
    public CtrlCliente() {
         try {
            desserializaCliente();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    //métodos
    public void cadastrarCliente(String Nome, String email, String estado, String cidade,
            String rua, String numero, String cep, String CPF) {
        Cliente c = new Cliente(Nome, email, estado, cidade, rua, numero, CPF);
        arrayCliente.add(c);
        try {
            serializaCliente();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }
    
    public int verificaCliente(String cpf){
        int x = -1;
        
        for(int i=0; i<arrayCliente.size(); i++){
            Object o = arrayCliente.get(i);
            
            if(((Cliente) o).getCPF().equals(cpf))
                x = arrayCliente.indexOf(o);
        }
        return x;
    }
    
    public String consultaCliente(String CPF){
        String ficha="";
        
        for(int i=0; i<arrayCliente.size(); i++){
            Object o = arrayCliente.get(i);
            
            if(((Cliente) o).getCPF().equals(CPF)){
                //ficha = ">Nome: "+((Cliente) o).getNome()+"\n Endereco: "+((Cliente) o).getEndereco()+
                        //"\n Email: "+((Cliente) o).getEmail()+" \n";
            }
        }
        return ficha;
    }
    
    public void serializaCliente() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream(arquivo);
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(arrayCliente);
        objOS.flush();
        objOS.close();
    }

    public void desserializaCliente() throws Exception {
        File objFile = new File(arquivo);
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream(arquivo);
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            arrayCliente = (ArrayList<Cliente>) objIS.readObject();
            objIS.close();
        }
    }
    
    public void viewCliente(int n) {
        limite = new LimCliente(this, n);
    }
    
    
    /*private LimCliente limcliente = new LimCliente();
    private String[] form = limcliente.montaForm();
    private Cliente cliente;
    private Vector clientes = new Vector();
    private final String arquivo = "clientes.dat";
    *
    public CtrlCliente() throws Exception {
        desserializaCliente();
    }
    
    public void cadastraCliente() throws Exception{
        cliente = new Cliente();
        cliente.setNome(form[0]);
        cliente.setEmail(form[1]);
        //cliente.setEndereco(form[2]);
        cliente.setCPF(form[3]);
        adicionaVetor(cliente);
    }
    
    public void adicionaVetor(Cliente cliente) throws Exception{
        clientes.add(cliente);
        serializaCliente();
    }
    
    public boolean verificaCliente(String cpf){
        boolean achou = false;
        
        for(int i=0; i<clientes.size(); i++){
            Object o = clientes.get(i);
            
            if(((Cliente) o).getCPF().equals(cpf)){
                achou = true;
            }
        }
        
        return achou;
    }
    
    public String consultaCliente(String CPF){
        String ficha="";
        
        for(int i=0; i<clientes.size(); i++){
            Object o = clientes.get(i);
            
            if(((Cliente) o).getCPF().equals(CPF)){
                ficha = ">Nome: "+((Cliente) o).getNome()+"\n Endereco: "+((Cliente) o).getEndereco()+
                        "\n Email: "+((Cliente) o).getEmail()+" \n";
            }
        }
        
        return ficha;
    }
    
    private void serializaCliente() throws Exception {
        FileOutputStream objFileOS = new FileOutputStream(arquivo);
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(clientes);
        objOS.flush();
        objOS.close();
    }

    private void desserializaCliente() throws Exception {
        File objFile = new File(arquivo);
        if (objFile.exists()) {
            FileInputStream objFileIS = new FileInputStream(arquivo);
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            clientes = (Vector) objIS.readObject();
            objIS.close();
        }
    }
    */
}