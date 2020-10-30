package meiosdetransporte;

public abstract class TransporteTerrestre extends Transporte {

    protected String tipo = "";

    public void estacionar() {
        System.out.println(getNome() + "- foi ligado estacionado");
    }
    
    public void setTipo(String pTipo){
        tipo = pTipo;
    }
    
    public String getTipo(){
        return tipo;
    }
}
