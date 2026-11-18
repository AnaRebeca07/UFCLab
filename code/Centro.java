import java.util.ArrayList;
import java.util.List;

public class Centro {
    private String nome;
    private List<Laboratorio> laboratorios = new ArrayList<>();
    private List<Usuario> usuarios = new ArrayList<>();

    public Centro(String nome){
        setNome(nome);
    }

    public void setNome(String nome) {
        if(nome.isEmpty())
            throw new IllegalArgumentException("Campo vazio.");
        if(!nome.matches("[a-zA-Z]+"))
            throw new IllegalArgumentException("Nao e compativel.");
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
