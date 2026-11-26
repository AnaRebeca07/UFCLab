public class Manutencao extends Solicitante {
    private Centro centro;

    public Manutencao (String senha) {
        super(senha);
    }

    // metodos de regra de negocio

    @Override
    public void setPrioridade() {
        this.prioridade = 1;
    }

    @Override
    public void setLimiteReservas() {
        // nao ha limite para as reservas de manutencao
    }
}
