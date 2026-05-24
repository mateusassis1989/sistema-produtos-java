import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProdutoService service = new ProdutoService();

        int opcao;

        do {

            System.out.println("\n===== MENU =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Editar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:

                    System.out.print("ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Preço: ");
                    double preco = sc.nextDouble();

                    Produto produto = new Produto(id, nome, preco);

                    service.cadastrarProduto(produto);

                    break;

                case 2:

                    service.listarProdutos();

                    break;

                case 3:

                    System.out.print("ID do produto: ");
                    int idEditar = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Novo nome: ");
                    String novoNome = sc.nextLine();

                    System.out.print("Novo preço: ");
                    double novoPreco = sc.nextDouble();

                    service.editarProduto(idEditar, novoNome, novoPreco);

                    break;

                case 4:

                    System.out.print("ID do produto: ");
                    int idExcluir = sc.nextInt();

                    service.excluirProduto(idExcluir);

                    break;

                case 0:

                    System.out.println("Encerrando sistema...");

                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}