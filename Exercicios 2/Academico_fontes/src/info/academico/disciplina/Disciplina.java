/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package info.academico.disciplina;

/**
 *
 * @author Jean
 */
public class Disciplina {

    private String nomeDis;
    private int cargaHoraria;

    public Disciplina(String pnomeDis, int pcargaHoraria) {
        nomeDis = pnomeDis;
        cargaHoraria = pcargaHoraria;
    }

    public String getDescricao() {
        return "  Disciplina: " + nomeDis + "  Carga Horária: " + cargaHoraria;
    }
}
