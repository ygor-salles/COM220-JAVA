/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidade;

/**
 *
 * @author cascao
 */
public class Dvd {
    private int codigoDvd;
    private String titulo;
    private String genero;
    private int ano;

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCodigoDvd() {
        return codigoDvd;
    }

    public void setCodigoDvd(int codigoDvd) {
        this.codigoDvd = codigoDvd;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
}
