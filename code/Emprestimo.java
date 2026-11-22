import java.util.ArrayList;
import java.util.Date;

public class Emprestimo {
    private Usuario usuario;
    private Equipamento equipamento;
    private Date dataRetirada, previsaoDevolucao;

    public Emprestimo(Usuario usuario, Equipamento equipamento, Date dataRetirada, Date previsaoDevolucao) {
        this.usuario = usuario;
        this.equipamento = equipamento;
        this.dataRetirada = dataRetirada;
        this.previsaoDevolucao = previsaoDevolucao;
    }
}
