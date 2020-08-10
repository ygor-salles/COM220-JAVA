
package Clinica;


public class Consulta {
    
    private int Cpaciente, Cmedico, dia, mes, ano, hora;
    private Paciente pacientes = new Paciente();
    private Medico medicos = new Medico();

    public Consulta(int Cpaciente, int Cmedico, int dia, int mes, int ano, int hora) {
        this.Cpaciente = Cpaciente;
        this.Cmedico = Cmedico;
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
        this.hora = hora;
    }

    public int getCpaciente() {
        return Cpaciente;
    }

    public int getCmedico() {
        return Cmedico;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAno() {
        return ano;
    }

    public int getHora() {
        return hora;
    }

    public Paciente getPacientes() {
        return pacientes;
    }

    public Medico getMedicos() {
        return medicos;
    }

    public void setCpaciente(int Cpaciente) {
        this.Cpaciente = Cpaciente;
    }

    public void setCmedico(int Cmedico) {
        this.Cmedico = Cmedico;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public void setPacientes(Paciente pacientes) {
        this.pacientes = pacientes;
    }

    public void setMedicos(Medico medicos) {
        this.medicos = medicos;
    }
    
    
    
    
}
