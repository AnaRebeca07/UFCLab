import java.util.ArrayList;
import java.util.List;

public class Usuario {
    private String nome;
    private String email;
    private String senha;
    private List<Reserva> reservas = new ArrayList<>();
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Usuario(String nome, String email, String senha){
        setNome(nome);
        setEmail(email);
        setSenha(senha);
    }

    public void consultar(){
        // vamos fazer interface;
    }

    public void setNome(String nome) {
        if(!nome.isEmpty())
            this.nome = nome;
        else
            System.out.println("Invalido.");
    }

    public void setEmail(String email) {
        if(!email.isEmpty())
            this.email = email;
        else
            System.out.println("Invalido.");
    }

    public void setSenha(String senha) {
        if(!senha.isEmpty())
            this.senha = senha;
        else
            System.out.println("Invalido.");
    }

    public String getNome(){
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
