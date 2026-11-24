public class Reserva {
    private Usuario usuario;
    private Laboratorio laboratorio;
    private int horaInicio, horaTermino;
    private enum Status {
        CONCLUIDA("concluida"),
        MARCADA("marcada"),
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

    public Reserva(Usuario usuario, Laboratorio laboratorio, int horaInicio, int horaTermino){
        if(usuario != null)
            this.usuario = usuario;
        else
            throw new NullPointerException("Usuario nao existe.");
        if(laboratorio != null)
            this.laboratorio = laboratorio;
        else
            throw new NullPointerException("Laboratorio nao existe.");

        if (horaInicio < 8 || horaInicio > 22) {
            throw new IllegalArgumentException("Horario invalido.");
        } else
            this.horaInicio = horaInicio;
        if (horaTermino < 8 || horaTermino > 22 || horaTermino < horaInicio) {
            throw new IllegalArgumentException("Horario invalido.");
        } else
            this.horaTermino = horaTermino;

        status = Status.MARCADA;

        laboratorio.adicionarReserva(this);
        usuario.adicionarReserva(this);
    }

    public boolean concluida() {
        return this.status == Reserva.Status.CONCLUIDA;
    }

    public boolean marcada() {
        return this.status == Reserva.Status.MARCADA;
    }

    public boolean cancelada() {
        return this.status == Reserva.Status.CANCELADA;
    }
}
