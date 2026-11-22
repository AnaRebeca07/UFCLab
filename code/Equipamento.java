import java.util.ArrayList;
import java.util.List;

public class Equipamento {
    private String identificador;
    private String numeroPatrimonio;
    private String nome;
    private String descricao;
    private Laboratorio laboratorio;
    private Status status;
    private List<Emprestimo> emprestimos = new ArrayList<>();
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

        // identificador = criarIdentificadorLaboratorio();
    }

    public void consultar(){}

    public void setNumeroPatrimonio(String numeroPatrimonio) {
        if(numeroPatrimonio.isEmpty())
            throw new IllegalArgumentException("Campo vazio.");
        if(!numeroPatrimonio.matches("[0-9]+"))
            throw new IllegalArgumentException("Nao e compativel.");
        this.numeroPatrimonio = numeroPatrimonio;
    }

    public void setNome(String nome) {
        if(nome.isEmpty())
            throw new IllegalArgumentException("Campo vazio.");
        if(!nome.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException("Nao e compativel.");
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        if(descricao.isEmpty())
            throw new IllegalArgumentException("Campo vazio.");
        this.descricao = descricao;
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

    public void listarEmprestimos(){
        for (int i=0; i<emprestimos.size(); i++){
            System.out.println(emprestimos.get(i));
        }
    }
}
