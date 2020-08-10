
package Clinica;


public class ControlePrincipal {
    
    private ControleConsulta ctrConsulta;
    private LimitePrincipal limPrincipal;
    
    public ControlePrincipal(){
        ctrConsulta = new ControleConsulta();
        limPrincipal = new LimitePrincipal(this);
    }

    public ControleConsulta getCtrConsulta() {
        return ctrConsulta;
    }

    public LimitePrincipal getLimPrincipal() {
        return limPrincipal;
    }
    
    public static void main(String args[]) {
        ControlePrincipal cp = new ControlePrincipal();
    }
}
