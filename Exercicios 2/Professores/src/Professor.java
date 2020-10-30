// CLASSE SUPER - PROFESSOR

public abstract class Professor {

    private String aNome;
    private int aMatricula;
    private int aCargaHoraria;

    // CONSTRUTOR COM PARAMETROS
    public Professor(String pNome, int pMatricula, int pCargaHoraria) {
        aNome = pNome;
        aMatricula = pMatricula;
        aCargaHoraria = pCargaHoraria;
    }

    // CONSTRUTOR SEM PARAMETROS
    public void Professor() {
    }

    // RETORNA O NOME
    public String getNome() {
        return aNome;
    }

    // RETORNA MATRICULA
    public int getMatricula() {
        return aMatricula;
    }

    // RETORNA CARGA HORARIA
    public int getCargaHoraria() {
        return aCargaHoraria;
    }

    // METODO ABSTRATO PARA RETORNAR SALARIO
    public abstract double getSalario();
}
