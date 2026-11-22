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

    // Colocar os métodos;

    public String getCadastro() {
        return SIAPE;
    }
}
