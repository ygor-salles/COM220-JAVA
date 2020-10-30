/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.academico.pessoa;

import info.geral.util.Util;

/**
 *
 * @author Jean
 */
public class Professor extends Pessoa {

    private String aTitMaxima = "";

    //Atribui a titulação máxima
    public void setTitMaxima(String pTitMaxima) {
        //Realiza o controle para verificar se a titulação é válida
        if ((!pTitMaxima.equalsIgnoreCase(Util.GRADUACAO))
                && (!pTitMaxima.equalsIgnoreCase(Util.ESPECIALIZACAO))
                && (!pTitMaxima.equalsIgnoreCase(Util.MESTRADO))
                && (!pTitMaxima.equalsIgnoreCase(Util.DOUTORADO))) {
            System.out.println("A titulação informada não é válida!!!");
        } else {
            aTitMaxima = pTitMaxima;
        }
    }

    //Recupera a titulação máxima
    public String getTitMaxima() {
        return aTitMaxima;
    }

}
