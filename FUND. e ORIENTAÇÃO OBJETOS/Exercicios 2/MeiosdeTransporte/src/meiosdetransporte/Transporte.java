package meiosdetransporte;

public class Transporte {

    private String nome = "";
    private int numeroPassageiros = 0;
    private int velocidadeAtual = 0;

    public boolean estaParado() {
        if (velocidadeAtual == 0) {
            return true;
        }
        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String pNome) {
        nome = pNome;
    }
       
    public void setNumeroPassageiros(int pNP){
        numeroPassageiros = pNP;
    }
    
    public int getNumeroPassageiros(){
        return numeroPassageiros;
    }
    
    public void setVelocidadeAtual(int pVA){
        velocidadeAtual = pVA;
    }
    
    public int getvelocidadeAtual(){
        return velocidadeAtual;
    }
}
