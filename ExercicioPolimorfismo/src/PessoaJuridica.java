public class PessoaJuridica extends Cliente {

    private String cnpj;
    private String nomeRepresentante;

    public PessoaJuridica(String nome, String endereco, String telefone, String cnpj, String nomeRepresentante) {
        super(nome, endereco, telefone);
        this.cnpj = cnpj;
        this.nomeRepresentante = nomeRepresentante;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getNomeRepresentante() {
        return nomeRepresentante;
    }

    public void setNomeRepresentante(String nomeRepresentante) {
        this.nomeRepresentante = nomeRepresentante;
    }

    @Override
    public boolean podeRealizarEmprestimo() {
        return true;
    }
}
