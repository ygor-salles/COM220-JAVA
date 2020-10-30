
package Clinica;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;
import javax.swing.JOptionPane;


public class ControleConsulta implements Serializable{
    
    Vector consulta = new Vector();
    private Paciente pacientes = new Paciente();
    private Medico medicos = new Medico();
    private String arquivo = "consulta.dat";

    public void setConsulta(Vector consulta) {
        this.consulta = consulta;
    }

    public void setPacientes(Paciente pacientes) {
        this.pacientes = pacientes;
    }

    public void setMedicos(Medico medicos) {
        this.medicos = medicos;
    }

    public Vector getConsulta() {
        return consulta;
    }

    public Paciente getPacientes() {
        return pacientes;
    }

    public Medico getMedicos() {
        return medicos;
    }

    public ControleConsulta() {
        try {
            recuperaConsultas();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        } 
    }
    
    public void MarcaConsulta(){
        new LimiteMarcaConsulta(this);
    }
    
    public void ListaConsulta(){
        new LimiteListaConsulta(this);
    }
    
    public void marcaConsulta(int pPaciente, int pMedico, int pdia, int pmes, int pano, int phora){
        consulta.add(new Consulta(pPaciente, pMedico, pdia, pmes, pano, phora));
        
    }
    
    public void gravaConsultas() throws Exception{
        FileOutputStream objFileOS = new FileOutputStream(arquivo);
        ObjectOutputStream objOS = new ObjectOutputStream(objFileOS);
        objOS.writeObject(consulta);
        objOS.flush();
        objOS.close();
    }
    public void recuperaConsultas() throws Exception{
        File objFile = new File(arquivo);
        if(objFile.exists()){
            FileInputStream objFileIS = new FileInputStream(arquivo);
            ObjectInputStream objIS = new ObjectInputStream(objFileIS);
            consulta = (Vector)objIS.readObject();
            objIS.close();
        }
    }
    
}
