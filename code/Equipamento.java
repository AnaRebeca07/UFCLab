import java.util.ArrayList;

public class Equipamento {
    private static int qntdEquipamentos;
    private String identificador;
    private String numeroPatrimonio;
    private String nome;
    private String descricao;
    private Laboratorio laboratorio;
    private Status status;
    public enum Status {
        DISPONIVEL("Disponivel"),
        INDISPONIVEL("Indisponivel"),
        ALUGADO("Alugado");

        private final String mensagem;

        Status(String mensagem) {
            this.mensagem = mensagem;
        }

        public String getMensagem() {
            return mensagem;
        }
    }

    public Equipamento(String numeroPatrimonio, String nome, String descricao, Laboratorio laboratorio){
        setNumeroPatrimonio(numeroPatrimonio);
        setNome(nome);
        setDescricao(descricao);
        setLaboratorio(laboratorio);
        status = Status.DISPONIVEL;

        qntdEquipamentos++;
        // identificador = toString(qntdEquipamentos);
    }
    public void consultar(){}

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        if(!numeroPatrimonio.isEmpty())
            this.numeroPatrimonio = numeroPatrimonio;
        else
            System.out.println("Invalido.");
    }
    public void setNome(String nome) {
        if(!nome.isEmpty())
            this.nome = nome;
        else
            System.out.println("Invalido.");
    }
    public void setDescricao(String descricao) {
        if(!descricao.isEmpty())
            this.descricao = descricao;
        else
            System.out.println("Invalido.");
    }
    public void setLaboratorio(Laboratorio laboratorio){
        this.laboratorio = laboratorio;
    }

    public String getNumeroPatrimonio(){
        return numeroPatrimonio;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Laboratorio getLaboratorio() {
        return laboratorio;
    }

    public String getStatus() {
        return status.getMensagem();
    }
}
