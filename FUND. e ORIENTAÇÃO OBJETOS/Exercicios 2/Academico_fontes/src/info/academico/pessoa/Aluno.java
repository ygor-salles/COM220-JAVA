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
    
public class Aluno extends Pessoa {

    private String aCurso;

    public void setCurso(String pCurso) {
        //Realiza o controle para verificar se o curso é válido
        if ((!pCurso.equalsIgnoreCase(Util.CC))
                && (!pCurso.equalsIgnoreCase(Util.SI))) {
            System.out.println("O curso informado não é válido!!!");
        } else {
            aCurso = pCurso;
        }
    }

    public String getCurso() {
        return aCurso;
    }

}