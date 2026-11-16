import java.util.ArrayList;
import java.util.List;

public class Laboratorio {
    private String identificador;
    private String nome;
    private String local;
    private String descricao;
    private int capacidade;
    private boolean ativo;
    private List<Equipamento> equipamentos = new ArrayList<>();
    private static int qntdLaboratorios;

    public Laboratorio(String nome, String local, String descricao, int capacidade){
        setNome(nome);
        setLocal(local);
        setCapacidade(capacidade);
        setDescricao(descricao);

        ativo = true;

        qntdLaboratorios++;
        // identificador = toString(qntdLaboratorios);
    }
    public void consultar(){
        // fazer a interface
    }

    public void setNome(String nome) {
        if(!nome.isEmpty())
            this.nome = nome;
        else
            System.out.println("Invalido.");
    }

    public void setCapacidade(int capacidade) {
        if(capacidade > 0)
            this.capacidade = capacidade;
        else
            System.out.println("Invalido.");
    }

    public void setLocal(String local) {
        if(!local.isEmpty())
            this.local = local;
        else
            System.out.println("Invalido.");
    }

    public void setDescricao(String descricao) {
        if(!descricao.isEmpty())
            this.descricao = descricao;
        else
            System.out.println("Invalido.");
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

    public boolean isAtivo() {
        return ativo;
    }
}
