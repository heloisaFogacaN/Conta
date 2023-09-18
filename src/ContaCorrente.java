import java.util.ArrayList;

public class ContaCorrente extends ContaBancaria implements IImprimivel<Integer, ContaCorrente> {
    private ArrayList<ContaCorrente> contas = new ArrayList<>();
    private double taxaDeOperacao = 3;

    public ContaCorrente(int numero, double saldo) {
        super(numero, saldo);
        contas.add(this);
    }

    @Override
    public double sacar(double valor) {
        return super.sacar(valor-3);
    }

    @Override
    public double depositar(double valor) {
        return super.depositar(valor-3);
    }

    @Override
    public String mostrarDados(Integer numero) {
        for (ContaCorrente conta : contas) {
            if (conta.getNumero() == numero) {
                return conta.toString();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Conta Corrente:\n" +
                super.toString();
    }
}
