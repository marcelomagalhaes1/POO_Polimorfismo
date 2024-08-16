import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Locadora locadora = new Locadora("Locadora Magalhães", "IF Goiano Capus Morrinhos", "(64)9 9999-9999");

        while (true) {
            System.out.println("================================");
            System.out.println("Faça a escolha de alguma opção: ");
            System.out.println("1. Cadastrar veiculo: ");
            System.out.println("2. Cadastrar cliente: ");
            System.out.println("3. Fazer Emprestimo: ");
            System.out.println("4. Finalizar emprestimo: ");
            System.out.println("5. Sair\n");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:
                    System.out.println("Cadastrar veiculo: ");
                    cadastrarVeiculo(scanner, locadora);
                    break;
                case 2:
                    System.out.println("Cadastrar cliente: ");
                    cadastrarCliente(scanner, locadora);
                    break;
                case 3:
                    System.out.println("Fazer Emprestimo: ");
                    realizarEmprestimo(scanner, locadora);
                    break;
                case 4:
                    System.out.println("Finalizar emprestimo: ");
                    finalizarEmprestimo(scanner, locadora);
                    break;
                case 5:
                    System.out.println("Sair.. ");
                    scanner.close();
                    return;
            }
        }
    }

    private static void cadastrarVeiculo(Scanner scanner, Locadora locadora) {
        System.out.println("Qual tipo de veiculo deseja cadastrar? ");
        System.out.println("1: Carro Popular");
        System.out.println("2: Carro SUV");
        System.out.println("3: Carro de Luxo");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Marca: ");
        String marca = scanner.nextLine();
        System.out.print("Modelo: ");
        String modelo = scanner.nextLine();
        System.out.print("Placa: ");
        String placa = scanner.nextLine();
        System.out.print("Ano: ");
        int ano = scanner.nextInt();
        System.out.print("Valor da Locação: ");
        double valorLocacao = scanner.nextDouble();
        System.out.print("Valor da Multa por Renovação: ");
        double multaRenovacao = scanner.nextDouble();

        switch (tipo) {
            case 1:
                System.out.print("O carro possui ar-condicionado (true/false)? ");
                boolean arCondicionado = scanner.nextBoolean();
                Veiculo carroPopular = new CarroPopular(marca, modelo, placa, ano, valorLocacao, multaRenovacao, arCondicionado);
                locadora.cadastrarVeiculo(carroPopular);
                break;
            case 2:
                scanner.nextLine();
                System.out.print("Tamanho do Porta-Malas: ");
                double tamanhoPortaMalas = Double.parseDouble(scanner.nextLine());
                System.out.print("Tipo de Tração: ");
                String tipoTracao = scanner.nextLine();
                System.out.print("Tipo de Combustível: ");
                String tipoCombustivel = scanner.nextLine();
                Veiculo suv = new Suv(marca, modelo, placa, ano, valorLocacao, multaRenovacao, tamanhoPortaMalas, tipoTracao, tipoCombustivel);
                locadora.cadastrarVeiculo(suv);
                break;
            case 3:
                System.out.print("Número de Airbags: ");
                int numAirbags = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Tamanho do Porta-Malas: ");
                tamanhoPortaMalas = Double.parseDouble(scanner.nextLine());
                System.out.print("Possui GPS integrado (true/false)? ");
                boolean gps = scanner.nextBoolean();
                Veiculo carroLuxo = new Luxo(marca, modelo, placa, ano, valorLocacao, multaRenovacao, numAirbags, tamanhoPortaMalas, gps);
                locadora.cadastrarVeiculo(carroLuxo);
                break;
        }
        System.out.println("Veículo cadastrado com sucesso!\n");
    }

    private static void cadastrarCliente(Scanner scanner, Locadora locadora) {
        System.out.println("Escolha o tipo de cliente: ");
        System.out.println("1. Pessoa Física");
        System.out.println("2. Pessoa Jurídica");
        int tipo = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        switch (tipo) {
            case 1:
                System.out.print("CPF: ");
                String cpf = scanner.nextLine();
                Cliente pessoaFisica = new PessoaFisica(nome, telefone, endereco, cpf);
                locadora.cadastrarCliente(pessoaFisica);
                break;
            case 2:
                System.out.print("CNPJ: ");
                String cnpj = scanner.nextLine();
                System.out.print("Nome do Representante: ");
                String nomeRepresentante = scanner.nextLine();
                Cliente pessoaJuridica = new PessoaJuridica(nome, telefone, endereco, cnpj, nomeRepresentante);
                locadora.cadastrarCliente(pessoaJuridica);
                break;
        }
        System.out.println("Cliente cadastrado com sucesso!\n");
    }

    private static void realizarEmprestimo(Scanner scanner, Locadora locadora) {
        System.out.println("Informe a placa do veículo alugado:");
        String placa = scanner.nextLine();
        Veiculo veiculo = locadora.veiculosDisponiveis.stream().filter(v -> v.placa.equals(placa)).findFirst().orElse(null);

        if (veiculo == null) {
            System.out.println("Veículo não encontrado!");
            return;
        }

        System.out.println("Informe o nome do cliente:");
        String nomeCliente = scanner.nextLine();
        Cliente cliente = locadora.clientes.stream().filter(c -> c.nome.equals(nomeCliente)).findFirst().orElse(null);

        if (cliente == null) {
            System.out.println("Cliente não encontrado!");
            return;
        }

        if (cliente.podeRealizarEmprestimo()) {
            Emprestimo emprestimo = locadora.realizarEmprestimo(veiculo, cliente);
            if (emprestimo != null) {
                System.out.println("Empréstimo realizado com sucesso!\n");
            } else {
                System.out.println("Erro ao realizar empréstimo!\n");
            }
        } else {
            System.out.println("No momento o cliente não pode realizar outro empréstimo!\n");
        }
    }

    private static void finalizarEmprestimo(Scanner scanner, Locadora locadora) {
        System.out.println("Informe a placa do veículo a ser devolvido:");
        String placa = scanner.nextLine();

        Emprestimo emprestimo = locadora.emprestimos.stream().filter(e -> e.veiculo.placa.equals(placa) && e.ativo).findFirst().orElse(null);

        if (emprestimo == null) {
            System.out.println("Empréstimo não encontrado ou já finalizado!\n");
            return;
        }

        double valorTotal = locadora.finalizarEmprestimo(emprestimo);
        System.out.println("Empréstimo finalizado com sucesso!\n");
        System.out.println("Valor total a ser pago: R$ \n" + valorTotal);
    }
}