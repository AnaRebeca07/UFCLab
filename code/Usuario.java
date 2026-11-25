public abstract class Usuario extends Solicitante {
    protected String nome;
    protected String email;
    protected String identificador;

    public Usuario(String nome, String email, String senha){
        super(senha);
        setNome(nome);
        setEmail(email);
        // identificador = Persistencia.criarIdentificadorUsuario();

        Consulta.adicionarUsuario(this);
    }

    // setters e getters

    public void setNome(String nome) {
        if(nome.isEmpty())
            throw new IllegalArgumentException("Erro ao cadastrar nome: Campo vazio.");
        if(!nome.matches("[a-zA-Z ]+"))
            throw new IllegalArgumentException("Erro ao cadastrar nome: Nao e compativel.");
        this.nome = nome;
    }

    public void setEmail(String email) {
        if(email.isEmpty())
            throw new IllegalArgumentException("Erro ao cadastrar email: Campo vazio.");
        this.email = email;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public abstract String getCadastro();

    @Override
    public int getPrioridade() {
        return 0;
    }
}
