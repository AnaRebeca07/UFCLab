import java.util.ArrayList;
import java.util.List;

public class Centro {
    private String nome;
    private List<Laboratorio> laboratorios = new ArrayList<>();

    public Centro(String nome){
        setNome(nome);

        Consulta.adicionarCentro(this);
    }

    // setters e getters

    public void setNome(String nome) {
        if(nome.isEmpty())
            throw new IllegalArgumentException("Erro em cadastrar nome: Campo vazio.");
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    // metodos de regra de negocio a partir daqui

    public List<Laboratorio> listarLaboratorios(){
        return new ArrayList<Laboratorio>(this.laboratorios);
    }

    public void adicionarLaboratorio(Laboratorio laboratorio) {
        if(laboratorio != null)
            laboratorios.add(laboratorio);
        else
            throw new NullPointerException("Laboratorio nao existe.");
    }

    public void removerLaboratorio(Laboratorio laboratorio) {
        if (!laboratorios.contains(laboratorio))
            throw new NullPointerException("Laboratorio nao existe ou nao pertence a esse centro.");
        // if(laboratorio.possuiReservaAtiva())
        // excecao personalizada (regra de negocio)
        laboratorios.remove(laboratorio);
    }
}
