import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Laboratorio {
    private String identificador;
    private String nome;
    private Centro centro;
    private String descricao;
    private int capacidade;
    private List<Equipamento> equipamentos = new ArrayList<>();
    private List<Reserva> reservas = new ArrayList<>();

    public Laboratorio(String nome, Centro centro, String descricao, int capacidade){
        setNome(nome);
        setCentro(centro);
        setCapacidade(capacidade);
        setDescricao(descricao);
        // identificador = Persistencia.criarIdentificadorLaboratorio();

        centro.adicionarLaboratorio(this);
    }

    // setters e getters

    public void setNome(String nome) {
        if(nome.isEmpty())
            throw new IllegalArgumentException("Erro ao cadastrar nome: Campo vazio.");
        this.nome = nome;
    }

    public void setCapacidade(int capacidade) {
        if(capacidade <= 0 || capacidade > 50)
            throw new IllegalArgumentException("Capacidade invalida.");
        this.capacidade = capacidade;
    }

    public void setCentro(Centro centro) {
        if(centro != null)
            this.centro = centro;
        else
            throw new NullPointerException("Centro nao existe.");
    }

    public void setDescricao(String descricao) {
        if(descricao.isEmpty())
            throw new IllegalArgumentException("Erro ao cadastrar descricao: Campo vazio.");
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

    public Centro getCentro() {
        return centro;
    }

    public String getNome() {
        return nome;
    }

    // metodos de regra de negocio a partir daqui

    public List<Equipamento> listarEquipamentos(){
        return new ArrayList<Equipamento>(this.equipamentos);
    }

    public List<Reserva> listarReservas(){
        return new ArrayList<Reserva>(this.reservas);
    }

    public List<Reserva> listarReservasAtivas() {
        List<Reserva> reservasAtivas = new ArrayList<>();

        for(int i = 0;i < reservas.size();i++)
            if(reservas.get(i).ativa())
                reservasAtivas.add(reservas.get(i));

        return reservasAtivas;
    }

    public void adicionarReserva(Reserva reserva) {
        if(reserva != null)
            reservas.add(reserva);
        else
            throw new NullPointerException("Reserva nao existe.");
    }

    public boolean possuiReservaAtiva() {
        return !listarReservasAtivas().isEmpty();
    }

    public List<Reserva> listarReservasConflitantes(LocalDate data, LocalTime horaInicio, LocalTime horaTermino) {
        List<Reserva> reservasAtivas = listarReservasAtivas();
        List<Reserva> reservasConflitantes = new ArrayList<>();

        for(int i = 0;i < reservasAtivas.size();i++) {
            if(data.equals(reservasAtivas.get(i).getData()))
                if(horaInicio.isBefore(reservasAtivas.get(i).getHoraTermino()) || horaTermino.isAfter(reservasAtivas.get(i).getHoraInicio()))
                    reservasConflitantes.add(reservasAtivas.get(i));
        }
        return reservasConflitantes;
    }

    public Reserva reservar(Solicitante solicitante, LocalDate data, LocalTime horaInicio, LocalTime horaTermino) {
        List<Reserva> reservasConflitantes = listarReservasConflitantes(data, horaInicio, horaTermino);

        for(int i = 0;i < reservasConflitantes.size();i++) {
            if(solicitante.getPrioridade() >= reservasConflitantes.get(i).getSolicitante().getPrioridade())
                reservasConflitantes.get(i).cancelar();
            else
                throw new IllegalStateException("Erro ao fazer reserva: Conflito de horario.");
        }

        return new Reserva(solicitante, this, data, horaInicio, horaTermino);
    }

    public void adicionarEquipamento(Equipamento equipamento) {
        if(equipamento != null)
            equipamentos.add(equipamento);
        else
            throw new NullPointerException("Equipamento nao existe.");
    }

    public void removerEquipamento(Equipamento equipamento){
        if (!equipamentos.contains(equipamento))
            throw new NullPointerException("Esse equipamento nao existe ou nao pertence a esse laboratorio.");
        // if(equipamento.possuiEmprestimoNaoConcluido())
            // excecao personalizada (regra de negocio)
        equipamentos.remove(equipamento);
    }
}
