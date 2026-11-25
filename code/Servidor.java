public class Servidor extends Usuario{
    private String SIAPE;

    public Servidor(String nome, String email, String senha, String SIAPE){
        super(nome, email, senha);
        if(SIAPE.isEmpty())
            throw new IllegalArgumentException("Campo vazio.");
        if(!SIAPE.matches("[0-9]+"))
            throw new IllegalArgumentException("Nao e compativel.");
        this.SIAPE = SIAPE;
    }

    // setters e getters

    private void setSIAPE(String SIAPE) {
        if(SIAPE.isEmpty())
            throw new IllegalArgumentException("Erro ao cadastrar SIAPE: Campo vazio.");
        if(!SIAPE.matches("[0-9]+"))
            throw new IllegalArgumentException("Erro ao cadastrar SIAPE: Nao e compativel.");
        if(SIAPE.length() != 7)
            throw new IllegalArgumentException("Erro ao cadastrar SIAPE: Quantidade de digitos invalida.");
        if(Consulta.cadastroRepetido(SIAPE))
            throw new RepeticaoException("Erro ao cadastrar SIAPE: Cadastro ja existe. ");
        this.SIAPE = SIAPE;
    }

    @Override
    public String getCadastro() {
        return SIAPE;
    }
}
