public abstract class Veiculo {

    private String marca;
    private String modelo;
    String placa;
    private int ano;
    double valorLocacao;
    int numRenovacao = 0;
    protected double multaRenovacao;

    public Veiculo(String marca, String modelo, String placa, int ano, double valorLocacao, double multaRenovacao) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa;
        this.ano = ano;
        this.valorLocacao = valorLocacao;
        this.multaRenovacao = multaRenovacao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public abstract double calcularValorTotal(int numRenovacao);

}
