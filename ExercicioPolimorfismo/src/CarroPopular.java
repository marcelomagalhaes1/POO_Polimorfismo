public class CarroPopular extends Veiculo {

    boolean arCondicionado;

    public CarroPopular(String marca, String modelo, String placa, int ano, double valorLocacao, double multaRenovacao, boolean arCondicionado) {
        super(marca, modelo, placa, ano, valorLocacao, multaRenovacao);
        this.arCondicionado = arCondicionado;
    }

    @Override
    public double calcularValorTotal(int numRenovacao) {
        int excesso = Math.max(0, numRenovacao - 1);
        return valorLocacao + excesso * multaRenovacao;
    }
}
