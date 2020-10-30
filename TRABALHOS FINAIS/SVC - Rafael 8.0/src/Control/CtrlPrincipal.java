package Control;

import Model.NotaFiscal;
import Model.Produto;
import View.LimPrincipal;


public class CtrlPrincipal {
    
    private LimPrincipal limPrincipal;
    private CtrlCliente ctrlCliente;
    private CtrlVenda ctrlVenda;
    private CtrlNotaFiscal ctrlNotaFiscal;
    private CtrlProduto ctrlProduto;
    private Produto p;
    private NotaFiscal nf;
    
    public CtrlPrincipal() {
        try {
            ctrlCliente = new CtrlCliente();
            ctrlVenda = new CtrlVenda();
            ctrlNotaFiscal = new CtrlNotaFiscal();
            ctrlProduto = new CtrlProduto();
            p = new Produto();
            nf = new NotaFiscal();
        }catch (Exception exp) {
            limPrincipal.showMessage("Error: " + exp.getMessage());
        }
        limPrincipal = new LimPrincipal(this);
    }
    
        //Função Para Abrir Janelas
    public void abrirJanela(int n) {
        switch (n) {
            case 1:
                ctrlCliente.viewCliente(1);
                break;
            case 2:
                ctrlCliente.viewCliente(2);
                break;
            case 3:
                ctrlProduto.viewProduto(1);
                break;
            case 4:
                ctrlProduto.viewProduto(2);
                break;
            case 5:
                ctrlProduto.viewProduto(3);
                break;
            case 6:
                ctrlProduto.viewProduto(4);
                break;
            case 7:
                ctrlVenda.viewVenda(1, ctrlCliente, ctrlProduto, p, nf);
                break;
            case 8:
                ctrlVenda.viewVenda(8, ctrlCliente, ctrlProduto, p, nf);
                break;
            case 9:
                ctrlNotaFiscal.viewVenda(9, ctrlNotaFiscal);
                break;
            case 10:
                ctrlNotaFiscal.viewVenda(10, ctrlNotaFiscal);
                break;
            case 11:
                ctrlNotaFiscal.viewVenda(11, ctrlNotaFiscal);
                break;
            case 12:
                ctrlNotaFiscal.viewVenda(12, ctrlNotaFiscal);
                break;
            case 13:
                ctrlVenda.viewVenda(13, ctrlCliente, ctrlProduto, p, nf);
                break;
        }
    }
}
