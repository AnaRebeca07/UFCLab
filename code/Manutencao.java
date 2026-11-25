public class Manutencao extends Solicitante {
    private Centro centro;

    public Manutencao (String senha) {
        super(senha);
    }

    // metodos

    @Override
    public int getPrioridade() {
        return 1;
    }
}
