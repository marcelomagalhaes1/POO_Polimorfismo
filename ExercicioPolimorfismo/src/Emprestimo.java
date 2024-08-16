public class Emprestimo {

    Veiculo veiculo;
    Cliente cliente;
    int numRenovacao;
    boolean ativo = true;

    public Emprestimo(Veiculo veiculo, Cliente cliente) {
        this.veiculo = veiculo;
        this.cliente = cliente;
        this.numRenovacao = 0;
    }

    public void renovarEmprestimo() {
        numRenovacao++;
    }

    public double finalizarEmprestimo() {
        ativo = false;
        return veiculo.calcularValorTotal(numRenovacao);
    }
}
