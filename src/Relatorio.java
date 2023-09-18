public class Relatorio {

    public String gerarRelatorio(ContaBancaria conta) {
        if (conta instanceof ContaCorrente) {
            return ((ContaCorrente) conta).mostrarDados(conta.getNumero());
        } else if (conta instanceof ContaPoupanca) {
            return ((ContaPoupanca) conta).mostrarDados(conta.getNumero());
        }
        return null;
    }
}
