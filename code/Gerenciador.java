import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Gerenciador {
    public static Reserva solicitarReserva(Solicitante solicitante, Laboratorio laboratorio, LocalDate data, LocalTime horaInicio, LocalTime horaTermino) {
        List<Reserva> reservasConflitantesLaboratorio = laboratorio.listarReservasConflitantesLaboratorio(data, horaInicio, horaTermino);
        List<Reserva> reservasConflitantesSolicitante = solicitante.listarReservasConflitantesSolicitante(data, horaInicio, horaTermino);

        if(solicitante.getPrioridade() == 1) {
            if (!reservasConflitantesSolicitante.isEmpty())
                throw new IllegalStateException("Erro ao fazer reserva: Conflito de horario.");
            else
                for (int i = 0; i < reservasConflitantesLaboratorio.size(); i++)
                    reservasConflitantesLaboratorio.get(i).cancelar();
        } else {
            if (!reservasConflitantesLaboratorio.isEmpty())
                throw new IllegalStateException("Erro ao fazer reserva: Conflito de horario.");
            else if (!reservasConflitantesSolicitante.isEmpty())
                throw new IllegalStateException("Erro ao fazer reserva: Conflito de horario.");
            else if (!solicitante.isAutorizado())
                throw new IllegalStateException("Erro ao fazer reserva: O usuario nao tem autorizacao para fazer reservas.");
            else if (solicitante.listarReservasConfirmadas().size() == solicitante.getLimiteReservas())
                throw new IllegalStateException("Erro ao fazer reserva: Limite de reservas atingido.");
        }

        return new Reserva(solicitante, laboratorio, data, horaInicio, horaTermino);
    }
}
