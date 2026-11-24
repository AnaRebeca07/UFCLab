import java.util.Date;

public class Emprestimo {
    private Usuario usuario;
    private Equipamento equipamento;
    private Date dataRetirada, previsaoDevolucao;
    private enum Status {
        CONCLUIDO("concluido"),
        ANDAMENTO("em andamento"),
        ATRASO("atrasado");

        private final String descricao;

        Status(String descricao) {
            this.descricao = descricao;
        }

        public String getDescricao() {
            return descricao;
        }
    }
    private Status status;

    public Emprestimo(Usuario usuario, Equipamento equipamento, Date dataRetirada, Date previsaoDevolucao) {
        this.usuario = usuario;
        this.equipamento = equipamento;
        this.dataRetirada = dataRetirada;
        this.previsaoDevolucao = previsaoDevolucao;
        status = Status.ANDAMENTO;

        equipamento.adicionarEmprestimo(this);
        usuario.adicionarEmprestimo(this);
    }

    public boolean concluido() {
        return this.status == Status.CONCLUIDO;
    }

    public boolean andamento() {
        return this.status == Status.ANDAMENTO;
    }

    public boolean atraso() {
        return this.status == Status.ATRASO;
    }
}
