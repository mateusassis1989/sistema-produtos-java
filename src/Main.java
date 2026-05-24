import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        ProdutoService service = new ProdutoService();

        int opcao;

        do {

            System.out.println("\n=== MENU ===");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Editar");
            System.out.println("4 - Excluir");
            System.out.println("0 - Sair");

            opcao = sc.nextInt();

            switch (opcao) {

                case 1:

                    System.out.println("ID:");
                    int id = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Nome:");
                    String nome = sc.nextLine();

                    System.out.println("Preço:");
                    double preco = sc.nextDouble();

                    Produto produto = new Produto(id, nome, preco);

                    service.cadastrarProduto(produto);

                    break;

                case 2:

                    service.listarProdutos();

                    break;

                case 3:

                    System.out.println("ID do produto:");
                    int editarId = sc.nextInt();

                    sc.nextLine();

                    System.out.println("Novo nome:");
                    String novoNome = sc.nextLine();

                    System.out.println("Novo preço:");
                    double novoPreco = sc.nextDouble();

                    service.editarProduto(editarId, novoNome, novoPreco);

                    break;

                case 4:

                    System.out.println("ID do produto:");
                    int excluirId = sc.nextInt();

                    service.excluirProduto(excluirId);

                    break;

                case 0:

                    System.out.println("Sistema encerrado.");

                    break;

                default:

                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        sc.close();
    }
}