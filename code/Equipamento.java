import java.util.ArrayList;
import java.util.List;

public class Equipamento {
    private String identificador;
    private String numeroPatrimonio;
    private String nome;
    private String descricao;
    private Laboratorio laboratorio;
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Equipamento(String numeroPatrimonio, String nome, String descricao, Laboratorio laboratorio){
        setNumeroPatrimonio(numeroPatrimonio);
        setNome(nome);
        setDescricao(descricao);
        setLaboratorio(laboratorio);

        // identificador = Persistencia.criarIdentificadorEquipamento();

        laboratorio.adicionarEquipamento(this);
    }

    // setters e getters

    private void setNumeroPatrimonio(String numeroPatrimonio) {
        if(numeroPatrimonio.isEmpty())
            throw new IllegalArgumentException("Campo vazio.");
        if(!numeroPatrimonio.matches("[0-9]+"))
            throw new IllegalArgumentException("Nao e compativel.");
        if(Consulta.numeroPatrimonioRepetido(numeroPatrimonio))
            // excecao personalizada
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

    // metodos de regra de negocio a partir daqui

    public List<Emprestimo> listarEmprestimos(){
        return new ArrayList<Emprestimo>(this.emprestimos);
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        if(emprestimo != null)
            emprestimos.add(emprestimo);
        else
            throw new NullPointerException("Emprestimo nao existe.");
    }

    // pela regra de negocio, so e possivel haver um emprestimo por vez por equipamento
    // por isso, o sistema checa apenas o ultimo emprestimo do historico
    public boolean possuiEmprestimoNaoConcluido() {
        return !emprestimos.getLast().concluido();
    }
}
