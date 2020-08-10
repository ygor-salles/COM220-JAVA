
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.event.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Jean
 */
public class slider extends JFrame implements ChangeListener {

    JSlider slider;
    JProgressBar pB;

    public slider() {
        super("Slider com Progress Bar");

        slider   = new JSlider();
        pB       = new JProgressBar();
        
        slider.addChangeListener(this);
        
        if (slider.getValue() != pB.getValue()) {
            pB.setValue(slider.getValue());
        }
        
        JPanel painel = new JPanel(new GridLayout(2, 1));
        painel.add(slider);
        painel.add(pB);
        
        this.add(painel);
        this.setSize(300, 100);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        slider s = new slider();

    }

    public void stateChanged(ChangeEvent e) {
        if (e.getSource() == slider) { // SE O SLIDER SELECIONADO
            if (slider.getValue() != pB.getValue()) { // VALOR MUDADO
                pB.setValue(slider.getValue());  // NOVO VALOR APLICADO
            }
        }

    }
}
