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

    public List<Emprestimo> listarEmprestimos(){
        return new ArrayList<Emprestimo>(this.emprestimos);
    }

    // a logica aqui e que se o ultimo emprestimo estiver concluido, retornara falso para a frase "possui emprestimo nao concluido". so e precison checar o ultimo pois a regra de negocio nao permite dois emprestimos em andamento ao mesmo tempo
    public boolean possuiEmprestimoNaoConcluido() {
        return !emprestimos.getLast().concluido();
    }
}
