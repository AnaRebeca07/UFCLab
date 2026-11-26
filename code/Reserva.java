import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva {
    private Solicitante solicitante;
    private Laboratorio laboratorio;
    private LocalDate data;
    private LocalTime horaInicio, horaTermino;
    private enum Status {
        CONCLUIDA("concluida"),
        CONFIRMADA("confirmada"),
        CANCELADA("cancelada");

        private final String descricao;

        Status(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
    private Reserva.Status status;

    public Reserva(Solicitante solicitante, Laboratorio laboratorio, LocalDate data, LocalTime horaInicio, LocalTime horaTermino){
        if(solicitante != null)
            this.solicitante = solicitante;
        else
            throw new NullPointerException("Usuario nao existe.");
        if(laboratorio != null)
            this.laboratorio = laboratorio;
        else
            throw new NullPointerException("Laboratorio nao existe.");

        if(data != null)
            this.data = data;
        else
            throw new IllegalArgumentException("Data nao pode ser nula.");

        if(horaInicio == null)
            throw new NullPointerException("Horario nao pode ser nulo.");
        if(horaTermino == null)
            throw new NullPointerException("Horario nao pode ser nulo.");
        if(horaInicio.isBefore(LocalTime.of(8,0)) || horaInicio.isAfter(LocalTime.of(22,0)))
            throw new IllegalArgumentException("Horario invalido.");
        if(horaTermino.isBefore(LocalTime.of(8,0)) || horaTermino.isAfter(LocalTime.of(22,0)) || !horaTermino.isAfter(horaInicio))
            throw new IllegalArgumentException("Horario invalido.");
        this.horaInicio = horaInicio;
        this.horaTermino = horaTermino;

        status = Status.CONFIRMADA;

        laboratorio.adicionarReserva(this);
        solicitante.adicionarReserva(this);
    }

    // getters

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    // depois pensamos na logica do solicitante
    public Solicitante getSolicitante() {
        return solicitante;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalTime getHoraInicio() {
        return horaInicio;
    }

    public LocalTime getHoraTermino() {
        return horaTermino;
    }

    // metodos de regra de negocio a partir daqui

    public void cancelar() {
        status = Status.CANCELADA;
    }

    public boolean concluida() {
        return this.status == Reserva.Status.CONCLUIDA;
    }

    public boolean confirmada() {
        return this.status == Status.CONFIRMADA;
    }

    public boolean cancelada() {
        return this.status == Reserva.Status.CANCELADA;
    }
}
