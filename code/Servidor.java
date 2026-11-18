public class Servidor extends Usuario{
    private String cadastro;

    public Servidor(String nome, String email, String senha, String cadastro){
        super(nome, email, senha);
        if(cadastro.isEmpty())
            throw new IllegalArgumentException("Campo vazio.");
        if(!cadastro.matches("[0-9]+"))
            throw new IllegalArgumentException("Nao e compativel.");
        this.cadastro = cadastro;
    }

    // Colocar os métodos;

    public String getCadastro() {
        return cadastro;
    }
}
