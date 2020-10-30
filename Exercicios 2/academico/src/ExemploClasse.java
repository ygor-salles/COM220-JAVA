
public class ExemploClasse {

    public static void main(String par[]) {

        //Declarando usando o metodo construtor vazio
        Professor objProfessor = new Professor();

        //Atribui o conteúdo para as variáveis de instância (Atributos)
        objProfessor.setNome("Jose da Silva ");
        objProfessor.setEndereco("R das Palmeiras 111");
        objProfessor.setIdade(42);
        objProfessor.setSexo(Util.MASCULINO);
        objProfessor.setTitMaxima(Util.DOUTORADO);

        //Obtém o conteúdo dos atributos Nome, Endereço e Idade e imprime esse
        //conteúdo para a saída padrão utilizando System.out.println();
        System.out.println("Nome: " + objProfessor.getNome());
        System.out.println("Endereço: " + objProfessor.getEndereco());
        System.out.println("Idade: " + objProfessor.getIdade());
        System.out.println("Sexo: " + objProfessor.getSexo());
        System.out.println("Titulação Máxima: " + objProfessor.getTitMaxima());

        //Imprime o conteúdo detalhado através do método getDescricao()
        System.out.println(objProfessor.getDescricao());

        ///
        //Declarando usando o metodo construtor completo
        Disciplina[] discMinistradas = {new Disciplina("Programação Orientada a Objetos", 60), new Disciplina("Estruturas de Dados", 30)};

        // Cria objeto da classe Professor para guardar todos os dados
        Professor objProfessor2;
        objProfessor2 = new Professor("Professor 2", "R das Oliveiras 45", Util.MASCULINO, 38, Util.DOUTORADO, discMinistradas);

        //Imprime o conteúdo detalhado através do método getDescricao()
        System.out.println(objProfessor.getDescricao());

        // SEGUNDO OBJETO
        //Cria a instância
        Aluno objAluno = new Aluno();

        Disciplina D1 = new Disciplina("COM 220 - Programação Orientada a Objeitos", 64);
        Disciplina D2 = new Disciplina("COM 222 - Estrutura de Dados", 64);
        Disciplina vet[] = {D1, D2};

        //Atribui o conteúdo para as variáveis de instância (Atributos)
        objAluno.setNome("Jean Carlos ");
        objAluno.setEndereco("R Rouxinol 31");
        objAluno.setIdade(23);
        objAluno.setSexo(Util.MASCULINO);
        objAluno.setCurso(Util.SI);
        objAluno.setDisciplina(vet);

        //Obtém o conteúdo dos atributos Nome, Endereço e Idade e imprime esse
        //conteúdo para a saída padrão utilizando System.out.println();
        System.out.println("Nome: " + objAluno.getNome());
        System.out.println("Endereço: " + objAluno.getEndereco());
        System.out.println("Idade: " + objAluno.getIdade());
        System.out.println("Sexo: " + objAluno.getSexo());
        System.out.println("Curso: " + objAluno.getCurso());

        System.out.println("Disciplinas " + objAluno.getDisciplinas());

        //Imprime o conteúdo detalhado através do método getDescricao()
        System.out.println(objAluno.getDescricao());
        
        
        
        
        /// Aluno com construtor completo
        // Disciplinas cursadas
        
        Disciplina D4 = new Disciplina("COM210 - Engenharia de Software I", 64);
        Disciplina D5 = new Disciplina("MAT013 - PROBABILIDADE E ESTATÍSTICA", 64);
        Disciplina vet2[] = {D4, D5};
        
        Aluno objAluno2  = new Aluno("Monica Mattos", "Rua Rouxinol", Util.FEMININO, 23, Util.CC, vet2);
        
        System.out.println(objAluno2.getDescricao());
        System.out.println("Disciplinas " + objAluno2.getDisciplinas());

    }
}
