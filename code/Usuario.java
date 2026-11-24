import java.util.ArrayList;
import java.util.List;

public class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    protected String identificador;
    protected List<Reserva> reservas = new ArrayList<>();
    protected List<Emprestimo> emprestimos = new ArrayList<>();

    public Usuario(String nome, String email, String senha){
        setNome(nome);
        setEmail(email);
        setSenha(senha);
        // identificador = Persistencia.criarIdentificadorUsuario();

        Consulta.adicionarUsuario(this);
    }

    // setters e getters

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

    public String getCadastro() { return ""; }

    // metodos de regra de negocio a partir daqui

    public List<Reserva> listarReservas(){
        return new ArrayList<Reserva>(this.reservas);
    }

    public List<Emprestimo> listarEmprestimo(){
        return new ArrayList<Emprestimo>(this.emprestimos);
    }

    public void adicionarReserva(Reserva reserva) {
        if(reserva != null)
            reservas.add(reserva);
        else
            throw new NullPointerException("Reserva nao existe.");
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        if(emprestimo != null)
            emprestimos.add(emprestimo);
        else
            throw new NullPointerException("Emprestimo nao existe.");
    }
}
