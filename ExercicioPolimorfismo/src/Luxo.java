public class Luxo extends Veiculo {

    private int qtdAirbags;
    private double tamanhoPortaMalas;
    private boolean gps;

    public Luxo(String marca, String modelo, String placa, int ano, double valorLocacao, double multaRenovacao, int qtdAirbags, double tamanhoPortaMalas, boolean gps) {
        super(marca, modelo, placa, ano, valorLocacao, multaRenovacao);
        this.qtdAirbags = qtdAirbags;
        this.tamanhoPortaMalas = tamanhoPortaMalas;
        this.gps = gps;
    }

    public int getQtdAirargs() {
        return qtdAirbags;
    }

    public void setQtdAirargs(int qtdAirargs) {
        this.qtdAirbags = qtdAirargs;
    }

    public boolean isGps() {
        return gps;
    }

    public void setGps(boolean gps) {
        this.gps = Boolean.parseBoolean(String.valueOf(gps));
    }

    @Override
    public double calcularValorTotal(int numRenovacao) {
        int excesso = Math.max(0, numRenovacao - 5);
        return valorLocacao + excesso * multaRenovacao;
    }
}
