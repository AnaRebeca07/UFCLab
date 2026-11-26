import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Consulta {
    private static List<Centro> centros = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void adicionarCentro(Centro centro) {
        if(centro != null)
            centros.add(centro);
        else
            throw new NullPointerException("Centro nao existe.");
    }

    public static void adicionarUsuario(Usuario usuario) {
        if(usuario != null)
            usuarios.add(usuario);
        else
            throw new NullPointerException("Usuario nao existe.");
    }

    public static List<Centro> listarCentros() {
        return centros;
    }

    public static List<Usuario> listarUsuarios() {
        return usuarios;
    }

    public static List<Laboratorio> listarTodosLaboratorios() {
        List<Laboratorio> laboratorios = new ArrayList<>();

        for(int i = 0; i < centros.size(); i++) {
            laboratorios.addAll(centros.get(i).listarLaboratorios());
        }

        return laboratorios;
    }

    public static List<Equipamento> listarTodosEquipamentos() {
        List<Laboratorio> laboratorios = listarTodosLaboratorios();
        List<Equipamento> equipamentos = new ArrayList<>();

        for(int i = 0;i < laboratorios.size();i++) {
            equipamentos.addAll(laboratorios.get(i).listarEquipamentos());
        }

        return equipamentos;
    }

    public static boolean numeroPatrimonioRepetido(String numeroPatrimonio) {
        List<Equipamento> equipamentos = listarTodosEquipamentos();

        for(int i = 0;i < equipamentos.size();i++) {
            if(equipamentos.get(i).getNumeroPatrimonio().equals(numeroPatrimonio))
                return true;
        }
        return false;
    }

    public static boolean cadastroRepetido(String cadastro) {
        for(int i = 0;i < usuarios.size();i++) {
            if(usuarios.get(i).getCadastro().equals(cadastro))
                return true;
        }
        return false;
    }

    public static List<Emprestimo> listarTodosEmprestimosAndamento() {
        List<Emprestimo> todosEmprestimosAndamento = new ArrayList<>();

        for(int i = 0;i < usuarios.size();i++) {
            todosEmprestimosAndamento.addAll(usuarios.get(i).listarEmprestimosAndamento());
        }

        return todosEmprestimosAndamento;
    }

    public static List<Emprestimo> listarTodosEmprestimosAtraso() {
        List<Emprestimo> todosEmprestimosAtraso = new ArrayList<>();

        for(int i = 0;i < usuarios.size();i++) {
            todosEmprestimosAtraso.addAll(usuarios.get(i).listarEmprestimosAtraso());
        }

        return todosEmprestimosAtraso;
    }

    public static List<Laboratorio> consultarDisponibilidadeLaboratorio(LocalDate data, LocalTime horaInicio, LocalTime horaTermino) {
        List<Laboratorio> laboratorios = listarTodosLaboratorios();
        List<Laboratorio> laboratoriosDisponiveis = new ArrayList<>();

        for(int i = 0;i < laboratorios.size();i++)
            if(!laboratorios.get(i).possuiReservaConflitante(data, horaInicio, horaTermino))
                laboratoriosDisponiveis.add(laboratorios.get(i));

        return laboratoriosDisponiveis;
    }
}
