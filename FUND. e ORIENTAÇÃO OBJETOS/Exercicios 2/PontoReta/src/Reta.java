
public class Reta {

    private Ponto inicio = new Ponto();
    private Ponto fim = new Ponto();

    public Reta(int iniX, int iniY, int fimX, int fimY) {
        inicio.setX(iniX);
        inicio.setY(iniY);
        fim.setX(fimX);
        fim.setY(fimY);
    }

    public Reta(Ponto pIni, Ponto pFim) {
        inicio = pIni;
        fim = pFim;
    }
    // SET PONTO INICIAL

    public void setInicio(Ponto pIni) {
        inicio = pIni;
    }

    // GET PONTO INICIAL 
    public Ponto getInicio() {
        return inicio;
    }

    // SET PONTO FINAL
    public void setFim(Ponto pFim) {
        fim = pFim;
    }
    
    public void setXYInicial(int pX, int pY) {
        inicio.setX(pX);
        inicio.setY(pY);
    }
    
    public void setXYFinal(int pX, int pY) {
        fim.setX(pX);
        fim.setY(pY);
    }

    // GET PONTO FINAL
    public Ponto getFim() {
        return fim;
    }

    // SETTTER E GETTERS PARA O PONTO x
    public void setXIni(int pX) {
        inicio.setX(pX);
    }

    public int getXIni() {
        return inicio.getX();
    }

    public void setYIni(int pY) {
        inicio.setY(pY);
    }

    public int getYIni() {
        return inicio.getY();
    }

    // SETTTER E GETTERS PARA O PONTO Y
    public void setXFim(int pX) {
        fim.setX(pX);
    }

    public int getXFim() {
        return fim.getX();
    }

    public void setYFim(int pY) {
        fim.setY(pY);
    }

    public int getYFim() {
        return fim.getY();
    }

    //Operacao toString da classe Reta
    public String toString() {
        return "Reta comeca em:"+inicio+" e termina em:"+ fim;
    }
    
    // RETORNAR O TAMANHO DA RETA
    public int retaTamanho(){
        int pX = fim.getX() - inicio.getX();
        int pY = fim.getY() - inicio.getY();
        
        return ((int)Math.sqrt(Math.pow(pY,1) + Math.pow(pY, 2)));
    }

}
