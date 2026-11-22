import java.util.ArrayList;

public class Reserva {
    private Usuario usuario;
    private Laboratorio laboratorio;
    private int horaInicio, horaTermino, status;

    public Reserva(Usuario usuario, Laboratorio laboratorio, int horaInicio, int horaTermino, int status){
        this.usuario = usuario;
        this.laboratorio = laboratorio;
        if (horaInicio < 0 || horaInicio > 24){
            System.out.println("Horario invalido");
        }else
            this.horaInicio = horaInicio;
        if (horaTermino < 0 || horaTermino > 24 || horaTermino < horaInicio){
            System.out.println("Horario invalido");
        }else
            this.horaTermino = horaTermino;
    }
}
