
public abstract class Pessoa {

    private String aNome = "", aEndereco = "", aSexo = "";
    private int aIdade = 0;  //Atributos do tipo int
    private Disciplina aDisc[];

    //Construtor da classe Pessoa
    public Pessoa(String pNome, String pEndereco, String pSexo, int pIdade) {
        aNome = pNome;
        aEndereco = pEndereco;
        aSexo = pSexo;
        aIdade = pIdade;
    }

    //Construtor da classe Pessoa
    public Pessoa(String pNome, String pEndereco, String pSexo, int pIdade, Disciplina pDisc[]) {
        this(pNome, pEndereco, pSexo, pIdade);
        aDisc = pDisc;
    }

    //Construtor default
    public Pessoa() {
    }


    //Métodos
    public void setNome(String pNome) {
        aNome = pNome;
    }

    public void setEndereco(String pEndereco) {
        aEndereco = pEndereco;
    }

    public void setSexo(String pSexo) {
        if ((!pSexo.equalsIgnoreCase(Util.MASCULINO))
                && (!pSexo.equalsIgnoreCase(Util.FEMININO))) {
            System.out.println("O conteúdo informado para“+“o atributo sexo não é válido");
        } else {
            aSexo = pSexo;
        }
    }

    public void setIdade(int pIdade) {
        //Determina uma regra de validação do atributo idade,  
        //evitando que qualquer valor seja atributo
        if ((pIdade < Util.MIN_IDADE) || (pIdade > Util.MAX_IDADE)) {
            System.out.println("Idade deve ser maior ou igual a "
                    + Util.MIN_IDADE + " e menor ou igual "
                    + Util.MAX_IDADE);
        } else {
            aIdade = pIdade;
        }
    }

    public void setDisciplina(Disciplina pDisc[]) {
        aDisc = pDisc;
    }

    public String getDisciplina(int index) {
        return aDisc[index].getDescricao();
    }

    public String getDisciplinas() {
        String retorno = "";
        for (int i = 0; i < aDisc.length; i++) {
            retorno += aDisc[i].getDescricao() + "\n";
        }
        return retorno;
    }

    public String getNome() {
        return aNome;
    }

    public String getEndereco() {
        return aEndereco;
    }

    public String getSexo() {
        return aSexo;
    }

    public int getIdade() {
        return aIdade;
    }

    public String getDescricao() {
        String mensagem = aNome + " reside na " + aEndereco
                + " e possui " + aIdade + " anos de idade";
        if (aSexo.equalsIgnoreCase(Util.MASCULINO)) {
            return mensagem = "O Sr. " + mensagem;
        } else {
            return mensagem = "A Sra. " + mensagem;
        }
    }
}
