import java.util.ArrayList;
import java.util.List;

public class Consulta {
    private static List<Laboratorio> laboratorios = new ArrayList<>();
    private static List<Usuario> usuarios = new ArrayList<>();

    public static void adicionarLaboratorio(Laboratorio laboratorio) {
        if(laboratorio != null)
            laboratorios.add(laboratorio);
    }

    public static void adicionarUsuario(Usuario usuario) {
        if(usuario != null)
            usuarios.add(usuario);
    }

    // implementar remocao de laboratorio

    public static List<Laboratorio> listarLaboratorios() {
        return laboratorios;
    }

    public static List<Usuario> listarUsuarios() {
        return usuarios;
    }

    public static List<Equipamento> listarEquipamentos() {
        List<Equipamento> equipamentos = new ArrayList<>();

        for(int i = 0;i < laboratorios.size();i++) {
            equipamentos.addAll(laboratorios.get(i).listarEquipamentos());
        }

        return equipamentos;
    }

    // ta completamente ilegivel mas acho que funciona, melhorar depois

    public static List<Emprestimo> listarEmprestimosAndamento() {
        List<Emprestimo> emprestimosAndamento = new ArrayList<>();
        List<Equipamento> equipamentos = listarEquipamentos();

        for(int i = 0;i < equipamentos.size();i++) {
            for(int j = 0;j < equipamentos.get(i).listarEmprestimos().size();i++) {
                if(equipamentos.get(i).listarEmprestimos().get(j).andamento())
                    emprestimosAndamento.add(equipamentos.get(i).listarEmprestimos().get(j));
            }
        }

        return emprestimosAndamento;
    }

    public static List<Emprestimo> listarEmprestimosAtraso() {
        List<Emprestimo> emprestimosAtraso = new ArrayList<>();
        List<Equipamento> equipamentos = listarEquipamentos();

        for(int i = 0;i < equipamentos.size();i++) {
            for(int j = 0;j < equipamentos.get(i).listarEmprestimos().size();i++) {
                if(equipamentos.get(i).listarEmprestimos().get(j).atraso())
                    emprestimosAtraso.add(equipamentos.get(i).listarEmprestimos().get(j));
            }
        }

        return emprestimosAtraso;
    }
}
