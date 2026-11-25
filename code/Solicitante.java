import java.util.ArrayList;
import java.util.List;

public abstract class Solicitante {
    protected List<Reserva> reservas = new ArrayList<>();
    protected List<Emprestimo> emprestimos = new ArrayList<>();
    protected String senha;
    protected int prioridade;

    public Solicitante (String senha) {
        setSenha(senha);
    }

    public void setSenha(String senha) {
        if(senha.isEmpty())
            throw new IllegalArgumentException("Erro ao cadastra senha: Campo vazio.");
        this.senha = senha;
    }

    public List<Reserva> listarReservas(){
        return new ArrayList<Reserva>(this.reservas);
    }

    public List<Emprestimo> listarEmprestimos(){
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

    public abstract void setPrioridade();

    public int getPrioridade() {
        return prioridade;
    }
}
