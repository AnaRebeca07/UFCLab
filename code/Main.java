public class Main {
    public static void main() {
        Centro centrotest1 = new Centro("Teste 1");
        Laboratorio labtest1 = new Laboratorio("Teste 1", centrotest1, "teste sem entradas invalidas", 12);
        Equipamento equiptest1 = new Equipamento("121212", "Teste 1", "teste sem entradas invalidas", labtest1);
        Discente userdistest1 = new Discente("Teste um", "email@teste1.com", "senha1", "121212");
        Servidor usersertest1 = new Servidor("Teste um", "email@teste1.com", "senha1", "1212121");

        Centro centrotest2 = new Centro("");
        Laboratorio labtest2 = new Laboratorio("Teste 2",   null, "teste com entradas invalidas", 0);
        Equipamento equiptest2 = new Equipamento("121212", "Teste 1", "teste com entradas invalidas", labtest2);
        Discente userdistest2 = new Discente("Teste 2", "", "senha2", "2121212");
        Servidor usersertest2 = new Servidor("Teste dois", "email@teste2.com", "", "aa21aa2");

        System.out.printf("----- Centro ------\nNome: %s\n----------\n", centrotest2.getNome());
        System.out.printf("----- Laboratorio ------\nNome: %s\nDescricao: %s\nCentro: %s\nCapacidade: %d\n----------\n", labtest2.getNome(), labtest2.getDescricao(), labtest2.getCentro().getNome(), labtest2.getCapacidade());
        System.out.printf("----- Equipamento ------\nNome: %s\nDescricao: %s\nLaboratorio: %s\nNumero de Patrimonio: %s\n----------\n", equiptest2.getNome(), equiptest2.getDescricao(), equiptest2.getLaboratorio().getNome(), equiptest2.getNumeroPatrimonio());
        System.out.printf("----- Discente ------\nNome: %s\nEmail: %s\nMatricula: %s\n----------\n", userdistest2.getNome(), userdistest2.getEmail(), userdistest2.getCadastro());
        System.out.printf("----- Docente ------\nNome: %s\nEmail: %s\nSIAPE: %s\n----------\n", usersertest2.getNome(), usersertest2.getEmail(), usersertest2.getCadastro());

    }
}
