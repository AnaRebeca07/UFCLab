import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public class Gerenciador {
    public static Reserva reservar(Solicitante solicitante, Laboratorio laboratorio, LocalDate data, LocalTime horaInicio, LocalTime horaTermino) {
        List<Reserva> reservasConflitantes = laboratorio.listarReservasConflitantes(data, horaInicio, horaTermino);

        for(int i = 0;i < reservasConflitantes.size();i++) {
            if(solicitante.getPrioridade() >= reservasConflitantes.get(i).getSolicitante().getPrioridade() && solicitante.getPrioridade() != 0)
                reservasConflitantes.get(i).cancelar();
            else
                throw new IllegalStateException("Erro ao fazer reserva: Conflito de horario.");
        }

        return new Reserva(solicitante, laboratorio, data, horaInicio, horaTermino);
    }
}
