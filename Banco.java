package exercicio1;

public class Banco {
    public static void main(String[] args) {
        ContaBanco pessoa1 = new ContaBanco();
        pessoa1.setNumConta(1111);
        pessoa1.setDono("Jubileu");
        pessoa1.abrirConta("corrente");
        pessoa1.depositar(100);
        pessoa1.estadoAtual();

        ContaBanco pessoa2 = new ContaBanco(2222, "Creuza", "poupança");
        pessoa2.depositar(500);
        pessoa2.sacar(100);
        pessoa2.estadoAtual();
    }
}
