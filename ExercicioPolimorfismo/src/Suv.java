public class Suv extends Veiculo {

    private String tamanhoPortaMalas;
    private String tipoTracao;
    private String tipoCombustivel;

    public Suv(String marca, String modelo, String placa, int ano, double valorLocacao, double multaRenovacao, double tamanhoPortaMalas, String tipoTracao, String tipoCombustivel) {
        super(marca, modelo, placa, ano, valorLocacao, multaRenovacao);
        this.tamanhoPortaMalas = String.valueOf(tamanhoPortaMalas);
        this.tipoTracao = tipoTracao;
        this.tipoCombustivel = tipoCombustivel;
    }

    public String getTipoTracao() {
        return tipoTracao;
    }

    public void setTipoTracao(String tipoTracao) {
        this.tipoTracao = tipoTracao;
    }

    public String getTipoCombustivel() {
        return tipoCombustivel;
    }

    public void setTipoCombustivel(String tipoCombustivel) {
        this.tipoCombustivel = tipoCombustivel;
    }

    @Override
    public double calcularValorTotal(int numRenovacao) {
        int excesso = Math.max(0, numRenovacao - 3);
        return valorLocacao + excesso * multaRenovacao;
    }
}
