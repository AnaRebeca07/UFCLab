public class Main {
    public static void main() {
        Centro centrotest1 = new Centro("Teste 1");
        Laboratorio labtest1 = new Laboratorio("Teste 1", centrotest1, "teste sem entradas invalidas", 12);
        Equipamento equiptest1 = new Equipamento("121212", "Teste 1", "teste sem entradas invalidas", labtest1);
        Discente userdistest1 = new Discente("Teste 1", "email@teste1.com", "senha1", "121212");
        Servidor usersertest1 = new Servidor("Teste 1", "email@teste1.com", "senha1", "1212121");
    }
}
