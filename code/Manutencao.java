public class Manutencao extends Solicitante {
    private Centro centro;

    public Manutencao (String senha) {
        super(senha);
    }

    // metodos

    @Override
    public void setPrioridade() {
        this.prioridade = 1;
    }
}
