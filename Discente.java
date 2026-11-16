public class Discente extends Usuario {
    private String matricula;

    public Discente(String nome, String email, String senha, String matricula){
        super(nome, email, senha);
        if(!matricula.isEmpty())
            this.matricula = matricula;
        else
            System.out.println("Invalido.");
    }
// Colocar posteriormente os métodos;

    public String getMatricula() {
        return matricula;
    }
}
