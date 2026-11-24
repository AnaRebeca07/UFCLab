public class Discente extends Usuario {
    private String matricula;

    public Discente(String nome, String email, String senha, String matricula){
        super(nome, email, senha);
        setMatricula(matricula);
    }

    // setters e getters

    private void setMatricula(String matricula) {
        if(matricula.isEmpty())
            throw new IllegalArgumentException("Erro ao cadastrar matricula: Campo vazio.");
        if(!matricula.matches("[0-9]+"))
            throw new IllegalArgumentException("Erro ao cadastrar matricula: Nao e compativel.");
        if(matricula.length() != 6)
            throw new IllegalArgumentException("Erro ao cadastrar matricula: Quantidade de digitos invalida.");
        //if(Consulta.cadastroRepetido(matricula))
            // excecao personalizada
        this.matricula = matricula;
    }

    @Override
    public String getCadastro() {
        return matricula;
    }
}
