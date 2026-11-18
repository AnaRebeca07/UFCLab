import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private String identificador;
    private List<Reserva> reservas = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Usuario(String nome, String email, String senha){
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        // identificador = criarIdentificadorLaboratorio();
    }

    public void consultar(){
        // vamos fazer interface;
    }

    public void setNome(String nome) {
        if(nome.isEmpty())
            throw new IllegalArgumentException("Campo vazio.");
        if(!nome.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException("Nao e compativel.");
        this.nome = nome;
    }

    public void setEmail(String email) {
        // implementar depois
        this.email = email;
    }

    public void setSenha(String senha) {
        if(senha.isEmpty())
            throw new IllegalArgumentException("Campo vazio.");
        this.senha = senha;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void listarEmprestimos(){

    }
}
