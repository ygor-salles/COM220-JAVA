
package AulaPOO;

public class Disciplina {

    private int codigo;
    private String nome;
    private int cargaHoraria;

    /* Construtor da entidade Disciplina.
	 * @param pCodigo código da disciplina.
	 * @param pNome descrição do nome da disciplina
	 * @param pCargaHoraria carga horária da disciplina
     */
    public Disciplina(int pCodigo, String pNome,
            int pCargaHoraria) {
        codigo = pCodigo;
        nome = pNome;
        cargaHoraria = pCargaHoraria;
    }

    /**
     * Atribui o código da disciplina.
     *
     * @param pCodigo código da disciplina.
     */
    public void setCodigo(int pCodigo) {
        codigo = pCodigo;
    }

    /**
     * Atribui a descrição do nome da disciplina.
     *
     * @param pNome nome da disciplina.
     */
    public void setNome(String pNome) {
        nome = pNome;
    }

    /**
     * Atribui a carga horária da disciplina.
     *
     * @param pCargaHoraria carga horária da disciplina.
     */
    public void setCargaHoraria(int pCargaHoraria) {
        cargaHoraria = pCargaHoraria;
    }

    /**
     * Informa o código da disciplina.
     *
     * @return int código da disciplina.
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * Informa o nome da disciplina.
     *
     * @return String nome da disciplina.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Informa a carga horária da disciplina.
     *
     * @return int carga horária da disciplina.
     */
    public int getCargaHoraria() {
        return cargaHoraria;
    }
}
