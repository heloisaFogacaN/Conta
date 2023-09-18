public abstract class ContaBancaria {
    private int numero;
    private double saldo;

    public ContaBancaria(int numero, double saldo){
        this.numero = numero;
        this.saldo = saldo;
    }

    public double sacar(double valor){
        return saldo-=valor;
    }

    public double depositar(double valor){
        return saldo+=valor;
    }

    public void tranferir(double valor, ContaBancaria contaBancaria, int numero){

    }

    public int getNumero() {
        return numero;
    }

    public double getSaldo() {
        return saldo;
    }

    @Override
    public String toString() {
        return "Número: " + numero +
                "\nSaldo: " + saldo ;
    }

}
