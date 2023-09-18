import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ContaPoupanca contaPoupanca = new ContaPoupanca(111, 0);
    static ContaCorrente contaCorrente = new ContaCorrente(222, 0);

    public static void main(String[] args) {

        System.out.println("Informe o valor que deseja depositar na Conta Corrente: ");
        contaCorrente.depositar(scanner.nextDouble());
        System.out.println("Informe o valor que deseja depositar na Conta Poupança: ");
        contaPoupanca.depositar(scanner.nextDouble());

        Relatorio relatorio = new Relatorio();

        System.out.println(relatorio.gerarRelatorio(contaPoupanca)+ "\n");
        System.out.println(relatorio.gerarRelatorio(contaCorrente));

        System.out.println("Informe o valor que deseja sacar na Conta Corrente: ");
        contaCorrente.sacar(scanner.nextDouble());

        boolean verificar;
        double valor;
        System.out.println("Informe o valor que deseja sacar na Conta Poupança:");
        valor = scanner.nextDouble();
        verificar = contaPoupanca.verificar(valor);
        if (!verificar) {
            System.out.println("Você não possui saldo o suficiente!");
        } else {
            contaPoupanca.sacar(valor);
        }

        System.out.println(relatorio.gerarRelatorio(contaPoupanca) + "\n");
        System.out.println(relatorio.gerarRelatorio(contaCorrente));

    }
}
