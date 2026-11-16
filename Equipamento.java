import java.util.ArrayList;

public class Equipamento {
    private static int qtdEquipamentos;
    private String numeroPatrimonio;
    private String nome;
    private String descricao;
    private Laboratorio laboratorio;
    private String status;

    public Equipamento(String numeroPatrimonio, String nome, String descricao, Laboratorio laboratorio){
        qtdEquipamentos++;
        setNumeroPatrimonio(numeroPatrimonio);
        setNome(nome);
        setDescricao(descricao);
        setLaboratorio(laboratorio);
        status = "disponivel";
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
        return status;
    }
}
