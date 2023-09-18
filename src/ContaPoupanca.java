import java.util.ArrayList;

public class ContaPoupanca extends ContaBancaria implements IImprimivel<Integer, ContaPoupanca> {
    private ArrayList<ContaPoupanca> contas = new ArrayList<>();
    private double limite = -150;


    public ContaPoupanca(int numero, double saldo) {
        super(numero, saldo);
        contas.add(this);
    }

    @Override
    public double sacar(double valor) {
        return super.sacar(valor);
    }

    @Override
    public double depositar(double valor) {
        return super.depositar(valor);
    }

    public boolean verificar(double valor) {
        if ((getSaldo() - valor) < (limite)) {
            return false;
        }
        return true;
    }

    @Override
    public String mostrarDados(Integer numero) {
        for (ContaPoupanca conta : contas) {
            if (conta.getNumero() == numero) {
                return conta.toString();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Conta Poupanca\n" +
                super.toString();
    }
}
