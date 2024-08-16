import java.util.ArrayList;

public class Locadora {

    private String nome;
    private String endereco;
    private String telefone;
    ArrayList<Veiculo> veiculosDisponiveis = new ArrayList<>();
    ArrayList<Cliente> clientes = new ArrayList<>();
    ArrayList<Emprestimo> emprestimos = new ArrayList<>();

    public Locadora(String nome, String endereco, String telefone) {
        this.nome = nome;
        this.endereco = endereco;
        this.telefone = telefone;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void cadastrarVeiculo(Veiculo veiculo) {
        veiculosDisponiveis.add(veiculo);
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Emprestimo realizarEmprestimo(Veiculo veiculo, Cliente cliente) {
        if (cliente.podeRealizarEmprestimo() && veiculosDisponiveis.contains(veiculo)) {
            Emprestimo emprestimo = new Emprestimo(veiculo, cliente);
            emprestimos.add(emprestimo);
            veiculosDisponiveis.remove(veiculo);
            return emprestimo;
        }
        return null;
    }

    public double finalizarEmprestimo(Emprestimo emprestimo) {
        double valorTotal = emprestimo.finalizarEmprestimo();
        veiculosDisponiveis.add(emprestimo.veiculo);
        return valorTotal;
    }
}
