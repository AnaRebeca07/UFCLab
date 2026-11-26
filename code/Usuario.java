import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void setPrioridade() {
        this.prioridade = 0;
    }

    public String getNome(){
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public abstract String getCadastro();

    // metodos de regra de negocio

    public List<Emprestimo> listarEmprestimosAtraso() {
        List<Emprestimo> emprestimosAtraso = new ArrayList<>();

        for(int i = 0;i < emprestimos.size();i++) {
            if(emprestimos.get(i).atraso())
                emprestimosAtraso.add(emprestimos.get(i));
        }

        return emprestimosAtraso;
    }

    public List<Emprestimo> listarEmprestimosAndamento() {
        List<Emprestimo> emprestimosAndamento = new ArrayList<>();

        for(int i = 0;i < emprestimos.size();i++) {
            if(emprestimos.get(i).andamento())
                emprestimosAndamento.add(emprestimos.get(i));
        }

        return emprestimosAndamento;
    }
}
