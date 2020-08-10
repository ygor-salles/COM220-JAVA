package model;

import java.io.Serializable;

public class Notas implements Serializable{
    float n1, n2;
    String codAlu;

    public Notas(float n1, float n2, String codAlu) {
        setN1(n1);     
        setN2(n2);
        setCodAlu(codAlu);
    }
    
    public Notas(){
    
    }

    public float getN1() {
        return n1;
    }

    public void setN1(float n1) {
        this.n1 = n1;
    }

    public float getN2() {
        return n2;
    }

    public void setN2(float n2) {
        this.n2 = n2;
    }

    public String getCodAlu() {
        return codAlu;
    }

    public void setCodAlu(String codAlu) {
        this.codAlu = codAlu;
    }
}
