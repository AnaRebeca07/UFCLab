import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class Laboratorio {
    private String identificador;
    private String nome;
    private String local;
    private String descricao;
    private int capacidade;
    private List<Equipamento> equipamentos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public Laboratorio(String nome, String local, String descricao, int capacidade){
        setNome(nome);
        setLocal(local);
        setCapacidade(capacidade);
        setDescricao(descricao);
        // identificador = criarIdentificadorLaboratorio();

        Consulta.adicionarLaboratorio(this);
    }

    public void setNome(String nome) {
        if(nome.isEmpty())
            throw new IllegalArgumentException("Campo vazio.");
        if(!nome.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException("Nao e compativel.");
        this.nome = nome;
    }

    public void setCapacidade(int capacidade) {
        if(capacidade <= 0 || capacidade > 50)
            throw new IllegalArgumentException("Capacidade invalida.");
        this.capacidade = capacidade;
    }

    public void setLocal(String local) {
        if(local.isEmpty())
            throw new IllegalArgumentException("Campo vazio.");
        if(!local.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException("Nao e compativel.");
        this.local = local;
    }

    public void setDescricao(String descricao) {
        if(descricao.isEmpty())
            throw new IllegalArgumentException("Campo vazio.");
        this.descricao = descricao;
    }

    public String getIdentificador() {
        return identificador;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLocal() {
        return local;
    }

    public String getNome() {
        return nome;
    }

    public List<Equipamento> listarEquipamentos(){
        return new ArrayList<Equipamento>(this.equipamentos);
    }

    public List<Reserva> listarReservas(){
        return new ArrayList<Reserva>(this.reservas);
    }

    public void removerEquipamento(Equipamento equipamento){
        if (!equipamentos.contains(equipamento))
            throw new NoSuchElementException("Esse equipamento nao existe ou nao pertence a esse laboratorio.");
        // if(equipamento.possuiEmprestimoNaoConcluido())
            // excecao personalizada (regra de negocio)
        equipamentos.remove(equipamento);
    }
}
