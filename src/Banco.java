import java.util.ArrayList;

public class Banco implements IImprimivel<Integer, ContaBancaria>{
    static ArrayList<ContaBancaria> contas = new ArrayList<>();

    public void inserir(ContaBancaria conta){
        contas.add(conta);
    }
    public void remover(ContaBancaria conta){
        contas.remove(conta);
    }

    public ContaBancaria procurarConta(int numero){
        for(ContaBancaria conta : contas){
            if(conta.getNumero() == numero){
                return conta;
            }
        }
        return null;
    }

    public ArrayList<ContaBancaria> procurarTodos(){
        return contas;
    }

    @Override
    public String mostrarDados(Integer numero) {
        for (ContaBancaria conta : contas) {
            if (conta.getNumero() == numero) {
                return conta.toString();
            }
        }
        return null;
    }
}
