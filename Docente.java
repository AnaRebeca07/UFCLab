public class Docente extends Usuario{
    private String cadastro;

    public Docente(String nome, String email, String senha, String cadastro){
        super(nome, email, senha);
        if(!cadastro.isEmpty())
            this.cadastro = cadastro;
        else
            System.out.println("Invalido.");
    }
    // Colocar os métodos;

    public String getCadastro() {
        return cadastro;
    }
}
