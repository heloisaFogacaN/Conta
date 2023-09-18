import java.util.Scanner;

public class Main2 {
    static Banco banco = new Banco();
    static Scanner scanner = new Scanner(System.in);
    static ContaBancaria contaLogada;

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
            switch (opcao) {
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
                    gerarRelatorio();
                    break;
                case 5:
                    contaLogada = null;
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
            if (opcao == 1 || opcao == 2) {
                cadastrar(opcao);
            } else if (opcao != 1 && opcao != 2 && opcao != 0) {
                System.out.println("Opção inválida!");
            }
        } while (!(opcao == 0 || opcao == 1 || opcao == 2));
    }

    private static void cadastrar(int opcao) {
        System.out.println("Informe o número da conta: ");
        int numero = scanner.nextInt();
        System.out.println("Informe o saldo: ");
        double saldo = scanner.nextDouble();
        ContaBancaria contaAdd = banco.procurarConta(numero);
        {
            if (contaAdd == null) {
                if (opcao == 1) {
                    contaAdd = new ContaPoupanca(numero, saldo);
                } else {
                    contaAdd = new ContaCorrente(numero, saldo);
                }
                banco.inserir(contaAdd);
            } else {
                System.out.println("Já há uma conta com este número!");
            }
        }
    }

    private static void login() {
        do {
            System.out.println("Informe o número da conta: ");
            contaLogada = banco.procurarConta(scanner.nextInt());
            if (contaLogada == null) {
                System.out.println("Conta inexistente!");
            }
        } while (contaLogada == null);
        menuLogin();
    }

    private static void remover() {
        System.out.println("Informe o número da conta que deseja remover: ");
        int numero = scanner.nextInt();

        ContaBancaria contaExcluir = banco.procurarConta(numero);
        banco.remover(contaExcluir);
    }

    private static void gerarRelatorio() {
        for (ContaBancaria conta : banco.procurarTodos()) {
            System.out.println(conta.toString() + "\n");
        }
    }

    private static void gerarRelatorio(int numero) {
        System.out.println(banco.procurarConta(numero));
    }

    private static void menuLogin() {
        int opcao;
        do {
            System.out.println("""
                    Informe a ação que você deseja efetuar:
                                    
                    1- Depositar
                    2- Sacar
                    3- Tranferir
                    4- Gerar relatório
                    5- Sair
                    """);
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    depositar();
                    break;
                case 2:
                    sacar();
                    break;
                case 3:
                    tranferir();
                    break;
                case 4:
                    gerarRelatorio(contaLogada.getNumero());
            }
        } while (opcao != 5);
    }

    private static void depositar() {
        System.out.println("Informe o valor que deseja depositar: ");
        contaLogada.depositar(scanner.nextDouble());
    }

    private static void sacar() {
        double valor;
        boolean verificar = false;
        do {
            System.out.println("Informe o valor que deseja sacar: ");
            valor = scanner.nextDouble();

            if (contaLogada instanceof ContaPoupanca) {
                verificar = ((ContaPoupanca) contaLogada).verificar(valor);
                if (!verificar) {
                    System.out.println("Você não possui saldo o suficiente!");
                }
            } else if (contaLogada instanceof ContaCorrente) {

                verificar = contaLogada.verficar(valor);
                if (!verificar) {
                    System.out.println("Você não possui saldo o suficiente!");
                }
            }
        } while (!verificar);
        contaLogada.sacar(valor);
    }

    private static void tranferir() {
        ContaBancaria conta;
        do {
            System.out.println("Informe a conta que você deseja efetuar a transferência:");
            int numero = scanner.nextInt();
            conta = banco.procurarConta(numero);
            if (conta == null) {
                System.out.println("Essa conta é inexistente!");
            }
        } while (conta == null);

        double valor;
        boolean verificar = false;
        do {
            System.out.println("Informe o valor que deseja sacar: ");
            valor = scanner.nextDouble();

            if (contaLogada instanceof ContaPoupanca) {
                do {
                    verificar = ((ContaPoupanca) contaLogada).verificar(valor);
                    if (!verificar) {
                        System.out.println("Você não possui saldo o suficiente!");
                    }
                } while (!verificar);
            } else if (contaLogada instanceof ContaCorrente) {
                verificar = contaLogada.verficar(valor);
                if (!verificar) {
                    System.out.println("Você não possui saldo o suficiente!");
                }
            }

        } while (!verificar);

        contaLogada.tranferir(valor, conta);
    }
}
