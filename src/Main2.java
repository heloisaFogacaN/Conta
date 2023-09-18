import java.util.Scanner;

public class Main2 {
    static Banco banco = new Banco();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        menu();
    }

    private static void menu() {
        int opcao;
        do {
            System.out.println("""
                    Bem-vindo!
                    
                    Informe a ação que deseja solicitar:
                    
                    1- Cadastrar
                    2- Selecionar conta
                    3- Remover conta
                    4- Gerar relatório
                    5- Finalizar        
                    """);
            opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    cadastrar();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    remover();
                    break;
                case 4:
//                    gerarRelatorio();
                    break;
                case 5:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        } while (opcao != 5);
    }

    private static void cadastrar() {
        int opcao;
        do {
            System.out.println("""
                    Informe a conta que deseja cadastrar:
                                   
                    0- Sair
                    1- Conta Poupança
                    2- Conta Corrente
                                    
                    """);
            opcao = scanner.nextInt();
            cadastrar(opcao);
            if (opcao != 1 || opcao != 2 || opcao != 0) {
                System.out.println("Opção inválida!");
            }
        } while (opcao != 0 && opcao != 1 && opcao != 2);
    }

    private static void cadastrar(int opcao) {
        System.out.println("Informe o número da conta: ");
        int numero = scanner.nextInt();
        System.out.println("Informe o saldo: ");
        double saldo = scanner.nextDouble();
        ContaBancaria contaAdd;
        if (opcao == 1) {
            contaAdd = new ContaPoupanca(numero, saldo);
        } else {
            contaAdd = new ContaCorrente(numero, saldo);
        }
        banco.inserir(contaAdd);
    }
    private static void login() {
        ContaBancaria conta;
        do {
            System.out.println("Informe o número da conta: ");
            conta = banco.procurarConta(scanner.nextInt());
            if (conta == null){
                System.out.println("Conta inexistente!");
            }
        }while (conta==null);
//        menuLogin();
    }

    private static void remover(){
        System.out.println("Informe o número da conta que deseja remover: ");
        int numero = scanner.nextInt();
        System.out.println("Informe o saldo: ");
        double saldo = scanner.nextDouble();

        ContaBancaria conta= new
        banco.remover(scanner.nextInt());
    }
}
