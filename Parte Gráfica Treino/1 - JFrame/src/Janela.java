
import javax.swing.JFrame;

public class Janela {
    
    public Janela() {
        JFrame janela = new JFrame();           //inicializa o JFrame
        janela.setSize(500,300);                //seta a dimensão da janela
        janela.setTitle("Título da Janela");    //seta o título da janela
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //faz com que a operação finalize
        janela.setLocationRelativeTo(null);     //inicializa a janela no centro
        janela.setResizable(false);             //não deixa redimensionar
        janela.setVisible(true);                //deixa a janela visível
        
        /*
            posso também herdar o método ficando 
                public class Janela extends JFrame {
            } 
            não sendo necessário iniciarlizar e nem chamar o objeto, ficando apenas assim
                    setSize(500,300);                //seta a dimensão da janela
                    setTitle("Título da Janela");    //seta o título da janela
                    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  //faz com que a operação finalize
                    setLocationRelativeTo(null);     //inicializa a janela no centro
                    setResizable(false);             //não deixa redimensionar
                    setVisible(true);                //deixa a janela visível
        */
    }

    public static void main(String[] args) {
        new Janela();
    }
    
}
