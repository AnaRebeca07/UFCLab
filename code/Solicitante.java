import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public abstract class Solicitante {
    protected List<Reserva> reservas = new ArrayList<>();
    protected List<Emprestimo> emprestimos = new ArrayList<>();
    protected String senha;
    protected int prioridade, limiteReservas;
    protected boolean autorizado;

    public Solicitante (String senha) {
        setSenha(senha);
        setPrioridade();
        setLimiteReservas();
        autorizado = true;
    }

    // setters e getters

    public void setSenha(String senha) {
        if(senha.isEmpty())
            throw new IllegalArgumentException("Erro ao cadastra senha: Campo vazio.");
        this.senha = senha;
    }

    public abstract void setPrioridade();

    public abstract void setLimiteReservas();

    public int getPrioridade() {
        return prioridade;
    }

    public int getLimiteReservas() {
        return limiteReservas;
    }

    public boolean isAutorizado() {
        return autorizado;
    }

    // metodos de regra de negocio

    public void adicionarReserva(Reserva reserva) {
        if(reserva != null)
            reservas.add(reserva);
        else
            throw new NullPointerException("Reserva nao existe.");
    }

    public List<Reserva> listarReservas(){
        return new ArrayList<Reserva>(this.reservas);
    }

    public List<Reserva> listarReservasConfirmadas() {
        List<Reserva> reservasConfirmadas = new ArrayList<>();

        for(int i = 0;i < reservas.size();i++)
            if(reservas.get(i).confirmada())
                reservasConfirmadas.add(reservas.get(i));

        return reservasConfirmadas;
    }

    public List<Reserva> listarReservasConflitantesSolicitante(LocalDate data, LocalTime horaInicio, LocalTime horaTermino) {
        List<Reserva> reservasConfirmadas = listarReservasConfirmadas();
        List<Reserva> reservasConflitantesSolicitante = new ArrayList<>();

        for(int i = 0;i < reservasConfirmadas.size();i++) {
            if(data.equals(reservasConfirmadas.get(i).getData()))
                if(horaInicio.isBefore(reservasConfirmadas.get(i).getHoraTermino()) || horaTermino.isAfter(reservasConfirmadas.get(i).getHoraInicio()))
                    reservasConflitantesSolicitante.add(reservasConfirmadas.get(i));
        }
        return reservasConflitantesSolicitante;
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        if(emprestimo != null)
            emprestimos.add(emprestimo);
        else
            throw new NullPointerException("Emprestimo nao existe.");
    }

    public List<Emprestimo> listarEmprestimos(){
        return new ArrayList<Emprestimo>(this.emprestimos);
    }
}
