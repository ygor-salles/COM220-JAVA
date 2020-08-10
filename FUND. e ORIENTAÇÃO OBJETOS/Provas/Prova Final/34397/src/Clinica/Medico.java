
package Clinica;

import java.io.*;
import java.util.ArrayList;


public class Medico implements Serializable{
    
    private int codigo;
    private String nome,especialidade;
    private ArrayList<Medico> listaMedico = new ArrayList();

    public Medico(int pcodigo, String pnome, String pespecialidade) {
        this.codigo = pcodigo;
        this.nome = pnome;
        this.especialidade = pespecialidade;
    }
    
    public Medico(){
        cadMedicos();
    }

    public void setListaMedico(ArrayList<Medico> listaMedico) {
        this.listaMedico = listaMedico;
    }

    public ArrayList<Medico> getListaMedico() {
        return listaMedico;
    }
    public void cadMedicos(){
        this.listaMedico.add(new Medico(1001, "Antonio Duarte", "Cardiologista"));
        this.listaMedico.add(new Medico(1002, "Jose Coimbra", "Ginecologista"));
        this.listaMedico.add(new Medico(1003, "Marcio Guedes", "Ortopedia"));
        this.listaMedico.add(new Medico(1004, "Ana Souza", "Ginecologista"));
        this.listaMedico.add(new Medico(1005, "Marina Manezes", "Cardiologista"));
        this.listaMedico.add(new Medico(1006, "Laura Prado", "Neurologista"));
        this.listaMedico.add(new Medico(1007, "Marcos Pereira", "Cardiologista"));
        this.listaMedico.add(new Medico(1008, "Stela Carvalho", "Pediatra"));
        
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setCodigo(int pcodigo) {
        this.codigo = pcodigo;
    }

    public void setNome(String pnome) {
        this.nome = pnome;
    }

    public void setEspecialidade(String pespecialidade) {
        this.especialidade = pespecialidade;
    }
    
}
