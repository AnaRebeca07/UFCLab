public class Discente extends Usuario {
    private String matricula;

    public Discente(String nome, String email, String senha, String matricula){
        super(nome, email, senha);
        if(matricula.isEmpty())
            throw new IllegalArgumentException("Campo vazio.");
        if(!matricula.matches("[0-9]+"))
            throw new IllegalArgumentException("Nao e compativel.");
        this.matricula = matricula;
    }

    // Colocar posteriormente os métodos;

    public String getMatricula() {
        return matricula;
    }
}
